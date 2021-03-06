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
 * @deprecated Use {@link EventProgress} instead.
 */
public class LogEventProgress extends LogEvent {
  public LogEventProgress(String csProduct) {
    super(LogEventType.Progress, LogFlowStd.Any, LogLevel.Normal, csProduct);
  }

  public static LogEvent log(String csChannel, int nNbItemsProcessed, int nNbItemsToProcess, String csMessage) {
    return LogEventProgress.log(csChannel, null, nNbItemsProcessed, nNbItemsToProcess, csMessage);
  }

  public static LogEvent log(String csChannel, String csProduct, int nNbItemsProcessed, int nNbItemsToProcess, String csMessage) {
    LogEventProgress event = new LogEventProgress(csProduct);
    event.fillMember("processedItems", nNbItemsProcessed);
    event.fillMember("totalItems", nNbItemsToProcess);
    Log.log(csChannel, event, csMessage);
    return event;
  }

  public static LogEvent log(String csChannel, String csProduct, int nNbItemsProcessed, int nNbItemsToProcess, String csMessage, String csRunId,
      String csRuntimeId) {
    LogEventProgress event = new LogEventProgress(csProduct);
    event.fillMember("processedItems", nNbItemsProcessed);
    event.fillMember("totalItems", nNbItemsToProcess);
    Log.log(csChannel, event, csMessage, csRunId, csRuntimeId);
    return event;
  }
}
