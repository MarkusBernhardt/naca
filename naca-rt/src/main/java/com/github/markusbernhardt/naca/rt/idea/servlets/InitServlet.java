/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
package com.github.markusbernhardt.naca.rt.idea.servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.github.markusbernhardt.jlib.jmxMBean.JmxRegistration;
import com.github.markusbernhardt.naca.rt.idea.onlinePrgEnv.OnlineResourceManager;
import com.github.markusbernhardt.naca.rt.idea.onlinePrgEnv.OnlineResourceManagerFactory;
import com.github.markusbernhardt.naca.rt.idea.semanticContext.SemanticManager;

/*
 * Created on Dec 13, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
/**
 * @author U930CV
 *
 *         To change the template for this generated type comment go to
 *         Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class InitServlet extends HttpServlet {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public void init(ServletConfig config) throws ServletException {
    JmxRegistration.register();

    super.init(config);
    String path = this.getServletContext()
                      .getRealPath("/");
    OnlineResourceManager.setOnceRootPath(path);

    String csINIFilePath = config.getInitParameter("INIFilePath");
    csINIFilePath = OnlineResourceManager.getRootPath() + csINIFilePath;

    String csAppliRootPath = config.getInitParameter("ApplicationRootPath");
    OnlineResourceManager.setApplicationRootPath(csAppliRootPath);

    m_ResourceManager = OnlineResourceManagerFactory.GetInstance(csINIFilePath);

    /*
     * m_ResourceManager.setXMLConfigFilePath(csINIFilePath) ;
     * m_ResourceManager.Init() ;
     * 
     * m_ResourceManager.loadDBSemanticContextDef();
     * 
     * // Load semantic context data dictionnary: Defines semantic context
     * associtaed to DB columns
     * 
     * 
     * // Load semantic context configuration file: Defines menus, options, ...
     * String csSemanticContext = m_ResourceManager.getSemanticContextPathFile();
     * if(csSemanticContext != null && csSemanticContext.length() != 0) {
     * SemanticManager semanticManager = SemanticManager.GetInstance();
     * semanticManager.Init(csSemanticContext);
     * m_ResourceManager.registerSemanticManager(semanticManager); }
     */
  }

  OnlineResourceManager m_ResourceManager = null;
  SemanticManager m_SemanticManager = SemanticManager.GetInstance();
}
