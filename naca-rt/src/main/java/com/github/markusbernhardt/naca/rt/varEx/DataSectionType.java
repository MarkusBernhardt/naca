/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
package com.github.markusbernhardt.naca.rt.varEx;

public class DataSectionType {
  public static DataSectionType Working = new DataSectionType();
  public static DataSectionType Linkage = new DataSectionType();
  public static DataSectionType File = new DataSectionType();

  private DataSectionType() {
  }
}
