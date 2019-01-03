/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
/*
 * Created on 21 avr. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.github.markusbernhardt.naca.rt.asyncTasks;

import com.github.markusbernhardt.jlib.misc.Time_ms;
import com.github.markusbernhardt.naca.rt.CESM.CESMStartData;
import com.github.markusbernhardt.naca.rt.accounting.CriteriaEndRunMain;
import com.github.markusbernhardt.naca.rt.appOpening.CalendarOpenState;
import com.github.markusbernhardt.naca.rt.base.CJMapObject;
import com.github.markusbernhardt.naca.rt.basePrgEnv.AsyncThreadJmxManager;
import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseEnvironment;
import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseProgramLoader;
import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseResourceManager;
import com.github.markusbernhardt.naca.rt.exceptions.AbortSessionException;
import com.github.markusbernhardt.naca.rt.idea.onlinePrgEnv.OnlineSession;

/**
 * @author U930CV
 *
 *         TODO To change the template for this generated type comment go to
 *         Window - Preferences - Java - Code Style - Code Templates
 */
public class CAsynchronousTask extends CJMapObject implements Runnable {
  private String m_csProgramParent = null;
  private String m_csProgramToRun = null;
  private int m_nDelaySeconds = 0;
  private Thread m_Thread = null;
  private boolean m_bInvalidate = false;
  private CESMStartData m_startData = null;

  public CAsynchronousTask(String csProgramToRun, String csProgramParent, CESMStartData startData, int nDelaySeconds) {
    m_csProgramToRun = csProgramToRun;
    m_csProgramParent = csProgramParent;
    m_nDelaySeconds = nDelaySeconds;
    m_startData = startData;
    m_Thread = new Thread(this, csProgramToRun);
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Runnable#run()
   */
  public void run() {
    boolean bUseJmx = BaseResourceManager.getUsingJmx();

    long lThreadId = m_Thread.getId();
    String csThreadId = String.valueOf(lThreadId);
    String csThreadName = m_Thread.getName();

    if (bUseJmx) {
      AsyncThreadJmxManager.startAsyncProgram(csThreadId, csThreadName, m_csProgramToRun, m_csProgramParent, m_nDelaySeconds);
    }

    Time_ms.wait_ms(m_nDelaySeconds * 1000);

    while (BaseResourceManager.isInUpdateMode()) {
      Time_ms.wait_ms(1 * 60 * 1000);
    }

    CalendarOpenState openState = BaseResourceManager.getAppOpenState();
    while (openState != CalendarOpenState.AppOpened) {
      Time_ms.wait_ms(5 * 60 * 1000);
      openState = BaseResourceManager.getAppOpenState();
    }

    if (m_bInvalidate) {
      return;
    }

    OnlineSession session = new OnlineSession(true);
    BaseProgramLoader loader = BaseProgramLoader.GetProgramLoaderInstance();
    BaseEnvironment env = loader.GetEnvironment(session, m_csProgramToRun, m_csProgramParent);

    env.startRunTransaction();

    env.enqueueData(m_startData);

    try {
      if (bUseJmx)
        AsyncThreadJmxManager.setRunningAsyncProgram(csThreadId, csThreadName);

      loader.runTopProgram(env, null);
      env.endRunTransaction(CriteriaEndRunMain.Normal);
      env.resetSession();
    } catch (AbortSessionException e) {
      env.endRunTransaction(CriteriaEndRunMain.Abort);
      env.resetSession();
    } catch (Exception e) {
      env.endRunTransaction(CriteriaEndRunMain.Abort);
      env.resetSession();
    }
    if (bUseJmx)
      AsyncThreadJmxManager.endAsyncProgram(csThreadId, csThreadName);
  }

  public void Start() {
    if (!m_bInvalidate) {
      m_Thread.start();
    } else {
      m_Thread = null;
    }
  }

  public void Wait() {
    if (m_Thread != null) {
      try {
        m_Thread.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public void Invalidate() {
    m_bInvalidate = true;
    m_Thread.interrupt();
  }
}
