package CodingBat;

public class MixStart {

  /*
  mixStart("mix snacks") → true
  mixStart("pix snacks") → true
  mixStart("piz snacks") → false
   */

  public static void main(String[] args) {
  }

  public static boolean mixStart(String str) {
    if (str.length() > 3 && str.substring(1,3).equals("ix")) {
      return true;
    }
    return false;
  }
}
