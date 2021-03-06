/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
package com.github.markusbernhardt.naca.rt.exceptions;

import com.github.markusbernhardt.naca.rt.program.Section;

public class CGotoOtherSectionException extends NacaRTException {
  private static final long serialVersionUID = 1L;
  public Section m_Section = null;

  public CGotoOtherSectionException(Section section) {
    super();
    m_Section = section;
  }
}
