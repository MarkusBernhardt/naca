/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
/*
 * Created on 14 avr. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.github.markusbernhardt.naca.rt.varEx;

/**
 * @author PJD
 *
 *         TODO To change the template for this generated type comment go to
 *         Window - Preferences - Java - Code Style - Code Templates
 */
public class FoundFlag {
  FoundFlag() {
  }

  void setFound() {
    m_b = true;
  }

  boolean isFound() {
    return m_b;
  }

  private boolean m_b = false;
}
