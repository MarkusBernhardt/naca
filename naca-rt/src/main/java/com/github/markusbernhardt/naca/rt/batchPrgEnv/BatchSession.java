/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
package com.github.markusbernhardt.naca.rt.batchPrgEnv;

import org.w3c.dom.Document;

import com.github.markusbernhardt.jlib.sql.DbConnectionManagerBase;
import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseEnvironment;
import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseProgramLoader;
import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseResourceManager;
import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseSession;
import com.github.markusbernhardt.naca.rt.basePrgEnv.CurrentUserInfo;

public class BatchSession extends BaseSession {
  public BatchSession(BaseResourceManager baseResourceManager) {
    super(baseResourceManager);
  }

  public BaseEnvironment createEnvironment(DbConnectionManagerBase connectionManager) {
    BatchEnvironment env = new BatchEnvironment(this, connectionManager, m_baseResourceManager);
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

  // public void addBatchFile(String csLogicalName, String csPath)
  // {
  // addBatchFile(csLogicalName, csPath, false, false, 0);
  // }
  //
  //
  // public void addBatchFile(String csLogicalName, String csPath, boolean
  // bEbcdic)
  // {
  // addBatchFile(csLogicalName, csPath, bEbcdic, false, 0);
  // }
  //
  //
  // public void addBatchFile(String csLogicalName, String csPath, boolean
  // bEbcdic, boolean bExt)
  // {
  // addBatchFile(csLogicalName, csPath, bEbcdic, bExt, 0);
  // }

}
