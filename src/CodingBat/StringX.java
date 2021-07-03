package CodingBat;

public class StringX {
  /*

  Given a string, return a version where all the "x" have been removed.
  Except an "x" at the very start or end should not be removed.

  stringX("xxHxix") → "xHix"
  stringX("abxxxcd") → "abcd"
  stringX("xabxxxcdx") → "xabcdx"
   */

  public static void main(String[] args) {

  }

  public static String stringX(String str) {
    //xxHxix

    if (str.length()>2){
      return str.substring(0,1)+str.substring(1,str.length()-1).replaceAll("x","")+str.substring(str.length()-1);
    }else{
      return str;
    }

    /*String result = "" ;
    if (str.length() < 2 ) return str;
    result += str.charAt(0);

    for (int i = 1; i < str.length() - 1 ; i++) {
      if (!(str.charAt(i) == 'x')) {
        result += str.charAt(i);
      }
    }
    result += str.charAt(str.length() - 1);

    return result;*/
  }

}
