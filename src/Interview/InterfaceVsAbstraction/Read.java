package Interview.InterfaceVsAbstraction;

import java.util.ArrayList;

/*
* ABSTRACTION :
*    java da nasil yapilir. ya interface/abstract keywords lerini kullanarak yapariz.
*
*   pratik' te
*
* */

public class Read {
  public static void main(String[] args) {
    // SOLID
    // single responsibility
    // open-closed
    // liskov subsitution
    // interface segregation
    // dependency inversion (not injection)

    ArrayList<IReadable> books = new ArrayList<>();
    MathBook mathBook = new MathBook();
    books.add(mathBook);

    ITBook itBook = new ITBook();
    books.add(itBook);

    for (IReadable book : books) { // bu hadise yani booklarimizin hem MathBook olmasi veya ITBook olmasi ve parent
                                  // parent class tipinde onu define etmeye polimorphism denir.
      System.out.println(book.read());
    } // burada polymorphism yapiliyor. Yani for loop un icerisindeki book lar bazilari math kitabi bazilari
        /* it kitabin turundedir ama ozunde hepsi readable dir. Parent class i olan child lari dondurme isindeki
    * POLYMORPHISM kolaylikir. Aslinda bir turu belli ederken ya ITBook yazmaliydik veya MathBook yazmaliydik.
    * bu polymorphism bize bir esneklik kazandiriyor.
    *
    * */

  }
}