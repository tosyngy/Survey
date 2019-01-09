package suevey;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Scanner;
import javax.swing.JOptionPane;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author OGINNI
 */
//new sater
//end here
class CurrentTime extends Suevey {

  static String out, out1, date;

  public CurrentTime() {
    try {

      if (!testInet("google.com")) {
        SimpleDateFormat df = new SimpleDateFormat();
        JOptionPane.showMessageDialog(null, "internet connection fails ");
        GregorianCalendar d = new GregorianCalendar();
        System.out.println(d.getTime());
        out1 = d.getTime() + "";
        out = out1.replaceAll("WAT", "");
        out = out.replaceAll(":", " ");
      } else {
        out = new Scanner(new URL("http://184.107.137.194/globalbet/testtime.php").openStream(), "UTF-8").useDelimiter("\\A").next();
        out = out.replaceAll("<pre>", "");
        out = out.replaceAll("</pre>", "");
        out = out.replaceAll("BST ", "");
      }

      ////////////////////////////System.out.println(""+out);
    } catch (Exception g) {
      ////////////////////////////System.out.println("");
    }
  }

  public static String getCompleteDate() {
    date = out1;
    return date;
  }

  public static String getHour() {
    date = out.substring(11, 14).trim();
    return date;
  }

  public static String getYear() {
    date = out.substring(20, 25).trim();
    return date;
  }

  public static String getDay() {
    date = out.substring(8, 11).trim();
    return date;
  }

  public static String getDayOfTheWeek() {
    date = out.substring(0, 4).trim();
    return date;
  }

  public static String getMonth() {
    date = out.substring(4, 8).trim();
    return date;
  }

  public static String getDate() {
    date = out.substring(8, 11).trim() + "-" + out.substring(4, 8).trim() + "-" + out.substring(20, 25).trim();
    return date;
  }

  public static String getTime() {
    date = out.substring(11, 20).trim().replaceAll(" ", ":");
    return date;
  }

  public static String getMinite() {
    date = out.substring(14, 17).trim();
    return date;
  }

  public static String getSeconds() {
    date = out.substring(17, 20).trim();
    return date;
  }

  public static void main(String[] arg) {
    new CurrentTime();
    System.out.println(" date " + getDate());
    System.out.println(" complte " + getCompleteDate());
    System.out.println(" time " + getTime());
    System.out.println(" month " + getMonth());
    System.out.println(" year " + getYear());
    System.out.println(" min " + getMinite());
    System.out.println(" sec " + getSeconds());
    System.out.println(" hr " + getHour());
    System.out.println(" day " + getDay());
    System.out.println(" day of the week " + getDayOfTheWeek());

  }
}
