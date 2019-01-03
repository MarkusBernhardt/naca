/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
package com.github.markusbernhardt.naca.rt.fpacPrgEnv;

import com.github.markusbernhardt.jlib.misc.ThreadSafeCounter;

public class FPacBufferCounter {
  private static ThreadSafeCounter ms_counter = new ThreadSafeCounter();

  static int getBufferId() {
    return ms_counter.inc();
  }
}
