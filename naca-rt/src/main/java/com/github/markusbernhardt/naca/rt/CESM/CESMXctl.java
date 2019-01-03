/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
package com.github.markusbernhardt.naca.rt.CESM;

import com.github.markusbernhardt.jlib.log.Log;
import com.github.markusbernhardt.naca.rt.base.CJMapObject;
import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseEnvironment;
import com.github.markusbernhardt.naca.rt.exceptions.CXctlException;
import com.github.markusbernhardt.naca.rt.misc.CCommarea;
import com.github.markusbernhardt.naca.rt.varEx.Var;

public class CESMXctl extends CJMapObject {
  protected BaseEnvironment m_Environment = null;

  public CESMXctl(BaseEnvironment env, String csProgramName) {
    m_Environment = env;
    m_Environment.setNextProgramToLoad(csProgramName);
  }

  public void go() {
    if (isLogCESM)
      Log.logDebug("Xctling program: " + m_Environment.getNextProgramToLoad());
    CXctlException exp = new CXctlException(m_Environment);
    throw exp;
  }

  public void commarea(Var var, int length) {
    CCommarea comm = new CCommarea();
    m_Environment.setCommarea(comm);
    comm.setVarPassedByValue(var, length);
    if (isLogCESM)
      Log.logDebug("Xctling program: " + m_Environment.getNextProgramToLoad());
    CXctlException exp = new CXctlException(m_Environment);
    throw exp;
  }

  public void commarea(Var var) {
    commarea(var, -1);
  }

  public void commarea(Var v, Var length) {
    int l = length.getInt();
    commarea(v, l);
  }

  public void commarea(Var var, int length, int datalength) {
    commarea(var, length);
  }

  public void commarea(Var var, Var length, int datalength) {
    int l = length.getInt();
    commarea(var, l);
  }
}