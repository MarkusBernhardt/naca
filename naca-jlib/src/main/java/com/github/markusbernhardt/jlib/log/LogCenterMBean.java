/*
 * JLib - Publicitas Java library.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
package com.github.markusbernhardt.jlib.log;

public interface LogCenterMBean {
  public boolean getEnable();

  public void setEnable(boolean b);

  public String getLevel();

  public void setLevel(String csLevel);
}
