package CodingBat.Logic1;

public class Logic7to12 {
  /*


The number 6 is a truly great number. Given two int values, a and b,
return true if either one is 6. Or if their sum or difference is 6.
Note: the function Math.abs(num) computes the absolute value of a number.


love6(6, 4) → true
love6(4, 5) → false
love6(1, 5) → true
   */

  public boolean love6(int a, int b) {
    return (a+b == 6 || Math.abs(a-b)==6) || a==6 || b == 6;
  }


  public boolean in1To10(int n, boolean outsideMode) {
  /*
      Given a number n, return true if n is in the range 1..10, inclusive.
       Unless outsideMode is true, in which case return true if the number is less or equal to 1, or greater or equal to 10.
    in1To10(5, false) → true
    in1To10(11, false) → false
    in1To10(11, true) → true
   */
//    if (outsideMode && (n<=1 || n >= 10)) {
//      return true;
//    }
//    else if (!outsideMode)  {
//      return n >=1 && n <= 10;
//    }
//    return false;

    return outsideMode ? (n<=1 || n >= 10) : n >=1 && n <= 10;

  }

  public boolean specialEleven(int n) {
    /*
    We'll say a number is special if it is a multiple of 11 or if it is one more than a multiple of 11.
    Return true if the given non-negative number is special. Use the % "mod" operator -- see Introduction to Mod


specialEleven(22) → true
specialEleven(23) → true
specialEleven(24) → false
     */

    return n % 11 == 0 || (n-1)%11==0;

  }

  public boolean more20(int n) {
    /*

Return true if the given non-negative number is 1 or 2 more than a multiple of 20. See also: Introduction to Mod


more20(20) → false
more20(21) → true
more20(22) → true
     */
    return n % 20 == 1 || n % 20 == 2;
  }

  public boolean old35(int n) {
    /*

Return true if the given non-negative number is a multiple of 3 or 5, but not both.
Use the % "mod" operator -- see Introduction to Mod


old35(3) → true
old35(10) → true
old35(15) → false
     */
    return (n % 3 == 0 || n % 5 == 0) && n % 15 != 0;
  }

  public boolean less20(int n) {
    /*


Return true if the given non-negative number is 1 or 2 less than a multiple of 20.
So for example 38 and 39 return true, but 40 returns false. See also: Introduction to Mod


less20(18) → true
less20(19) → true
less20(20) → false
     */
    return n % 20 == 18 || n % 20 == 19;
  }

  public boolean nearTen(int num) {
    /*

Given a non-negative number "num", return true if num is within 2 of a multiple of 10.
Note: (a % b) is the remainder of dividing a by b, so (7 % 5) is 2. See also: Introduction to Mod


nearTen(12) → true
nearTen(17) → false
nearTen(19) → true
     */
    return  num % 10 <= 2 || num % 10 >= 8 ;
  }

  public int teenSum(int a, int b) {
    /*

Given 2 ints, a and b, return their sum. However, "teen" values in the range 13..19 inclusive, are extra lucky.
So if either value is a teen, just return 19.


teenSum(3, 4) → 7
teenSum(10, 13) → 19
teenSum(13, 2) → 19
     */
    return ((a >= 13 && a <= 19) || (b >= 13 && b<=19)) ? 19 : a+b;
  }

  public boolean answerCell(boolean isMorning, boolean isMom, boolean isAsleep) {
    /*

Your cell phone rings. Return true if you should answer it. Normally you answer,
except in the morning you only answer if it is your mom calling. In all cases, if you are asleep, you do not answer.


answerCell(false, false, false) → true
answerCell(false, false, true) → false
answerCell(true, false, false) → false
     */

    // return isAsleep ? false
    //   : (isMorning && !isMom) ? false : true;
    // return !isAsleep && ((isMorning && !isMom) ? false : true);

    return !isAsleep && (!isMorning || isMom);

  }


}
