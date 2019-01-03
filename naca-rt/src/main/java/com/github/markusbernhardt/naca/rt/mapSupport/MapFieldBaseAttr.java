/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
/*
 * Created on 30 nov. 04
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

/**
 * @author U930DI
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.github.markusbernhardt.naca.rt.mapSupport;

public abstract class MapFieldBaseAttr {
  protected MapFieldBaseAttr(int nValue, String text) {
    m_nValue = nValue;
    m_csText = text;
  }

  int getBitEncoding() {
    return m_nValue;
  }

  // void setBitEncoding(int nValue)
  // {
  // m_nValue = nValue;
  // }

  private int m_nValue = 0;
  private String m_csText = "";

  protected int getInternalValue() {
    return m_nValue;
  }

  public String toString() {
    return getText();
  }

  public String getText() {
    return m_csText;
  }

  public String getSTCheckValue() {
    return toString();
  }

  // abstract static int getNbBitsEncoding();
  // abstract static int getMask();

  /*
   * Caract�ristique de chaque mapset, map ou champs, qui d�crit pr�cis�ment les
   * environnements. par exemple pour un champ, les attributs indiqueront la
   * position (ligna colonne), la longueur, le type d?information
   * (alphanum�rique,...), le cadrage (droite, gauche), la brillance, reverse
   * vid�e, prot�ge ou non, etc Pour les champs libell�s, les attributs sont
   * repr�sent�s par un suffixe, qui indique le type d?attribut que l?on est en
   * train de traiter. Ce qui explique que la longueur du nom d?un champ est >= 7.
   * Le nombre des attributs g�n�r�s sera d�pendant du type attribut standard ou
   * �tendu. Les suffixes sont les suivants : L 2 octets longueur du champ, si
   * longueur = -1, alors curseur positionn�. (PIC S9(4) comp) F 1 octet zone flag
   * indique prot�g� ou non. C 1 octet couleur H 1 octet brillance, soulignement,
   * reverse vid�o. V 1 octet validation P 1 octet zone flag I/O n octets zone de
   * donn�es
   */
}
