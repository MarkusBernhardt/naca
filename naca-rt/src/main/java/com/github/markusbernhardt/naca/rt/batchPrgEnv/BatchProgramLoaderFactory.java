/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
package com.github.markusbernhardt.naca.rt.batchPrgEnv;

import com.github.markusbernhardt.naca.rt.basePrgEnv.CBaseProgramLoaderFactory;
import com.github.markusbernhardt.naca.rt.basePrgEnv.ProgramSequencer;

public class BatchProgramLoaderFactory extends CBaseProgramLoaderFactory {
  public ProgramSequencer NewSequencer() {
    BatchProgramLoader prog = new BatchProgramLoader(m_connectionManager, m_tagSequencerConfig);
    prog.initMailService(m_tagSequencerConfig);
    return prog;
  }
}
