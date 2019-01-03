/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
/*
 * Created on 31 ao�t 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
/**
 * @author PJD
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.github.markusbernhardt.naca.rt.programStructure;

import com.github.markusbernhardt.naca.rt.base.CJMapObject;
import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseProgram;

public class Division extends CJMapObject {
  Division(BaseProgram Program) {
    m_Program = Program;
  }

  public BaseProgram getProgram() {
    return m_Program;
  }

  protected BaseProgram m_Program = null;
}
