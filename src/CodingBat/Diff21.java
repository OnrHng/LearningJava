package CodingBat;

public class Diff21 {
//
//  Given an int n, return the absolute difference between n and 21,
//  except return double the absolute difference if n is over 21.
//
//
//  diff21(19) → 2
//  diff21(10) → 11
//  diff21(21) → 0
//  diff21(23) → 4

  public static void main(String[] args) {
    System.out.println(diff21(19));
    System.out.println(diff21(10));
    System.out.println(diff21(21));
    System.out.println(diff21(23));
  }

  public static int diff21(int n) {
    return n <= 21 ? (21 - n) : (n - 21) * 2;

//    if (n <= 21) {
//      return 21 - n;
//    } else {
//      return (n - 21) * 2;
//    }

//    if (n > 21) {
//      return (n - 21) * 2;
//    } else {
//      return 21 - n;
//    }

  }
}
