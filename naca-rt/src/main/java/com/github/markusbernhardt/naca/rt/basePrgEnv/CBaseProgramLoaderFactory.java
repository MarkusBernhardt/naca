/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
package com.github.markusbernhardt.naca.rt.basePrgEnv;

import com.github.markusbernhardt.jlib.log.Log;
import com.github.markusbernhardt.jlib.sql.DbConnectionBase;
import com.github.markusbernhardt.jlib.sql.DbConnectionException;
import com.github.markusbernhardt.jlib.sql.DbConnectionPool;
import com.github.markusbernhardt.jlib.xml.Tag;
import com.github.markusbernhardt.naca.rt.sqlSupport.SQLCode;
import com.github.markusbernhardt.naca.rt.sqlSupport.SQLConnectionManager;

public abstract class CBaseProgramLoaderFactory // extends SequencerFactory
{
  protected SQLConnectionManager m_connectionManager = null;
  protected Tag m_tagSequencerConfig = null;

  public abstract ProgramSequencer NewSequencer();

  public CBaseProgramLoaderFactory() {
    m_connectionManager = new SQLConnectionManager();
  }

  public void init(String csDBParameterPrefix, Tag tagSequencerConfig) // , ClassLoaderUnloader loader)
  {
    if (tagSequencerConfig != null) {
      m_tagSequencerConfig = tagSequencerConfig;

      Tag tagSQLConfig = tagSequencerConfig.getChild("SQLConfig");
      if (tagSQLConfig != null) {
        DbConnectionPool dbConnectionPool = m_connectionManager.init(csDBParameterPrefix, tagSQLConfig);
        BaseResourceManager.addDbConnectionPool(dbConnectionPool);

        // Load connection killer SQLcodes
        Tag tagConnectionKillerSQLCodes = tagSQLConfig.getChild("ConnectionKillerSQLCodes");
        if (tagConnectionKillerSQLCodes != null) {
          SQLCode.fillConnectionKillerSQLCodes(tagConnectionKillerSQLCodes);
        }
      }
    }
  }

  public DbConnectionBase getConnection(String csProgramId, boolean bUseStatementCache) {
    if (m_connectionManager != null) {
      try {
        return m_connectionManager.getConnection(csProgramId, bUseStatementCache);
      } catch (DbConnectionException e) {
        Log.logImportant("Db connection error: " + e.toString());
      }
    }
    return null;
  }
}
