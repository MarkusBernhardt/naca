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
import com.github.markusbernhardt.naca.rt.varEx.VarDefNumEdited;
import com.github.markusbernhardt.naca.rt.varEx.VarLevel;

public class DeclareTypeFPacNumEdited extends DeclareTypeBase {
  public DeclareTypeFPacNumEdited(VarLevel varLevel, String csMask) {
    super(varLevel);
    m_csMask = csMask;
  }

  public int getLength() {
    return m_csMask.length();
  }

  public String m_csMask = null;

  public VarFPacNumEdited var() {
    VarFPacNumEdited var = new VarFPacNumEdited(this);
    return var;
  }

  public VarFPacNumEdited filler() {
    VarFPacNumEdited var = new VarFPacNumEdited(this);
    var.declareAsFiller();
    // return null;
    return var;
  }

  public VarDefBuffer createVarDef(VarDefBuffer varDefParent) {
    VarDefBuffer varDef = new VarDefNumEdited(varDefParent, this);
    return varDef;
  }

  /**
   * 
   */

  public DeclareTypeFPacNumEdited value(String cs) {
    m_InitialValue = new CInitialValue(cs, false);
    return this;
  }

  public DeclareTypeFPacNumEdited valueAll(char c) {
    m_InitialValue = new CInitialValue(c, true);
    return this;
  }

  public DeclareTypeFPacNumEdited valueAll(String cs) {
    m_InitialValue = new CInitialValue(cs, true);
    return this;
  }

  public DeclareTypeFPacNumEdited valueSpaces() {
    m_InitialValue = new CInitialValue(CobolConstant.Space.getValue(), true);
    return this;
  }

  public DeclareTypeFPacNumEdited valueZero() {
    m_InitialValue = new CInitialValue(CobolConstant.Zero.getValue(), true);
    return this;
  }

  public DeclareTypeFPacNumEdited valueHighValue() {
    m_InitialValue = new CInitialValue(CobolConstant.HighValue.getValue(), true);
    return this;
  }

  public DeclareTypeFPacNumEdited valueLowValue() {
    m_InitialValue = new CInitialValue(CobolConstant.LowValue.getValue(), true);
    return this;
  }

  public CInitialValue getInitialValue() {
    return m_InitialValue;
  }

  private CInitialValue m_InitialValue = null;
}
