/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
package com.github.markusbernhardt.naca.rt.misc;

import com.github.markusbernhardt.jlib.log.LogFlow;
import com.github.markusbernhardt.jlib.log.LogFlowStd;

public class LogFlowDisplay extends LogFlow {
  protected LogFlowDisplay() {
    super("LogFlowDisplay");
  }

  public boolean isAcceptable(LogFlow logFlow) {
    return this == logFlow || logFlow == LogFlowStd.Any;
  }
}
