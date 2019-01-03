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
import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseSession;
import com.github.markusbernhardt.naca.rt.varEx.FileDescriptor;

/**
 *
 * @author Pierre-Jean Ditscheid, Consultas SA
 * @version $Id: SQLFileExecutor.java,v 1.9 2006/08/08 05:53:12 u930di Exp $
 */
public class SQLFileExecutor extends BaseSQLUtils {
  public SQLFileExecutor(BaseSession session, DbConnectionBase dbConnection) {
    super(session, dbConnection);
  }

  public boolean execute(FileDescriptor fileIn) {
    FileSysinReader fileSysinReader = new FileSysinReader(getSession());
    return fileSysinReader.parse(this, fileIn);
  }

  int executeStatement(String csClause) {
    return executeSQLClause(csClause);
  }
}
