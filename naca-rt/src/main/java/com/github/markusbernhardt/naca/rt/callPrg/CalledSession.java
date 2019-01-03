/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
/**
 * 
 */
package com.github.markusbernhardt.naca.rt.callPrg;

import org.w3c.dom.Document;

import com.github.markusbernhardt.jlib.sql.DbConnectionManagerBase;
import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseEnvironment;
import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseProgramLoader;
import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseResourceManager;
import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseSession;
import com.github.markusbernhardt.naca.rt.basePrgEnv.CurrentUserInfo;

public class CalledSession extends BaseSession {
  public CalledSession(BaseResourceManager baseResourceManager) {
    super(baseResourceManager);
  }

  public BaseEnvironment createEnvironment(DbConnectionManagerBase connectionManager) {
    CalledEnvironment env = new CalledEnvironment(this, connectionManager, m_baseResourceManager);
    return env;
  }

  public String getType() {
    return "Batch";
  }

  public void RunProgram(BaseProgramLoader seq) {
  }

  public void setHelpPage(Document doc) {
  }

  public void fillCurrentUserInfo(CurrentUserInfo currentUserInfo) {
    currentUserInfo.reset();
  }

  public Document getLastScreenXMLData() {
    return null;
  }

}
