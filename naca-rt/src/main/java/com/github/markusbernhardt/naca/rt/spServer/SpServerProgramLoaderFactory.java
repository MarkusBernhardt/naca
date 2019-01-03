/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
/**
 * 
 */
package com.github.markusbernhardt.naca.rt.spServer;

import com.github.markusbernhardt.jlib.misc.BasicLogger;
import com.github.markusbernhardt.naca.rt.basePrgEnv.CBaseProgramLoaderFactory;
import com.github.markusbernhardt.naca.rt.basePrgEnv.ProgramSequencer;

public class SpServerProgramLoaderFactory extends CBaseProgramLoaderFactory {
  public ProgramSequencer NewSequencer() {
    BasicLogger.log("SpServerProgramLoaderFactory::NewSequencer() (with exception handler)");

    if (m_connectionManager != null)
      BasicLogger.log("m_connectionManager=" + m_connectionManager.toString());
    else
      BasicLogger.log("m_connectionManager=null");

    if (m_connectionManager != null)
      BasicLogger.log("m_tagSequencerConfig=" + m_tagSequencerConfig.toString());
    else
      BasicLogger.log("m_tagSequencerConfig=null");
    try {
      SpServerProgramLoader prog = new SpServerProgramLoader(null, null);
      prog.initMailService(m_tagSequencerConfig);
      BasicLogger.log("SpServerProgramLoaderFactory::NewSequencer; SpServerProgramLoader=" + prog.toString());
      return prog;
    } catch (Exception e) {
      BasicLogger.log("SpServerProgramLoaderFactory::NewSequencer; Exception catched=" + e.toString());
      return null;
    }
  }
}
