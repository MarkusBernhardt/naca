/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
package com.github.markusbernhardt.naca.rt.fpacPrgEnv;

import com.github.markusbernhardt.naca.rt.varEx.DeclareTypeFPacSignComp4;
import com.github.markusbernhardt.naca.rt.varEx.VarBuffer;
import com.github.markusbernhardt.naca.rt.varEx.VarBufferPos;
import com.github.markusbernhardt.naca.rt.varEx.VarNumIntSignComp4Long;

public class VarFPacNumLongSignComp4 extends VarNumIntSignComp4Long {
  public VarFPacNumLongSignComp4(DeclareTypeFPacSignComp4 type, VarBuffer varBuffer, int nPosition) {
    super(type);
    m_bufferPos = new VarBufferPos(varBuffer, nPosition);
    m_varDef.setTotalSize(m_varDef.getSingleItemRequiredStorageSize());
  }
}
