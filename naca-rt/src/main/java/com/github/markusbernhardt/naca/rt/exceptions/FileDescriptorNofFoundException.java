/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
package com.github.markusbernhardt.naca.rt.exceptions;

import com.github.markusbernhardt.jlib.misc.LogicalFileDescriptor;

public class FileDescriptorNofFoundException extends NacaBatchFileException {
  private static final long serialVersionUID = 1L;

  public FileDescriptorNofFoundException(String csFileName, LogicalFileDescriptor logicalFileDescriptor) {
    super("FileDescriptorNofFoundException", csFileName, logicalFileDescriptor);
  }
}
