package BasicsJava;

public class areEqualByThreeDecimalPlaces {
  /*
  * Write a method findAreEqualByThreeDecimalPlaces with two params of type double.
  * The method should return boolean if two double numbers are the same up to three decimal places. Otherwise false.
  * */
  public static boolean findAreEqualByThreeDecimalPlaces(double num1, double num2) {
    if ((num1 < 0 && num2 > 0) || (num1 > 0 && num2 < 0)) {
      return false;
    }
    String number1 = String.valueOf(num1);
    String number2 = String.valueOf(num2);

    if(number1.length() > 4 && number2.length() > 4) {
      return number1.substring(0,5).equals(number2.substring(0,5));
    } else {
      return number1.equals(number2);
    }
  }
  public static void main(String[] args) {
    System.out.println(findAreEqualByThreeDecimalPlaces(3.176, 3.175));
  }
}
