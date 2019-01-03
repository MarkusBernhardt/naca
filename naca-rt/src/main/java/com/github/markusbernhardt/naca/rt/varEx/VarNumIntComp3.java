/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
/*
 * Created on 18 mars 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.github.markusbernhardt.naca.rt.varEx;

import com.github.markusbernhardt.jlib.misc.AsciiEbcdicConverter;

/**
 * @author U930DI
 *
 *         TODO To change the template for this generated type comment go to
 *         Window - Preferences - Java - Code Style - Code Templates
 */
public class VarNumIntComp3 extends VarNum {
  VarNumIntComp3(DeclareType9 declareType9) {
    super(declareType9);
  }

  protected VarNumIntComp3() {
    super();
  }

  protected VarBase allocCopy() {
    VarNumIntComp3 v = new VarNumIntComp3();
    return v;
  }

  public boolean DEBUGisStorageAscii() {
    return false;
  }

  public int compareTo(ComparisonMode mode, String csValue) {
    double dValue = 0;
    try {
      dValue = new Double(csValue).doubleValue();
    } catch (Exception ex) {
    }
    return compareTo(dValue);
  }

  public int compareTo(int nValue) {
    int nVarValue = getInt();
    return nVarValue - nValue;
  }

  public int compareTo(double dValue) {
    double dVarValue = getDouble();
    double d = dVarValue - dValue;
    if (d < -0.00001) // Consider epsilon precision at 10 e-5
      return -1;
    else if (d > 0.00001) // Consider epsilon precision at 10 e-5
      return 1;
    return 0;
  }

  protected byte[] convertUnicodeToEbcdic(char[] tChars) {
    return AsciiEbcdicConverter.noConvertUnicodeToEbcdic(tChars);
  }

  protected char[] convertEbcdicToUnicode(byte[] tBytes) {
    return AsciiEbcdicConverter.noConvertEbcdicToUnicode(tBytes);
  }

  public VarType getVarType() {
    return VarType.VarNumIntComp3;
  }
}
