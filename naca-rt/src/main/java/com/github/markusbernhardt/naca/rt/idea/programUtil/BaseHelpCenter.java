/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
/*
 * Created on 31 janv. 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.github.markusbernhardt.naca.rt.idea.programUtil;

import org.w3c.dom.Document;

import com.github.markusbernhardt.naca.rt.base.CJMapObject;
import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseEnvironment;
import com.github.markusbernhardt.naca.rt.basePrgEnv.CBaseMapFieldLoader;
import com.github.markusbernhardt.naca.rt.misc.CLocalizedTextManager;

/**
 * @author SLY
 *
 *         To change the template for this generated type comment go to
 *         Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public abstract class BaseHelpCenter extends CJMapObject {
  public void setLangCode(String langId) {
    m_csLangId = langId;
  }

  protected String m_csLangId = "";

  public abstract void doHelp(BaseEnvironment env, CBaseMapFieldLoader fieldLoader);

  public abstract Document getHelpPage();

  protected CLocalizedTextManager m_localizedTextManager = CLocalizedTextManager.getInstance();

  protected String getLocalizedText(String id) {
    return m_localizedTextManager.getLocalizedString(id, m_csLangId);
  }
}
