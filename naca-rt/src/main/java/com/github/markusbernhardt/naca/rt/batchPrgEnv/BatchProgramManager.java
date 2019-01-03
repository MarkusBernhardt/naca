/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
package com.github.markusbernhardt.naca.rt.batchPrgEnv;

import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseEnvironment;
import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseProgram;
import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseProgramManager;
import com.github.markusbernhardt.naca.rt.programPool.SharedProgramInstanceData;
import com.github.markusbernhardt.naca.rt.tempCache.TempCacheLocator;

public class BatchProgramManager extends BaseProgramManager {
  public BatchProgramManager(BaseProgram program, SharedProgramInstanceData sharedProgramInstanceData, boolean bInheritedSharedProgramInstanceData) {
    super(program, sharedProgramInstanceData, bInheritedSharedProgramInstanceData);

    BaseEnvironment env = TempCacheLocator.getTLSTempCache()
                                          .getCurrentEnv();
    setEnv(env);
  }

  public String getTerminalID() {
    return "";
  }

  public void setEnv(BaseEnvironment env) {
    m_env = env;
  }

  public void detachFromEnv() {
    m_env = null;
  }

  public BaseEnvironment getEnv() {
    return m_env;
  }

  public void prepareRunMain(BaseProgram prg) {
    if (prg instanceof BatchProgram)
      ((BatchProgram) prg).prepareRunMain(m_env);
  }

  private BaseEnvironment m_env = null;
}
