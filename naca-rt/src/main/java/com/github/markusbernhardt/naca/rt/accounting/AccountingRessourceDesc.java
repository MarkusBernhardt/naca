/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
package com.github.markusbernhardt.naca.rt.accounting;

import com.github.markusbernhardt.jlib.log.Log;
import com.github.markusbernhardt.jlib.misc.StringUtil;
import com.github.markusbernhardt.jlib.sql.DbConnectionBase;
import com.github.markusbernhardt.jlib.sql.DbConnectionException;
import com.github.markusbernhardt.jlib.sql.DbConnectionPool;
import com.github.markusbernhardt.jlib.sql.DbPreparedStatement;
import com.github.markusbernhardt.jlib.xml.Tag;
import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseResourceManager;
import com.github.markusbernhardt.naca.rt.sqlSupport.SQLConnectionManager;

/**
 *
 * @author Pierre-Jean Ditscheid, Consultas SA
 * @version $Id: AccountingRessourceDesc.java,v 1.13 2007/02/19 16:44:49 u930di
 *          Exp $
 */
public class AccountingRessourceDesc {
  public AccountingRessourceDesc() {
  }

  public void load(Tag tagAccounting) {
    if (tagAccounting != null) {
      m_csTableName = tagAccounting.getVal("TableName");
      m_csMachineId = tagAccounting.getVal("MachineId");
      m_csTomcatId = tagAccounting.getVal("TomcatId");
      m_connectionManager = new SQLConnectionManager();
      DbConnectionPool dbConnectionPool = m_connectionManager.init("", tagAccounting);
      BaseResourceManager.addDbConnectionPool(dbConnectionPool);
      m_nMaxLevelDepth = tagAccounting.getValAsInt("MaxLevelDepth");
      String csDbEnvironment = tagAccounting.getVal("dbenvironment");
      if (csDbEnvironment != null && !StringUtil.isEmpty(csDbEnvironment))
        m_csTableName = csDbEnvironment + "." + m_csTableName;
      m_csInsertClause = "Insert into " + m_csTableName
          + "(SESSIONID, TRANSACTIONID, START_TIMESTAMP, LEVEL_DEPTH, TRANSACTIONNAME, PROGRAMNAME, SESSIONTYPE, MACHINEID, TOMCATID, RUNTIME_MS, TERMINALID, LUNAME, USERLDAPID, CRITERIAEND, NBSELECT, NBINSERT, NBUPDATE, NBDELETE, NBOPENCURSOR, NBFETCHCURSOR, PROFITCENTERP2000, USERIDP2000, DB_IO_TIME_MS, NETWORK_MS)"
          + " values " + "(?, ?, ?, ?, ?, ?,	?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,	?, ?, ?, ?,	?, ?)";
    } else {
      Log.logCritical("No Accounting tag in .cfg file: Accouting is disabled");
    }
  }

  String getMachineId() {
    return m_csMachineId;
  }

  String getTomcatId() {
    return m_csTomcatId;
  }

  boolean canWrite(int nCurrentDepth) {
    if (nCurrentDepth <= m_nMaxLevelDepth)
      return true;
    return false;
  }

  DbConnectionBase getConnection() {
    if (m_connectionManager != null) {
      try {
        DbConnectionBase dbConnection = m_connectionManager.getConnection("Accounting", true);
        return dbConnection;
      } catch (DbConnectionException e) {
        Log.logCritical("Could not get DB connection for accounting !");
      }
    }
    return null;
  }

  DbPreparedStatement getInsertStatement(DbConnectionBase dbConnection) {
    DbPreparedStatement st = dbConnection.prepareStatement(m_csInsertClause, 0, false);
    return st;
  }

  void returnConnection(DbConnectionBase dbConnection) {
    m_connectionManager.returnConnection(dbConnection);
  }

  private SQLConnectionManager m_connectionManager = null;
  private String m_csTableName = null;
  private String m_csMachineId = null;
  private String m_csTomcatId = null;
  private int m_nMaxLevelDepth = 0;
  private String m_csInsertClause = null;
}
