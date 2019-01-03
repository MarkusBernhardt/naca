/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
/**
 * 
 */
package com.github.markusbernhardt.naca.rt.callPrg;

import com.github.markusbernhardt.naca.rt.basePrgEnv.CBaseProgramLoaderFactory;
import com.github.markusbernhardt.naca.rt.basePrgEnv.ProgramSequencer;

public class CalledProgramLoaderFactory extends CBaseProgramLoaderFactory {
  public ProgramSequencer NewSequencer() {
    CalledProgramLoader prog = new CalledProgramLoader(m_connectionManager, m_tagSequencerConfig);
    if (m_tagSequencerConfig != null)
      prog.initMailService(m_tagSequencerConfig);
    return prog;
  }
}
