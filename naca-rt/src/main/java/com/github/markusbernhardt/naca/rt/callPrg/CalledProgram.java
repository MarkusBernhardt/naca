/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
package com.github.markusbernhardt.naca.rt.callPrg;

import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseCESMManager;
import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseEnvironment;
import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseProgram;
import com.github.markusbernhardt.naca.rt.varEx.VarSectionDeclaration;

public class CalledProgram extends BaseProgram {
  private static CalledProgramManagerFactory ms_callProgramManagerFactory = new CalledProgramManagerFactory();

  public CalledProgram() {
    super(ms_callProgramManagerFactory);
    declare = new VarSectionDeclaration(this);
  }

  void prepareRunMain(BaseEnvironment e) {
    CESM = e.createCESMManager();
  }

  protected BaseCESMManager getCESM() {
    return CESM;
  }

  public BaseCESMManager CESM = null;
  protected VarSectionDeclaration declare = null;
}
