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
import com.github.markusbernhardt.jlib.threads.BasePooledThreadFactory;
import com.github.markusbernhardt.jlib.threads.PoolOfThreads;
import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseEnvironment;

/**
 *
 * @author Pierre-Jean Ditscheid, Consultas SA
 * @version $Id$
 */
public class PooledThreadDbTransferFactory extends BasePooledThreadFactory {
  private DbTransferDesc m_dbTransferDesc = null;
  private BaseEnvironment m_env = null;

  PooledThreadDbTransferFactory(DbTransferDesc dbTransferDesc, BaseEnvironment env) {
    m_dbTransferDesc = dbTransferDesc;
    m_env = env;
  }

  public PooledThreadDbTransfer make(PoolOfThreads owningPool) {
    DbConnectionBase dbConnectionSource = m_env.getNewSQLConnection();
    DbConnectionBase dbConnectionDestination = m_dbTransferDesc.getNewDestinationConnection();
    PooledThreadDbTransfer thread = new PooledThreadDbTransfer(owningPool, m_dbTransferDesc, dbConnectionSource, dbConnectionDestination);
    return thread;
  }
}
