/*
 * JLib - Publicitas Java library.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
package com.github.markusbernhardt.jlib.xml;

/*
 * Created on 2 f�vr. 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.github.markusbernhardt.jlib.log.Log;
import com.github.markusbernhardt.jlib.misc.DataFileRead;
import com.github.markusbernhardt.jlib.misc.DataFileWrite;

/**
 * @author SLY
 *
 *         To change the template for this generated type comment go to
 *         Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class XMLUtil {
  public static Document LoadXML(String csFilePath) {
    if (csFilePath == null || csFilePath.equals("")) {
      return null;
    }
    File fSS = new File(csFilePath);
    return LoadXML(fSS);
  }

  public static Document LoadXML(File f) {
    Source file = new StreamSource(f);
    return LoadXML(file);
  }

  public static Document LoadXML(Source file) {
    try {
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
      DocumentBuilder db = dbf.newDocumentBuilder();
      Document doc = db.newDocument();
      Result res = new DOMResult(doc);
      TransformerFactory tr = TransformerFactory.newInstance();
      Transformer xformer = tr.newTransformer();
      xformer.transform(file, res);

      return doc;
    } catch (Exception e) {
      String csError = e.toString();
      Log.logImportant(csError);
      Log.logImportant("ERROR while loading XML " + file.toString());
    }
    return null;
  }

  public static Document loadXML(ByteArrayInputStream byteArrayInputStream) {
    try {
      StreamSource streamSource = new StreamSource(byteArrayInputStream);
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
      DocumentBuilder db = dbf.newDocumentBuilder();
      Document doc = db.newDocument();
      Result res = new DOMResult(doc);
      TransformerFactory tr = TransformerFactory.newInstance();
      Transformer xformer = tr.newTransformer();
      xformer.transform(streamSource, res);

      return doc;
    } catch (Exception e) {
      String csError = e.toString();
      Log.logImportant(csError);
      Log.logImportant("ERROR while loading XML from byteArrayInputStream " + byteArrayInputStream.toString());
    }
    return null;
  }

  // Works but cost 25% more memory than other loadXML methods; seems to use SAX
  // engine ?
  // public static Document loadXMLFromString(String cs)
  // {
  // try
  // {
  // StringReader stringReader = new StringReader(cs);
  // InputSource inputSource = new InputSource(stringReader);
  // Document doc =
  // DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputSource);
  // return doc;
  // }
  // catch (Exception e)
  // {
  // String csError = e.toString();
  // Log.logImportant(csError);
  // Log.logImportant("ERROR while loading XML data "+cs);
  // }
  // return null;
  // }

  public static boolean ExportXML(Document xmlOutput, String filename) {
    try {
      if (xmlOutput != null) {
        Source source = new DOMSource(xmlOutput);
        FileOutputStream file = new FileOutputStream(filename);
        StreamResult res = new StreamResult(file);
        Transformer xformer = TransformerFactory.newInstance()
                                                .newTransformer();
        xformer.setOutputProperty(OutputKeys.ENCODING, "ISO8859-1");
        xformer.setOutputProperty(OutputKeys.INDENT, "yes");

        xformer.transform(source, res);
        file.close();

        return true;
      }
      return false;
    } catch (FileNotFoundException e) {
      return false;
    } catch (TransformerConfigurationException e) {
      return false;
    } catch (TransformerException e) {
      return false;
    } catch (IOException e) {
      return false;
    }
  }

  public static Document CreateDocument() {
    try {
      return DocumentBuilderFactory.newInstance()
                                   .newDocumentBuilder()
                                   .newDocument();
    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    } catch (FactoryConfigurationError e) {
      e.printStackTrace();
    }
    return null;
  }

  public static Element GetFirstElementChild(Element tag) {
    Node n = tag.getFirstChild();
    while (n.getNodeType() != Node.ELEMENT_NODE) {
      n = n.getNextSibling();
    }
    Element e = (Element) n;
    return e;
  }

  public static byte[] encode64(byte[] arrBytes) {
    return Base64.getEncoder()
                 .encode(arrBytes);
  }

  public static byte[] decode64(byte[] arrBytes) {
    return Base64.getDecoder()
                 .decode(arrBytes);
  }

  public static String encode64AsString(byte[] arrBytes) {
    return Base64.getEncoder()
                 .encodeToString(arrBytes);
  }

  public static byte[] decode64(String cs) {
    byte[] arrBytes = cs.getBytes();
    return Base64.getDecoder()
                 .decode(arrBytes);
  }

  public static String decode64AsString(String cs) {
    byte[] arrBytes = cs.getBytes();
    byte[] tOut = Base64.getDecoder()
                        .decode(arrBytes);
    String csOut = new String(tOut);
    return csOut;
  }

  public static String encode64AsString(String cs) {
    byte[] arrBytes = cs.getBytes();
    byte[] tOut = Base64.getEncoder()
                        .encode(arrBytes);
    String csOut = new String(tOut);
    return csOut;
  }

  public static boolean encode64File(String csIn, String csOut) {
    DataFileRead fIn = new DataFileRead(csIn);
    boolean b = fIn.open(null);
    if (b) {
      byte[] tIn = fIn.readWholeFileAsArray();

      DataFileWrite fOut = new DataFileWrite(csOut, false);
      boolean bOut = fOut.open();
      if (bOut) {
        byte[] tOut = XMLUtil.encode64(tIn);
        fOut.write(tOut);
        fOut.close();
        return true;
      }
      fIn.close();
    }
    return false;
  }

  public static boolean decode64File(String csIn, String csOut) {
    DataFileRead fIn = new DataFileRead(csIn);
    boolean b = fIn.open(null);
    if (b) {
      byte[] tIn = fIn.readWholeFileAsArray();

      DataFileWrite fOut = new DataFileWrite(csOut, false);
      boolean bOut = fOut.open();
      if (bOut) {
        byte[] tOut = XMLUtil.decode64(tIn);
        fOut.write(tOut);
        fOut.close();
        return true;
      }
      fIn.close();
    }
    return false;
  }
}
