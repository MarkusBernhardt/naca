/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
package com.github.markusbernhardt.naca.rt.idea.manager;

import com.github.markusbernhardt.jlib.log.Log;
import com.github.markusbernhardt.naca.rt.CESM.CESMStartData;
import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseCESMManager;
import com.github.markusbernhardt.naca.rt.basePrgEnv.BaseEnvironment;
import com.github.markusbernhardt.naca.rt.idea.onlinePrgEnv.OnlineEnvironment;
import com.github.markusbernhardt.naca.rt.program.CESMCommandCode;
import com.github.markusbernhardt.naca.rt.varEx.Var;

public class CESMManager extends BaseCESMManager {
  public CESMManager(BaseEnvironment env) {
    super(env);
  }

  public CESMSendMap sendMap(Var varMapToSend) {
    if (isLogCESM)
      Log.logDebug("sendMap Var=" + varMapToSend.getLoggableValue());
    m_CESMEnv.setLastCommandCode(CESMCommandCode.SEND_MAP);
    CESMSendMap order = new CESMSendMap();
    ((OnlineEnvironment) m_CESMEnv).addMapOrder(order);
    order.setMapName(varMapToSend.getString());
    return order;
  }

  public CESMSendMap sendMap(String csMapToSend) {
    if (isLogCESM)
      Log.logDebug("sendMap String=" + csMapToSend);
    m_CESMEnv.setLastCommandCode(CESMCommandCode.SEND_MAP);
    CESMSendMap order = new CESMSendMap();
    ((OnlineEnvironment) m_CESMEnv).addMapOrder(order);
    order.setMapName(csMapToSend);
    return order;
  }

  public CESMReceive receiveMap(String mapName) {
    if (isLogCESM)
      Log.logDebug("receiveMap String=" + mapName);
    m_CESMEnv.setLastCommandCode(CESMCommandCode.RECEIVE_MAP);
    // XMLUtil.ExportXML(m_CESMEnv.getXMLData(), "DataReceived.xml");
    // m_CESMEnv.recordInput() ;
    CESMReceive order = new CESMReceive(m_CESMEnv.getXMLData(), m_CESMEnv);
    order.setMap(mapName);
    return order;
  }

  public CESMReceive receiveMap(Var MapToReceive) {
    if (isLogCESM)
      Log.logDebug("receiveMap Var=" + MapToReceive.getLoggableValue());
    m_CESMEnv.setLastCommandCode(CESMCommandCode.RECEIVE_MAP);
    // XMLUtil.ExportXML(m_CESMEnv.getXMLData(), "DataReceived.xml");
    // m_CESMEnv.recordInput() ;
    CESMReceive order = new CESMReceive(m_CESMEnv.getXMLData(), m_CESMEnv);
    order.setMap(MapToReceive.getString());
    return order;
  }

  public void retrieveInto(Var varDest, Var longfrom) {
    if (isLogCESM)
      Log.logDebug("retrieveInto to=" + varDest.getLoggableValue() + " from=" + longfrom.getLoggableValue());
    m_CESMEnv.setLastCommandCode(CESMCommandCode.RETRIEVE);
    CESMStartData data = m_CESMEnv.GetEnqueuedData();
    if (data != null) {
      int nDestLength = data.getLength();
      varDest.getBuffer()
             .copyBytesFromSource(varDest.getAbsolutePosition(), data.getCharBuffer(), 0, nDestLength);
      longfrom.set(nDestLength);
    }
  }

  public void retrieveInto(Var varDest) {
    if (isLogCESM)
      Log.logDebug("retrieveInto to=" + varDest.getLoggableValue());
    m_CESMEnv.setLastCommandCode(CESMCommandCode.RETRIEVE);
    CESMStartData data = m_CESMEnv.GetEnqueuedData();
    if (data != null) {
      int nDestLength = data.getLength();
      varDest.getBuffer()
             .copyBytesFromSource(varDest.getAbsolutePosition(), data.getCharBuffer(), 0, nDestLength);
    }
  }
}
