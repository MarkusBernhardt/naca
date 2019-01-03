/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
package com.github.markusbernhardt.naca.rt.batchPrgEnv;

import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseCESMManager;
import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseEnvironment;
import com.github.markusbernhardt.naca.rt.fpacPrgEnv.FPacProgram;

public class BatchProgram extends FPacProgram {
  public BatchProgram() {
    super();
  }

  public BaseCESMManager CESM = null;

  void prepareRunMain(BaseEnvironment e) {
    CESM = e.createCESMManager();
  }

  protected BaseCESMManager getCESM() {
    return CESM;
  }

  protected int first() {
    return NEXT;
  }

  protected int normal() {
    return NEXT;
  }

  protected int last() {
    return NEXT;
  }
}
