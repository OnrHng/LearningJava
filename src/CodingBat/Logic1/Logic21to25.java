package CodingBat.Logic1;

public class Logic21to25 {
  public static boolean inOrderEqual(int a, int b, int c, boolean equalOk) {
    /*Given three ints, a b c, return true if they are in strict increasing order, such as 2 5 11, or 5 6 7, but not 6 5 7 or 5 5 7.
    However, with the exception that if "equalOk" is true, equality is allowed, such as 5 5 7 or 5 5 5.

    inOrderEqual(2, 5, 11, false) → true
    inOrderEqual(5, 7, 6, false) → false
    inOrderEqual(5, 5, 7, true) → true*/
    if (equalOk && b >= a && c >= b) return true;
    else return c > b && b > a;
  }

  public static boolean lastDigit(int a, int b, int c) {
    /*Given three ints, a b c, return true if two or more of them have the same rightmost digit.
    The ints are non-negative. Note: the % "mod" operator computes the remainder, e.g. 17 % 10 is 7.


    lastDigit(23, 19, 13) → true
    lastDigit(23, 19, 12) → false
    lastDigit(23, 19, 3) → true*/
    return a % 10 ==  b % 10 || a % 10== c % 10 || b % 10 == c % 10;

  }

  public static boolean lessBy10(int a, int b, int c) {
    /*Given three ints, a b c, return true if one of them is 10 or more less than one of the others.


    lessBy10(1, 7, 11) → true
    lessBy10(1, 7, 10) → false
    lessBy10(11, 1, 7) → true*/

    return  Math.abs(a-b) >=10 || Math.abs(a-c) >= 10 || Math.abs(b-c) >= 10;


//    return false;
  }
  public int withoutDoubles(int die1, int die2, boolean noDoubles) {
    /*Return the sum of two 6-sided dice rolls, each in the range 1..6. However,
    if noDoubles is true, if the two dice show the same value,
    increment one die to the next value, wrapping around to 1 if its value was 6.


    withoutDoubles(2, 3, true) → 5    // (6,6, true) => 6,1  => 7
    withoutDoubles(3, 3, true) → 7
    withoutDoubles(3, 3, false) → 6*/
    if (noDoubles && die1 == die2 && die1 == 6 ) return 7;
    if (noDoubles && die1 == die2) return die1 + die2 + 1; // 2,2 true  => 2,3 =>5
    return die1 + die2;
  }

  public static int maxMod5(int a, int b) {
    /*Given two int values, return whichever value is larger.
    However if the two values have the same remainder when divided by 5,
    then the return the smaller value.
    However, in all cases, if the two values are the same, return 0.
    Note: the % "mod" operator computes the remainder, e.g. 7 % 5 is 2.


    maxMod5(2, 3) → 3
    maxMod5(6, 2) → 6
    maxMod5(3, 2) → 3*/

//    if (a==b) return 0;
//    else if (a%5 == b%5 && a < b) {
//      return a;
//    } else if (a%5 == b%5 && b < a){
//      return b;
//    }
//    else if (a<b) return b;
//
//    return a;

    int small =0;
    int big = 0;
    if(a>b) {
      small =b;
      big = a;
    }else{
      small =a;
      big = b;
    }

    if(a==b) return 0;
    else if(a%5 == b%5) return small;

    return big;



  }
}
