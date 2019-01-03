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

import com.github.markusbernhardt.jlib.xml.Tag;
import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseEnvironment;

/**
 *
 * @author Pierre-Jean Ditscheid, Consultas SA
 * @version $Id$
 */
public class DbTransfer {
  private DbTransferDesc m_dbTransferDesc = null;

  public DbTransfer() {
  }

  public int execute(BaseEnvironment env, String csConfigFile) {
    Tag tagRoot = Tag.createFromFile(csConfigFile);
    if (tagRoot != null) {
      Tag tagDbTransfer = tagRoot.getChild("DBTR");
      if (tagDbTransfer != null) {
        m_dbTransferDesc = new DbTransferDesc();
        boolean b = m_dbTransferDesc.load(tagDbTransfer);
        if (b)
          b = m_dbTransferDesc.getTablesList(env);
        if (b)
          b = m_dbTransferDesc.doTransfers(env);
        if (b)
          return 0;
      }
    }
    return -1;
  }
}
