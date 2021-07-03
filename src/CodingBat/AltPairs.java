package CodingBat;

public class AltPairs {

  /*

Given a string, return a string made of the chars at indexes 0,1, 4,5, 8,9 ... so "kittens" yields "kien".


altPairs("kitten") → "kien"
altPairs("Chocolate") → "Chole"
altPairs("CodingHorror") → "Congrr"

   */
  public static void main(String[] args) {

  }
  public static String altPairs(String str) {
    String result="";
    //Chocolate  9
    for (int i=0; i < str.length(); i += 4){ // 8
      if (i + 2 > str.length()){
        result += str.charAt(str.length()-1); // chole
      } else {
        result= result + str.substring(i,i+2); // chol
      }

    }
    return result; // chole

  }
}
