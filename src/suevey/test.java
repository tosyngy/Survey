/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suevey;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 *
 * @author tosyngy
 */
public class test {

  String username = "tosyn", password = "tosyn";

  test() {
    try {
      URL url = new URL("http://localhost/getyourplaces/login.php?username=" + username + "&password=" + password);

      URLConnection connection = url.openConnection();
      Document doc = parseXML(connection.getInputStream());
      NodeList nStatus = doc.getElementsByTagName("status");
      NodeList nUser = doc.getElementsByTagName("username");
      NodeList nId = doc.getElementsByTagName("id");
      JOptionPane jp = new JOptionPane();
      jp.showMessageDialog(null, nId.item(0).getTextContent());
      jp.showMessageDialog(null, nStatus.item(0).getTextContent());
      jp.showMessageDialog(null, nUser.item(0).getTextContent());

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public Document parseXML(InputStream stream) throws Exception {
    DocumentBuilderFactory objDocumentBuilderFactory = null;
    DocumentBuilder objDocumentBuilder = null;
    Document doc = null;
    try {
      objDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
      objDocumentBuilder = objDocumentBuilderFactory.newDocumentBuilder();

      doc = objDocumentBuilder.parse(stream);
    } catch (Exception ex) {
      throw ex;
    }

    return doc;
  }

  public static void main(String[] args) {
    new test();
  }
}
