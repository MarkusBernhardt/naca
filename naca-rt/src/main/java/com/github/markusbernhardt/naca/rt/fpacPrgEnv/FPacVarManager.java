/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
package com.github.markusbernhardt.naca.rt.fpacPrgEnv;

import com.github.markusbernhardt.naca.rt.tempCache.TempCache;
import com.github.markusbernhardt.naca.rt.tempCache.TempCacheLocator;
import com.github.markusbernhardt.naca.rt.varEx.DeclareTypeFPacSignComp4;
import com.github.markusbernhardt.naca.rt.varEx.DeclareTypeFPacSignIntComp3;
import com.github.markusbernhardt.naca.rt.varEx.Var;
import com.github.markusbernhardt.naca.rt.varEx.VarBuffer;
import com.github.markusbernhardt.naca.rt.varEx.VarDefNumIntSignComp3;
import com.github.markusbernhardt.naca.rt.varEx.VarLevel;
import com.github.markusbernhardt.naca.rt.varEx.VarType;

public class FPacVarManager {
  private VarLevel m_level77 = null;
  private FPacVarCacheManager m_fpacVarCacheManager = null;
  private int m_nBufferId = 0;

  FPacVarManager(FPacProgram program) {
    TempCache tempCache = TempCacheLocator.getTLSTempCache();
    m_level77 = tempCache.getVarLevel();
    m_level77.set(program, 77);
    // m_level77 = new VarLevel(program, 77);
    m_fpacVarCacheManager = program.getFPacVarCacheManager();
    m_nBufferId = FPacBufferCounter.getBufferId();
  }

  Var createFPacVarNumIntSignComp3(VarBuffer varBuffer, int nPosition1Based, int nBufferSize) {
    Var var = m_fpacVarCacheManager.get(m_nBufferId, VarType.VarFPacVarNumIntSignComp3, nPosition1Based, nBufferSize);
    if (var != null)
      return var;

    int nPosition0Based = nPosition1Based - 1;
    int nNbDigitsInteger = VarDefNumIntSignComp3.getNbDigitIntegerComp3InBufferLength(nBufferSize);

    TempCache tempCache = TempCacheLocator.getTLSTempCache();
    DeclareTypeFPacSignIntComp3 declareTypeFPacSignIntComp3 = tempCache.getDeclareTypeFPacSignIntComp3();
    declareTypeFPacSignIntComp3.set(m_level77, nNbDigitsInteger);
    VarFPacNumIntSignComp3 v = new VarFPacNumIntSignComp3(declareTypeFPacSignIntComp3, varBuffer, nPosition0Based);

    m_fpacVarCacheManager.set(v, m_nBufferId, nPosition1Based, nBufferSize);

    return v;
  }

  Var createFPacVarNumSignComp4(VarBuffer varBuffer, int nPosition1Based, int nBufferSize) {
    DeclareTypeFPacSignComp4 declareTypeFPacSignComp4 = TempCacheLocator.getTLSTempCache()
                                                                        .getDeclareTypeFPacSignComp4();
    int nPosition0Based = nPosition1Based - 1;
    if (nBufferSize == 2) {
      Var var = m_fpacVarCacheManager.get(m_nBufferId, VarType.VarFPacNumShortSignComp4, nPosition1Based, nBufferSize);
      if (var != null)
        return var;

      declareTypeFPacSignComp4.set(m_level77, 4);
      VarFPacNumShortSignComp4 v = new VarFPacNumShortSignComp4(declareTypeFPacSignComp4, varBuffer, nPosition0Based);

      m_fpacVarCacheManager.set(v, m_nBufferId, nPosition1Based, nBufferSize);

      return v;
    } else if (nBufferSize == 4) {
      Var var = m_fpacVarCacheManager.get(m_nBufferId, VarType.VarFPacNumIntSignComp4, nPosition1Based, nBufferSize);
      if (var != null)
        return var;

      declareTypeFPacSignComp4.set(m_level77, 9);
      VarFPacNumIntSignComp4 v = new VarFPacNumIntSignComp4(declareTypeFPacSignComp4, varBuffer, nPosition0Based);

      m_fpacVarCacheManager.set(v, m_nBufferId, nPosition1Based, nBufferSize);

      return v;
    } else if (nBufferSize == 8) {
      Var var = m_fpacVarCacheManager.get(m_nBufferId, VarType.VarFPacNumLongSignComp4, nPosition1Based, nBufferSize);
      if (var != null)
        return var;

      declareTypeFPacSignComp4.set(m_level77, 20);
      VarFPacNumLongSignComp4 v = new VarFPacNumLongSignComp4(declareTypeFPacSignComp4, varBuffer, nPosition0Based);

      m_fpacVarCacheManager.set(v, m_nBufferId, nPosition1Based, nBufferSize);

      return v;
    }
    return null;
  }

  Var createFPacVarAlphaNum(VarBuffer varBuffer, int nPosition1Based, int nBufferSize) {
    Var var = m_fpacVarCacheManager.get(m_nBufferId, VarType.VarFpacAlphaNum, nPosition1Based, nBufferSize);
    if (var != null)
      return var;

    int nPosition0Based = nPosition1Based - 1;
    DeclareTypeFPacAlphaNum type = new DeclareTypeFPacAlphaNum(m_level77, nBufferSize);
    VarFPacAlphaNum v = new VarFPacAlphaNum(type, varBuffer, nPosition0Based);

    m_fpacVarCacheManager.set(v, m_nBufferId, nPosition1Based, nBufferSize);

    return v;
  }

  Var createFPacVarNumEdited(VarBuffer varBuffer, int nPosition1Based, String csEditMask) {
    Var var = m_fpacVarCacheManager.get(m_nBufferId, VarType.VarFPacNumEdited, nPosition1Based, csEditMask);
    if (var != null)
      return var;

    int nPosition0Based = nPosition1Based - 1;
    DeclareTypeFPacNumEdited type = new DeclareTypeFPacNumEdited(m_level77, csEditMask);

    VarFPacNumEdited v = new VarFPacNumEdited(type, varBuffer, nPosition0Based);

    m_fpacVarCacheManager.set(v, m_nBufferId, nPosition1Based, csEditMask);

    return v;
  }

  Var createFPacVarRaw(VarBuffer varBuffer, int nPosition1Based, int nBufferSize) {
    Var var = m_fpacVarCacheManager.get(m_nBufferId, VarType.VarFPacVarRaw, nPosition1Based, nBufferSize);
    if (var != null)
      return var;

    int nPosition0Based = nPosition1Based - 1;
    DeclareTypeFPacRaw type = new DeclareTypeFPacRaw(m_level77, nBufferSize);
    VarFPacRaw v = new VarFPacRaw(type, varBuffer, nPosition0Based);

    m_fpacVarCacheManager.set(v, m_nBufferId, nPosition1Based, nBufferSize);

    return v;
  }

}
