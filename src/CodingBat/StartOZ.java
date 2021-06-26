package CodingBat;

public class StartOZ {
  /*

  startOz("ozymandias") → "oz"
  startOz("bzoo") → "z"
  startOz("oxx") → "o"
  startOz("o") → "o"
   */

  public static void main(String[] args) {

  }

  public static String startOz(String str) {
    String result = "";
    if (str.length() >= 1 && str.charAt(0) == 'o' ) {
      result += "o";
    }

    if (str.length() >= 2 && str.charAt(1) == 'z') {
      result += "z";
    }

    return result;
  }
}
