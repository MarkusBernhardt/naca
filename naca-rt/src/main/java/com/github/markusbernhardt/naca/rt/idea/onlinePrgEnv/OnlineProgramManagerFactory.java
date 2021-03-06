/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
package com.github.markusbernhardt.naca.rt.idea.onlinePrgEnv;

import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseProgram;
import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseProgramManager;
import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseProgramManagerFactory;
import com.github.markusbernhardt.naca.rt.programPool.SharedProgramInstanceData;

public class OnlineProgramManagerFactory extends BaseProgramManagerFactory {
  public BaseProgramManager createProgramManager(BaseProgram prg, SharedProgramInstanceData sharedProgramInstanceData,
      boolean bInheritedSharedProgramInstanceData) {
    return new OnlineProgramManager(prg, sharedProgramInstanceData, bInheritedSharedProgramInstanceData);
  }
}
