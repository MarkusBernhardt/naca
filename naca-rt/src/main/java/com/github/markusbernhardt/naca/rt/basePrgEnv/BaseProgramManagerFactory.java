/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
package com.github.markusbernhardt.naca.rt.basePrgEnv;

import com.github.markusbernhardt.naca.rt.programPool.SharedProgramInstanceData;

public abstract class BaseProgramManagerFactory {
  abstract public BaseProgramManager createProgramManager(BaseProgram prg, SharedProgramInstanceData sharedProgramInstanceData,
      boolean bInheritedSharedProgramInstanceData);
}
