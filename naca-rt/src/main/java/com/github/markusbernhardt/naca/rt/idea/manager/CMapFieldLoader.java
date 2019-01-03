/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
package com.github.markusbernhardt.naca.rt.idea.manager;

import com.github.markusbernhardt.naca.rt.basePrgEnv.CBaseMapFieldLoader;
import com.github.markusbernhardt.naca.rt.misc.KeyPressed;

public abstract class CMapFieldLoader extends CBaseMapFieldLoader {
  public void setKeyPressed(KeyPressed kp2) {
    m_KeyPressed = kp2;
  }

  public KeyPressed getKeyPressed() {
    return m_KeyPressed;
  }

  protected KeyPressed m_KeyPressed = null;
}
