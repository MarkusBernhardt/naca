/*
 * JLib - Publicitas Java library.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
package com.github.markusbernhardt.jlib.classLoader;

import java.lang.management.MemoryNotificationInfo;

import javax.management.Notification;

import com.github.markusbernhardt.jlib.log.Log;

public class CodeSizeLimitEventHandler implements javax.management.NotificationListener 
{  
	public void handleNotification(Notification notification, Object handback)  
	{    
		String notifType = notification.getType();    
		if(notifType.equals(MemoryNotificationInfo.MEMORY_THRESHOLD_EXCEEDED)) 
		{
			Log.logCritical("MEMORY_THRESHOLD_EXCEEDED:" + notification.getMessage() + " will try to unload some unused classes");
		}  
	}
}
