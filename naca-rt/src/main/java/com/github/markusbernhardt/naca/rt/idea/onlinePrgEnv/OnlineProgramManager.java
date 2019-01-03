/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
package com.github.markusbernhardt.naca.rt.idea.onlinePrgEnv;

import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseEnvironment;
import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseProgram;
import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseProgramManager;
import com.github.markusbernhardt.naca.rt.programPool.SharedProgramInstanceData;
import com.github.markusbernhardt.naca.rt.tempCache.TempCacheLocator;
import com.github.markusbernhardt.naca.rt.varEx.MapRedefine;

public class OnlineProgramManager extends BaseProgramManager {
  public OnlineProgramManager(BaseProgram program, SharedProgramInstanceData sharedProgramInstanceData, boolean bInheritedSharedProgramInstanceData) {
    super(program, sharedProgramInstanceData, bInheritedSharedProgramInstanceData);

    BaseEnvironment env = TempCacheLocator.getTLSTempCache()
                                          .getCurrentEnv();
    setEnv(env);
  }

  public void setCurrentMapRedefine(MapRedefine mapRedefined) {
    m_currentMapRedefined = mapRedefined;
  }

  public MapRedefine getCurrentMapRedefine() {
    return m_currentMapRedefined;
  }

  private MapRedefine m_currentMapRedefined = null;
  private MapRedefine m_currentRedefineMap = null;

  protected MapRedefine getCurrentRedefineMap() {
    return m_currentRedefineMap;
  }

  public void prepareRunMain(BaseProgram prg) {
    ((OnlineProgram) prg).prepareRunMain(m_CESMEnv);
  }

  public String getTerminalID() {
    return m_CESMEnv.getTerminalID();
  }

  public void setEnv(BaseEnvironment env) {
    m_CESMEnv = (OnlineEnvironment) env;
  }

  public void detachFromEnv() {
    m_CESMEnv = null;
  }

  public BaseEnvironment getEnv() {
    return m_CESMEnv;
  }

  private OnlineEnvironment m_CESMEnv = null;
}
