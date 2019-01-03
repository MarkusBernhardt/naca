/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
package com.github.markusbernhardt.naca.rt.fpacPrgEnv;

import com.github.markusbernhardt.naca.rt.varEx.CInitialValue;
import com.github.markusbernhardt.naca.rt.varEx.CobolConstant;
import com.github.markusbernhardt.naca.rt.varEx.DeclareTypeBase;
import com.github.markusbernhardt.naca.rt.varEx.VarDefBuffer;
import com.github.markusbernhardt.naca.rt.varEx.VarDefFPacAlphaNum;
import com.github.markusbernhardt.naca.rt.varEx.VarLevel;

public class DeclareTypeFPacAlphaNum extends DeclareTypeBase {
  public DeclareTypeFPacAlphaNum(VarLevel varLevel, int nLength) {
    super(varLevel);
    m_nLength = nLength;
  }

  public int getLength() {
    return m_nLength;
  }

  private int m_nLength = 0;

  public VarFPacAlphaNum var() {
    VarFPacAlphaNum var = new VarFPacAlphaNum(this);
    return var;
  }

  public VarFPacAlphaNum filler() {
    VarFPacAlphaNum var = new VarFPacAlphaNum(this);
    var.declareAsFiller();
    // return null;
    return var;
  }

  public VarDefBuffer createVarDef(VarDefBuffer varDefParent) {
    VarDefBuffer varDef = new VarDefFPacAlphaNum(varDefParent, this);
    return varDef;
  }

  /**
   * 
   */

  public DeclareTypeFPacAlphaNum value(String cs) {
    m_InitialValue = new CInitialValue(cs, false);
    return this;
  }

  public DeclareTypeFPacAlphaNum valueAll(char c) {
    m_InitialValue = new CInitialValue(c, true);
    return this;
  }

  public DeclareTypeFPacAlphaNum valueAll(String cs) {
    m_InitialValue = new CInitialValue(cs, true);
    return this;
  }

  public DeclareTypeFPacAlphaNum valueSpaces() {
    m_InitialValue = new CInitialValue(CobolConstant.Space.getValue(), true);
    return this;
  }

  public DeclareTypeFPacAlphaNum valueZero() {
    m_InitialValue = new CInitialValue(CobolConstant.Zero.getValue(), true);
    return this;
  }

  public DeclareTypeFPacAlphaNum valueHighValue() {
    m_InitialValue = new CInitialValue(CobolConstant.HighValue.getValue(), true);
    return this;
  }

  public DeclareTypeFPacAlphaNum valueLowValue() {
    m_InitialValue = new CInitialValue(CobolConstant.LowValue.getValue(), true);
    return this;
  }

  public CInitialValue getInitialValue() {
    return m_InitialValue;
  }

  private CInitialValue m_InitialValue = null;
}
