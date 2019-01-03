/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
/**
 * 
 */
package com.github.markusbernhardt.naca.rt.dbUtils;

import com.github.markusbernhardt.jlib.log.Log;
import com.github.markusbernhardt.jlib.misc.DataFileLineReader;
import com.github.markusbernhardt.jlib.misc.LineRead;
import com.github.markusbernhardt.jlib.misc.LogicalFileDescriptor;
import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseSession;
import com.github.markusbernhardt.naca.rt.varEx.FileDescriptor;

/**
 *
 * @author Pierre-Jean Ditscheid, Consultas SA
 * @version $Id: FileExporter.java,v 1.3 2007/02/22 15:08:46 u930bm Exp $
 */
public class FileExporter {
  private BaseSession m_session = null;

  public FileExporter(BaseSession session) {
    m_session = session;
  }

  public boolean execute(FileDescriptor exportFileIn, FileDescriptor exportFileOut) {
    String csFileIn = exportFileIn.getPhysicalName();
    LogicalFileDescriptor logicalFileDescriptor = exportFileIn.getLogicalFileDescriptor();
    DataFileLineReader dataFileIn = new DataFileLineReader(csFileIn, 65536, 0);
    boolean bInOpened = dataFileIn.open(logicalFileDescriptor);
    if (bInOpened) {
      exportFileOut.setSession(m_session);
      String csFileOut = exportFileOut.getPhysicalName();

      exportFileOut.openOutputNoFileHeaderWrite();
      boolean bVariableLength = exportFileIn.isVariableLength();

      int nNbLines = 0;
      LineRead lineRead = exportFileIn.readALine(dataFileIn, null);
      while (lineRead != null) {
        if (bVariableLength)
          lineRead.shiftOffset(4); // Skip record header
        exportFileOut.writeFrom(lineRead);
        lineRead = exportFileIn.readALine(dataFileIn, lineRead);
        nNbLines++;
      }
      dataFileIn.close();
      exportFileOut.close();
      Log.logImportant("Exported " + nNbLines + " from " + csFileIn + " to " + csFileOut);
      return true;
    }
    Log.logCritical("Could not open export file in " + csFileIn);
    return false;
  }
}
