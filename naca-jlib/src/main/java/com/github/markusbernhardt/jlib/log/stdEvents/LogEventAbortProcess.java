/*
 * JLib - Publicitas Java library.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
package com.github.markusbernhardt.jlib.log.stdEvents;

import com.github.markusbernhardt.jlib.log.Log;
import com.github.markusbernhardt.jlib.log.LogEvent;
import com.github.markusbernhardt.jlib.log.LogEventType;
import com.github.markusbernhardt.jlib.log.LogFlowStd;
import com.github.markusbernhardt.jlib.log.LogLevel;

/**
 * @deprecated Use {@link EventAbort} instead.
 */
public class LogEventAbortProcess extends LogEvent {
  public LogEventAbortProcess(String csProduct) {
    super(LogEventType.Abort, LogFlowStd.Any, LogLevel.Critical, csProduct);
  }

  public static LogEvent log(String csChannel) {
    return LogEventAbortProcess.log(csChannel);
  }

  public static LogEvent log(String csChannel, String csProduct) {
    LogEventAbortProcess event = new LogEventAbortProcess(csProduct);
    Log.log(csChannel, event, "");
    return event;
  }

  public static LogEvent log(String csChannel, String csProduct, String csRunId, String csRuntimeId) {
    LogEventAbortProcess event = new LogEventAbortProcess(csProduct);
    Log.log(csChannel, event, "", csRunId, csRuntimeId);
    return event;
  }
}
