/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
package com.github.markusbernhardt.naca.rt.idea.onlinePrgEnv;

import com.github.markusbernhardt.naca.rt.basePrgEnv.CBaseProgramLoaderFactory;
import com.github.markusbernhardt.naca.rt.basePrgEnv.ProgramSequencer;

public class OnlineProgramLoaderFactory extends CBaseProgramLoaderFactory {
  public ProgramSequencer NewSequencer() {
    OnlineProgramLoader prog = new OnlineProgramLoader(m_connectionManager, m_tagSequencerConfig);
    prog.init(m_tagSequencerConfig);
    prog.initMailService(m_tagSequencerConfig);
    return prog;
  }
}
