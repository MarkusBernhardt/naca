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
 * @deprecated Use {@link EventFinish} instead.
 * @author PJD
 */
public class LogEventStopProcess extends LogEvent {
  public LogEventStopProcess(String csProduct) {
    super(LogEventType.Stop, LogFlowStd.Any, LogLevel.Critical, csProduct);
  }

  public static LogEvent log(String csChannel) {
    return LogEventStopProcess.log(csChannel, null);
  }

  public static LogEvent log(String csChannel, String csProduct) {
    LogEventStopProcess event = new LogEventStopProcess(csProduct);
    Log.log(csChannel, event, "");
    return event;
  }

  public static LogEvent log(String csChannel, String csProduct, String csRunId, String csRuntimeId) {
    LogEventStopProcess event = new LogEventStopProcess(csProduct);
    Log.log(csChannel, event, "", csRunId, csRuntimeId);
    return event;
  }
}
