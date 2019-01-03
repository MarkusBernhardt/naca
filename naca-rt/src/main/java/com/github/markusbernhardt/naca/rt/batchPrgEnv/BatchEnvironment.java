/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
package com.github.markusbernhardt.naca.rt.batchPrgEnv;

import com.github.markusbernhardt.jlib.sql.DbConnectionManagerBase;
import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseCESMManager;
import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseEnvironment;
import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseResourceManager;
import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseSession;
import com.github.markusbernhardt.naca.rt.idea.manager.CESMManager;

public class BatchEnvironment extends BaseEnvironment {
  public BatchEnvironment(BatchSession batchSession, DbConnectionManagerBase connectionManager, BaseResourceManager baseResourceManager) {
    super(batchSession, connectionManager, baseResourceManager);
  }

  public BaseCESMManager createCESMManager() {
    return new CESMManager(this);
  }

  public BaseSession getSession() {
    return null;
  }

  public void breakCurrentSessionIfTimeout() {
  }

}
