package CodingBat.WarmUp1;

public class Close10 {
  /*


Given 2 int values, return whichever value is nearest to the value 10, or return 0 in the event of a tie.
Note that Math.abs(n) returns the absolute value of a number.


close10(8, 13) → 8
close10(13, 8) → 8
close10(13, 7) → 0
   */
  public static void main(String[] args) {

  }

  public int close10(int a, int b) {
    int firstDiff = Math.abs(a-10);
    int secondDiff = Math.abs(b-10);

    if (firstDiff < secondDiff) return a;
    else if(firstDiff > secondDiff) return b;
    return 0;

  }
}
