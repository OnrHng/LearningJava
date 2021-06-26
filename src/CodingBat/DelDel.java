package CodingBat;

public class DelDel {

  /*
  delDel("adelbc") → "abc"
  delDel("adelHello") → "aHello"
  delDel("adedbc") → "adedbc"
   */

  public static void main(String[] args) {
    System.out.println(delDel("adelbc"));
    System.out.println(delDel("adelHello"));
    System.out.println(delDel("adedbc"));
  }

  public static String delDel(String str) {
    if (str.length() > 3 && str.substring(1,4).equals("del")) {
      return str.substring(0,1) + str.substring(4);
    }
    return str;
//    return str.length() > 3 && str.substring(1,4).equals("del") ? str.substring(0,1) + str.substring(4) : str;

  }
}
