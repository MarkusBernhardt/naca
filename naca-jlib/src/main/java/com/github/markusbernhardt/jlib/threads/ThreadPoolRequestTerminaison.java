/*
 * JLib - Publicitas Java library.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
package com.github.markusbernhardt.jlib.threads;

public class ThreadPoolRequestTerminaison extends ThreadPoolRequest
{
	ThreadPoolRequestTerminaison()
	{
		super(true);	
	}
	
	public void execute()
	{
	}
}
