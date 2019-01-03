/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
package com.github.markusbernhardt.naca.rt.idea.emulweb;

import com.github.markusbernhardt.jlib.misc.ThreadSafeCounter;

public class ThreadEmulWeb extends Thread {
  public ThreadEmulWeb(ThreadSafeCounter counter, EmulWebThreadedRun emulWebRun) {
    m_counter = counter;
    m_emulWebRun = emulWebRun;
  }

  public void run() {
    m_emulWebRun.run();
    m_counter.dec();
  }

  public void requestStop() {
    interrupt();
  }

  private EmulWebThreadedRun m_emulWebRun = null;
  private ThreadSafeCounter m_counter = null;
}