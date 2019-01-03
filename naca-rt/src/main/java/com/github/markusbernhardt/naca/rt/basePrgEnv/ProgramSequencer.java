/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
package com.github.markusbernhardt.naca.rt.basePrgEnv;

import com.github.markusbernhardt.naca.rt.base.CJMapObject;
import com.github.markusbernhardt.naca.rt.programPool.SharedProgramInstanceData;

public abstract class ProgramSequencer extends CJMapObject {
  public ProgramSequencer() {
  }

  public abstract SharedProgramInstanceData forcePreloadSessionProgram(String defaultProgramName, int nNbInstanceToPreload);

  public abstract void removeSession(BaseSession session);

  public abstract void unloadProgram(String csProgramName);

  public abstract SessionEnvironmentRequester getSessionEnvironmentRequester(BaseSession appSession);

  public abstract void doHelp(CBaseMapFieldLoader fieldLoader, BaseSession session);
}
