/*
 * JLib - Publicitas Java library.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
// D:\dev\AdSpiderDriving\Logging\LoadConfigStart.java
// STModuleGen generated JLib log class

package com.github.markusbernhardt.jlib.log.stdEvents;

import com.github.markusbernhardt.jlib.log.Log;
import com.github.markusbernhardt.jlib.log.LogEvent;
import com.github.markusbernhardt.jlib.log.LogEventType;
import com.github.markusbernhardt.jlib.log.LogFlowStd;
import com.github.markusbernhardt.jlib.log.LogLevel;

public class LoadConfigStart extends LogEvent {
  public LoadConfigStart(String csProduct) {
    super(LogEventType.Remark, LogFlowStd.Monitoring, LogLevel.Important, csProduct);
  }

  public static LogEvent log(String csChannel, String csName, String csMessage) {
    return LoadConfigStart.log(csChannel, null, csName, csMessage);
  }

  public static LogEvent log(String csChannel, String csProduct, String csName, String csMessage) {
    LoadConfigStart event = new LoadConfigStart(csProduct);
    event.fillMember("Name", csName);
    Log.log(csChannel, event, csMessage);
    return event;
  }
}
