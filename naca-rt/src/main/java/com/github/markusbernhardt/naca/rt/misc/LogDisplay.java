/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
package com.github.markusbernhardt.naca.rt.misc;

import com.github.markusbernhardt.jlib.log.Log;
import com.github.markusbernhardt.jlib.log.LogEvent;
import com.github.markusbernhardt.jlib.log.LogEventType;
import com.github.markusbernhardt.jlib.log.LogLevel;

public class LogDisplay extends LogEvent {
  public LogDisplay() {
    super(LogEventType.Start, LogFlowCustomNacaRT.Display, LogLevel.Normal, null);
  }

  public static LogEvent log(String csMessage) {
    LogDisplay event = new LogDisplay();
    Log.log("NacaRT", event, csMessage);
    return event;
  }
}
