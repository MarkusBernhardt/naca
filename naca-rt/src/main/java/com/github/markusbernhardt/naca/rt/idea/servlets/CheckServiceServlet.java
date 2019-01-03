/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
package com.github.markusbernhardt.naca.rt.idea.servlets;

import javax.servlet.http.HttpServletRequest;

import com.github.markusbernhardt.jlib.sql.DbConnectionBase;
import com.github.markusbernhardt.naca.rt.appOpening.CalendarOpenState;
import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseEnvironment;
import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseProgramLoader;
import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseResourceManager;
import com.github.markusbernhardt.naca.rt.idea.onlinePrgEnv.OnlineResourceManager;
import com.github.markusbernhardt.naca.rt.idea.onlinePrgEnv.OnlineResourceManagerFactory;
import com.github.markusbernhardt.naca.rt.idea.onlinePrgEnv.OnlineSession;

public class CheckServiceServlet extends BaseCheckServiceServlet {
  private static final long serialVersionUID = 1L;
  private OnlineResourceManager m_ResourceManager = OnlineResourceManagerFactory.GetInstance();

  protected String getServiceName() {
    return "NACA - " + m_ResourceManager.getServerName();
  }

  protected boolean getServiceStatus(HttpServletRequest req, StringBuffer errCode) {
    if (BaseResourceManager.isInUpdateMode()) {
      errCode.append("Application is in update mode");
      return true;
    }

    CalendarOpenState openState = BaseResourceManager.getAppOpenState();
    if (openState != CalendarOpenState.AppOpened) {
      errCode.append("Application closed");
      return true;
    }

    OnlineSession session = new OnlineSession(false);
    BaseProgramLoader loader = BaseProgramLoader.GetProgramLoaderInstance();
    BaseEnvironment env = loader.GetEnvironment(session, null, null);

    try {
      // env.getSQLConnection();
      // env.commitSQL();
      // env.releaseSQLConnection();

      DbConnectionBase conn = env.getNewSQLConnection();
      env.resetSession();
      if (conn == null) {
        errCode.append("Problem access database");
        return false;
      }
    } catch (Exception ex) {
      env.resetSession();
      errCode.append("Problem access database");
      return false;
    }

    errCode.append("Application ok");
    return true;
  }
}