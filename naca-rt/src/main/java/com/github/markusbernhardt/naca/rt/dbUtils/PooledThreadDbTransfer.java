/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
/**
 * 
 */
package com.github.markusbernhardt.naca.rt.dbUtils;

import com.github.markusbernhardt.jlib.sql.DbConnectionBase;
import com.github.markusbernhardt.jlib.threads.PoolOfThreads;
import com.github.markusbernhardt.jlib.threads.PooledThread;
import com.github.markusbernhardt.jlib.threads.ThreadPoolRequest;

/**
 *
 * @author Pierre-Jean Ditscheid, Consultas SA
 * @version $Id$
 */
public class PooledThreadDbTransfer extends PooledThread {
  private DbTransferDesc m_dbTransferDesc = null;
  private DbConnectionBase m_dbConnectionSource = null;
  private DbConnectionBase m_dbConnectionDestination = null;

  public PooledThreadDbTransfer(PoolOfThreads owningPool, DbTransferDesc dbTransferDesc, DbConnectionBase dbConnectionSource,
      DbConnectionBase dbConnectionDestination) {
    super(owningPool);
    m_dbTransferDesc = dbTransferDesc;
    m_dbConnectionSource = dbConnectionSource;
    m_dbConnectionDestination = dbConnectionDestination;
  }

  public boolean preRun() {
    return true;
  }

  public void postRun() {
  }

  protected boolean canHandleRequest() {
    return true;
  }

  protected void handleRequest(ThreadPoolRequest request) {
    TableToTransfer tableToTransfer = (TableToTransfer) request;
    tableToTransfer.execute(m_dbConnectionSource, m_dbConnectionDestination, m_dbTransferDesc);
  }
}