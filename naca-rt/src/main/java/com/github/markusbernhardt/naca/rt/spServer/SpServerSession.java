/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
/**
 * 
 */
package com.github.markusbernhardt.naca.rt.spServer;

import java.sql.Connection;

import org.w3c.dom.Document;

import com.github.markusbernhardt.jlib.misc.BasicLogger;
import com.github.markusbernhardt.jlib.sql.DbConnectionManagerBase;
import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseEnvironment;
import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseProgramLoader;
import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseResourceManager;
import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseSession;
import com.github.markusbernhardt.naca.rt.basePrgEnv.CurrentUserInfo;

public class SpServerSession extends BaseSession {
  private Connection m_connection = null;

  public SpServerSession(Connection connection, BaseResourceManager baseResourceManager) {
    super(baseResourceManager);
    m_connection = connection;
    setAsync(true);
  }

  public BaseEnvironment createEnvironment(DbConnectionManagerBase connectionManager) {
    BasicLogger.log("SpServerSession::createEnvironment()");
    SpServerEnvironment env = new SpServerEnvironment(this, connectionManager, m_baseResourceManager);
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
