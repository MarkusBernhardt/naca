/*
 * JLib - Publicitas Java library.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
package com.github.markusbernhardt.jlib.jmxMBean;

import javax.management.openmbean.OpenType;

public class CompositeTypeDescItem {
  CompositeTypeDescItem(String csName, String csDescription, OpenType openType) {
    m_csName = csName;
    m_csDescription = csDescription;
    m_openType = openType;
  }

  String m_csName = null;
  String m_csDescription = null;
  OpenType m_openType = null;

}
