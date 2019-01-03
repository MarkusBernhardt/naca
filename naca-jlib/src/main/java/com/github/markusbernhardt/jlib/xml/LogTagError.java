/*
 * JLib - Publicitas Java library.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
package com.github.markusbernhardt.jlib.xml;

import com.github.markusbernhardt.jlib.log.Log;
import com.github.markusbernhardt.jlib.log.LogEvent;
import com.github.markusbernhardt.jlib.log.LogEventType;
import com.github.markusbernhardt.jlib.log.LogExceptionEvent;
import com.github.markusbernhardt.jlib.log.LogFlowStd;
import com.github.markusbernhardt.jlib.log.LogLevel;

public class LogTagError extends LogExceptionEvent {
  public LogTagError() {
    super(LogEventType.Error, LogFlowStd.Any, LogLevel.Debug);
  }

  public static LogEvent log(Exception e) {
    LogTagError event = new LogTagError();
    event.fillExceptionMembers(e);
    Log.log(null, event, "Exception");
    return event;
  }
}