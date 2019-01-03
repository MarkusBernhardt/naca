/*
 * JLib - Publicitas Java library.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
package com.github.markusbernhardt.jlib.misc;

import java.io.File;
import java.io.FilenameFilter;

public class FileFilterBySuffix implements FilenameFilter {
  private String m_csSuffix = null;

  public FileFilterBySuffix(String csSuffix) {
    m_csSuffix = csSuffix.toUpperCase();
  }

  public boolean accept(File dir, String csName) {
    if (m_csSuffix != null && csName != null) {
      String cs = csName.toUpperCase();
      if (cs.endsWith(m_csSuffix))
        return true;
    }
    return false;
  }
}
