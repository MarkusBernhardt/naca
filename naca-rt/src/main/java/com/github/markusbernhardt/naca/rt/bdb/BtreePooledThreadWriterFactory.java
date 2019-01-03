/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
/**
 * 
 */
package com.github.markusbernhardt.naca.rt.bdb;

import com.github.markusbernhardt.jlib.threads.BasePooledThreadFactory;
import com.github.markusbernhardt.jlib.threads.PoolOfThreads;
import com.github.markusbernhardt.naca.rt.tempCache.TempCacheLocator;

/**
 *
 * @author Pierre-Jean Ditscheid, Consultas SA
 * @version $Id: BtreePooledThreadWriterFactory.java,v 1.1 2006/11/29 09:31:30
 *          u930di Exp $
 */
public class BtreePooledThreadWriterFactory extends BasePooledThreadFactory {
  public BtreePooledThreadWriterFactory() {
  }

  public BtreePooledWriterThread make(PoolOfThreads owningPool) {
    // Key description is stored in the TLS of the current thread (which creates the
    // pool of threads)
    BtreeKeyDescription keyDescription = TempCacheLocator.getTLSTempCache()
                                                         .getBtreeKeyDescription();

    // setBtreeKeyDescription(m_keyDescription);
    BtreePooledWriterThread thread = new BtreePooledWriterThread(owningPool);
    thread.setBtreeKeyDescription(keyDescription);
    return thread;
  }
}
