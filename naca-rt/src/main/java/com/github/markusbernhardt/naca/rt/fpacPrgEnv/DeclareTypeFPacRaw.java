/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
/**
 * 
 */
package com.github.markusbernhardt.naca.rt.fpacPrgEnv;

import com.github.markusbernhardt.naca.rt.varEx.CInitialValue;
import com.github.markusbernhardt.naca.rt.varEx.CobolConstant;
import com.github.markusbernhardt.naca.rt.varEx.DeclareTypeBase;
import com.github.markusbernhardt.naca.rt.varEx.VarDefBuffer;
import com.github.markusbernhardt.naca.rt.varEx.VarDefFPacRaw;
import com.github.markusbernhardt.naca.rt.varEx.VarLevel;

/**
 *
 * @author Pierre-Jean Ditscheid, Consultas SA
 * @version $Id: DeclareTypeFPacRaw.java,v 1.2 2006/05/22 11:44:26 u930cv Exp $
 */
public class DeclareTypeFPacRaw extends DeclareTypeBase {
  public DeclareTypeFPacRaw(VarLevel varLevel, int nLength) {
    super(varLevel);
    m_nLength = nLength;
  }

  public int getLength() {
    return m_nLength;
  }

  private int m_nLength = 0;

  public VarFPacRaw var() {
    VarFPacRaw var = new VarFPacRaw(this);
    return var;
  }

  public VarFPacRaw filler() {
    VarFPacRaw var = new VarFPacRaw(this);
    var.declareAsFiller();
    // return null;
    return var;
  }

  public VarDefBuffer createVarDef(VarDefBuffer varDefParent) {
    VarDefBuffer varDef = new VarDefFPacRaw(varDefParent, this);
    return varDef;
  }

  /**
   * 
   */

  public DeclareTypeFPacRaw value(String cs) {
    m_InitialValue = new CInitialValue(cs, false);
    return this;
  }

  public DeclareTypeFPacRaw valueAll(char c) {
    m_InitialValue = new CInitialValue(c, true);
    return this;
  }

  public DeclareTypeFPacRaw valueAll(String cs) {
    m_InitialValue = new CInitialValue(cs, true);
    return this;
  }

  public DeclareTypeFPacRaw valueSpaces() {
    m_InitialValue = new CInitialValue(CobolConstant.Space.getValue(), true);
    return this;
  }

  public DeclareTypeFPacRaw valueZero() {
    m_InitialValue = new CInitialValue(CobolConstant.Zero.getValue(), true);
    return this;
  }

  public DeclareTypeFPacRaw valueHighValue() {
    m_InitialValue = new CInitialValue(CobolConstant.HighValue.getValue(), true);
    return this;
  }

  public DeclareTypeFPacRaw valueLowValue() {
    m_InitialValue = new CInitialValue(CobolConstant.LowValue.getValue(), true);
    return this;
  }

  public CInitialValue getInitialValue() {
    return m_InitialValue;
  }

  private CInitialValue m_InitialValue = null;
}
