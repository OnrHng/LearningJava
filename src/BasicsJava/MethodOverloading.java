package BasicsJava;

public class MethodOverloading {
  // you can define a same method using different amount of params

  public static void main(String[] args) {
    int newScore = calculateScore("Sally", 500);
    System.out.println("New score is " + newScore);
    calculateScore(75);
    calculateScore();

    // feet inch and cm example solution
    calcFeetAndInchesToCentimeters(157);
    calcFeetAndInchesToCentimeters(20, 50);

    // example calculate hour minute and minutes
    System.out.println(getDurationString(3500));
    System.out.println(getDurationString(150, 50));
  }

  public static int calculateScore(String playerName, int score) {
    System.out.println("Player " + playerName + " scored " + score + " points");
    return score * 1000;
  }

  public static int calculateScore(int score) {
    System.out.println("Unnamed player scored " + score + " points");
    return score * 1000;
  }

  public static int calculateScore() {
    System.out.println("No player name, no player score.");
    return 0;
  }

  // EXAMPLE

  /* Create a method called calcFeetAndInchesToCentimeters
   It needs to have two parameters.
   feet is the first parameter, inches is the 2nd parameter

   You should validate that the first parameter feet is >= 0
   You should validate that the 2nd parameter inches is >=0 and <=12
   return -1 from the method if either of the above is not true

   If the parameters are valid, then calculate how many centimetres
   comprise the feet and inches passed to this method and return
   that value.

   Create a 2nd method of the same name but with only one parameter which is inc
   validate that its >=0 return -1 if it is not true
   But if its valid, then calculate how many feet are in the inches
   and then here is the tricky part
   call the other overloaded method passing the correct feet and inches
   calculated so that it can calculate correctly.

   1 inch = 2.54cm  and one foot = 12 inches */


  public static double calcFeetAndInchesToCentimeters(double feet, double inc) {
    if (feet < 0 || inc < 0) return -1;
    double cm = feet * 12 * 2.54;
    cm += inc * 2.54;
    System.out.println(feet + " feet, " + inc + " inches = " + cm + " cm");
    return cm;
  }

  public static double calcFeetAndInchesToCentimeters(double inc) {
    if ( inc < 0) return -1;
    double cm = inc * 2.54;
    System.out.println(inc + " inches = " + cm + " cm");
    return cm;
  }

  // Get Duration String Example

  /*
    Create a method called getDurationString with two parameters, first parameter minutes and 2nd parameter seconds.
    You should validate that the first parameter minutes is >= 0.
    You should validate that the 2nd parameter seconds is >= 0 and <= 59.
    The method should return 'Invalid value' in the method if either of the above are not true.

    If the parameters are valid then calculate how many hours minutes and seconds equal the minutes
      and seconds passed to this method and return that value as string in format �gXXh YYm ZZs�h where XX represents a number of hours,
      YY the minutes and ZZ the seconds.

    Create a 2nd method of the same name but with only one parameter seconds.
    Validate that it is >= 0, and return �gInvalid value�h if it is not true.
    If it is valid, then calculate how many minutes are in the seconds value and
      then call the other overloaded method passing the correct minutes and seconds calculated so that it can calculate correctly.
    Call both methods to print values to the console.

    Tips:
      Use int or long for your number data types is probably a good idea.
      1 minute = 60 seconds and 1 hour = 60 minutes or 3600 seconds.
    Bonus:
      For the input 61 minutes output should be 01h 01m 00s, but it is ok if it is 1h 1m 0s (Tip: use if-else)
      Create a new console project and call it SecondsAndMinutesChallenge
  */

  public static String getDurationString(int seconds) {
    if ( seconds < 0){
      return "Invalid Values";
    }
    int minutes = (int) (seconds/60);
    int second = seconds - minutes * 60;

    return seconds + " seconds is equals " + getDurationString(minutes, second);
  }

  public static String getDurationString(int minutes, int seconds) {
    if (minutes < 0 || seconds < 0 || seconds > 59){
      return "Invalid Values";
    }

    int hour = (int) (minutes/60);
    int minute = minutes - hour * 60;

    return hour + "h and " + minute + "m " + seconds + "s!";
  }
}
