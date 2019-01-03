/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
package com.github.markusbernhardt.naca.rt.idea.onlinePrgEnv;

import com.github.markusbernhardt.jlib.sql.DbConnectionManagerBase;
import com.github.markusbernhardt.jlib.xml.Tag;
import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseProgramLoader;
import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseSession;
import com.github.markusbernhardt.naca.rt.basePrgEnv.CBaseMapFieldLoader;
import com.github.markusbernhardt.naca.rt.misc.CLocalizedTextManager;

public class OnlineProgramLoader extends BaseProgramLoader {
  public OnlineProgramLoader(DbConnectionManagerBase connectionManager, Tag tagSequencerConfig) {
    super(connectionManager, tagSequencerConfig, true);
  }

  public void init(Tag tagSequencerConfig) {
    String csTransIDMappingFilePath = tagSequencerConfig.getVal("TransIDMappingFilePath");
    if (!csTransIDMappingFilePath.equals("")) {
      LoadTransIDMapping(OnlineResourceManager.getApplicationRootPath() + csTransIDMappingFilePath);
    }

    String translationFilePath = tagSequencerConfig.getVal("TranslationFilePath");
    if (translationFilePath != null && !translationFilePath.equals("")) {
      LoadTranslations(OnlineResourceManager.getApplicationRootPath() + translationFilePath);
    }

    InitHelpCenter();

    // Start Asynchronous programs
    StartAsynchronousPrograms(tagSequencerConfig);
  }

  /**
   * @param translationFilePath
   */
  private void LoadTranslations(String translationFilePath) {
    Tag tagRoot = Tag.createFromFile(translationFilePath);
    if (tagRoot != null) {
      m_localizedTextManager.Init(tagRoot);
    }
  }

  private void StartAsynchronousPrograms(Tag tagSequencerConfig) {
    Tag tagStartPrograms = tagSequencerConfig.getChild("StartPrograms");
    if (tagStartPrograms != null) {
      Tag tagProgram = tagStartPrograms.getEnumChild("Program");
      while (tagProgram != null) {
        String programName = tagProgram.getVal("name");
        int ndelay = tagProgram.getValAsInt("delaySeconds");

        StartAsynchronousProgram(programName, null, null, ndelay);
        tagProgram = tagStartPrograms.getEnumChild();
      }
    }
  }

  protected void InitHelpCenter() {
    m_csHelpCenter = m_tagCESMConfig.getVal("HelpCenterClassName");
  }

  public void doHelp(CBaseMapFieldLoader fieldLoader, BaseSession session) {
    /*
     * if(m_csHelpCenter != null) { Object obj =
     * CodeManager.getInstance(m_csHelpCenter,
     * CustomClassDynLoaderFactory.getInstance()); HelpCenter helpCenter =
     * (HelpCenter)obj; BaseEnvironment env = getEnvironment(session);
     * 
     * if (env == null) { return ; } helpCenter.setLangCode(env.getLanguageCode());
     * helpCenter.doHelp(env, fieldLoader) ; Document doc = helpCenter.getHelpPage()
     * ; session.setHelpPage(doc) ; }
     */
  }

  // /* (non-Javadoc)
  // * @see CESMProgramSequencer#RunProgram(org.w3c.dom.Document, CSession)
  // */
  // public void RunProgram(BaseSession appSession) throws AbortSessionException
  // {
  // StopWatch sw = new StopWatch();
  // CESMEnvironment env = GetEnvironment(appSession, null) ;
  // appSession.prepareRunSessionProgram(env, null) ;
  // runTopProgram(env, true, true);
  // long lms = sw.getElapsedTime();
  // Log.logVerbose("Programs run for " + lms + " ms");
  // }
  //
  // public void RunSessionProgram(CSession appSession, String defaultProgramName)
  // throws AbortSessionException
  // {
  // CESMEnvironment env = GetEnvironment(appSession, defaultProgramName) ;
  //
  // CBaseMapFieldLoader mapField = appSession.getInputWrapper() ;
  // if (mapField != null)
  // {
  // String page = mapField.getFieldValue("page");
  // if (page != null && !page.equals(""))
  // {
  // env.setCommarea(null);
  // env.setNextProgramToLoad(page) ;
  // }
  // else
  // {
  // env.setXMLData(appSession.getXMLData()) ;
  // KeyPressed key = appSession.getKeyPressed();
  // if (key == null)
  // {
  // env.resetKeyPressed() ;
  // }
  // else
  // {
  // env.setKeyPressed(key);
  // }
  // }
  // }
  // runTopProgram(env, true, true);
  // }

  private String m_csHelpCenter = null;
  private CLocalizedTextManager m_localizedTextManager = CLocalizedTextManager.getInstance();
}
