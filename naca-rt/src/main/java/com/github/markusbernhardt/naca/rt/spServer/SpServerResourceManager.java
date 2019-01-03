/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
/**
 * 
 */
package com.github.markusbernhardt.naca.rt.spServer;

import com.github.markusbernhardt.jlib.log.Log;
import com.github.markusbernhardt.jlib.misc.BasicLogger;
import com.github.markusbernhardt.jlib.xml.Tag;
import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseResourceManager;
import com.github.markusbernhardt.naca.rt.misc.LogFlowCustomNacaRT;

public class SpServerResourceManager extends BaseResourceManager {
  private Tag m_tagRoot = null;

  SpServerResourceManager() {
    super(false);
    BasicLogger.log("SpServerResourceManager() ended");
  }

  public void initialize(String csINIFilePath) {
    BasicLogger.log("SpServerResourceManager::initialize 0");
    m_tagRoot = setXMLConfigFilePath(csINIFilePath);
    BasicLogger.log("SpServerResourceManager::initialize 1");
    initSequenceur("");
    BasicLogger.log("SpServerResourceManager::initialize 2");
  }

  protected void LoadConfigFromFile(Tag tagRoot) {
    BasicLogger.log("LoadConfigFromFile");
    if (tagRoot != null) {
      BasicLogger.log("LoadConfigFromFile 1");
      String csLogCfg = tagRoot.getVal("LogSettingsPathFile");
      BasicLogger.log("LoadConfigFromFile 2");

      LogFlowCustomNacaRT.declare();
      BasicLogger.log("LoadConfigFromFile 3; csLogCfg=" + csLogCfg);
      Tag tagLogSettings = Log.open("NacaRT", csLogCfg);
      BasicLogger.log("LoadConfigFromFile 4");
      if (tagLogSettings != null) {
        BasicLogger.log("LoadConfigFromFile 5");
        Tag tagSettings = tagLogSettings.getChild("Settings");
        BasicLogger.log("LoadConfigFromFile 6");
        if (tagSettings != null) {
          BasicLogger.log("LoadConfigFromFile 7");
          // isLogCESM = tagSettings.getValAsBoolean("CESM");
          // isLogFlow = tagSettings.getValAsBoolean("Flow");
          // isLogSql = tagSettings.getValAsBoolean("Sql");
          // IsSTCheck = tagSettings.getValAsBoolean("STCheck");
        }
      }
    }
    BasicLogger.log("LoadConfigFromFile done");
  }

  String getSpDbEnvironment() {
    if (m_tagRoot != null) {
      Tag tagSQLConfig = m_tagRoot.getChild("SQLConfig");
      if (tagSQLConfig != null) {
        String csDbEnvironment = tagSQLConfig.getVal("dbenvironment");
        return csDbEnvironment;
      }
    }
    return "";
  }

  String getSpDbPackage() {
    if (m_tagRoot != null) {
      Tag tagSQLConfig = m_tagRoot.getChild("SQLConfig");
      if (tagSQLConfig != null) {
        String csDbPackage = tagSQLConfig.getVal("dbpackage");
        return csDbPackage;
      }
    }
    return "";
  }

  protected void initSequenceur(String csDBParameterPrefix) {
    BasicLogger.log("SpServerResourceManager::initSequenceur() 0");
    baseInitSequenceur(csDBParameterPrefix);
    BasicLogger.log("SpServerResourceManager::initSequenceur() 1");
  }

  public void doRemoveResourceCache(String csForm) {
  }
}
