/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
/*
 * Created on 21 oct. 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

/**
 * @author sly
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.github.markusbernhardt.naca.rt.CESM;

import com.github.markusbernhardt.jlib.log.Log;
import com.github.markusbernhardt.naca.rt.base.CJMapObject;
import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseEnvironment;
import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseProgramLoader;
import com.github.markusbernhardt.naca.rt.misc.CCommarea;
import com.github.markusbernhardt.naca.rt.varEx.Var;

public class CESMLink extends CJMapObject {
  protected BaseEnvironment m_Environment = null;
  protected String m_csProgramClassName = null;

  public CESMLink(BaseEnvironment env, String csProgramClassName) {
    m_Environment = env;
    m_csProgramClassName = csProgramClassName;
  }

  public void go() {
    if (isLogCESM)
      Log.logDebug("Linking program: " + m_csProgramClassName);
    BaseProgramLoader baseProgramLoader = BaseProgramLoader.GetProgramLoaderInstance();
    baseProgramLoader.runSubProgram(m_csProgramClassName, null, m_Environment);
  }

  public void commarea(Var var, int length) {
    if (isLogCESM)
      Log.logDebug("Linking program: " + m_csProgramClassName);
    BaseProgramLoader baseProgramLoader = BaseProgramLoader.GetProgramLoaderInstance();
    CCommarea comm = new CCommarea();
    m_Environment.setCommarea(comm);
    comm.setVarPassedByRef(var);
    baseProgramLoader.runSubProgram(m_csProgramClassName, null, m_Environment);
  }

  public void commarea(Var var) {
    commarea(var, -1);
  }

  public void commarea(Var v, Var length) {
    int l = length.getInt();
    commarea(v, l);
  }

  public void commarea(Var var, int length, int datalength) {
    commarea(var, length);
  }

  public void commarea(Var var, Var length, int datalength) {
    int l = length.getInt();
    commarea(var, l);
  }
}