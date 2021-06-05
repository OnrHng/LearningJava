package CodingBat;

public class posNeg {
//
//  Given 2 int values, return true if one is negative and one is positive.
//  Except if the parameter "negative" is true, then return true only if both are negative.
//
//  posNeg(1, -1, false) → true
//  posNeg(-1, 1, false) → true
//  posNeg(-4, -5, true) → true
//  posNeg(-4, -5, false) → false


  public static void main(String[] args) {
    System.out.println(posNeg(1, -1, false));
    System.out.println(posNeg(-1, 1, false));
    System.out.println(posNeg(-4, -5, true));
    System.out.println(posNeg(-4, -5, false));
  }

  public static boolean posNeg(int a, int b, boolean negative) {
    // a < 0 || b < 0 true
    // negative  == true ve a b < 0 true
    if (negative) {
      return (a < 0 && b < 0) ;
    } else {
      return ((a < 0 && b > 0) || (a > 0 && b < 0)) ;
    }
  }

}
