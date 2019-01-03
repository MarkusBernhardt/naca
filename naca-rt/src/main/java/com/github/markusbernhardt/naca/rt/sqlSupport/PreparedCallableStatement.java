/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
/**
 * 
 */
package com.github.markusbernhardt.naca.rt.sqlSupport;

import java.sql.CallableStatement;

import com.github.markusbernhardt.jlib.sql.DbPreparedCallableStatement;

/**
 *
 * @author Pierre-Jean Ditscheid, Consultas SA
 * @version $Id: PreparedCallableStatement.java,v 1.1 2006/08/30 15:31:57 u930di
 *          Exp $
 */
public class PreparedCallableStatement extends DbPreparedCallableStatement {
  PreparedCallableStatement(CallableStatement callableStatement) {
    super(callableStatement);
  }
}
