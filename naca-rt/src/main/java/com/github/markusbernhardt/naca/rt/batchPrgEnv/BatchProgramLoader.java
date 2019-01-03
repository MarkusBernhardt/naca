/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
package com.github.markusbernhardt.naca.rt.batchPrgEnv;

import com.github.markusbernhardt.jlib.sql.DbConnectionManagerBase;
import com.github.markusbernhardt.jlib.xml.Tag;
import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseProgramLoader;
import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseSession;
import com.github.markusbernhardt.naca.rt.basePrgEnv.CBaseMapFieldLoader;
import com.github.markusbernhardt.naca.rt.exceptions.AbortSessionException;

public class BatchProgramLoader extends BaseProgramLoader {
  public BatchProgramLoader(DbConnectionManagerBase connectionManager, Tag tagSequencerConfig) {
    super(connectionManager, tagSequencerConfig, true);
  }

  public void RunProgram(BaseSession appSession) throws AbortSessionException {
  }

  public static BatchProgramLoader GetProgramLoaderInstance() {
    return (BatchProgramLoader) ms_Instance;
  }

  public void doHelp(CBaseMapFieldLoader fieldLoader, BaseSession session) {
  }
}
