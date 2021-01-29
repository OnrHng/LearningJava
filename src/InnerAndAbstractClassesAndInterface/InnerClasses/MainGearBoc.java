package InnerAndAbstractClassesAndInterface.InnerClasses;

import java.util.Scanner;

public class MainGearBoc {
  private static Scanner scanner = new Scanner(System.in);
  private static StartEngine btnPrint = new StartEngine("Print");

  public static void main(String[] args) {

//        class ClickListener implements Button.OnClickListener {
//            public ClickListener() {
//                System.out.println("I've been attached");
//            }
//
//            @Override
//            public void onClick(String title) {
//                System.out.println(title + " was clicked");
//            }
//        }
//
//        btnPrint.setOnClickListener(new ClickListener());

    // bu ornek ise anonymous inner class lara birer ornektir. mehtod icerisinde inner classin override
    // olan methodlari implement edilerek olusturulur. bunun icin bu classi yukari goruldugu gibi ayri bir
    // interface olarak kaydetmemeye gerek yoktur.

    btnPrint.setOnClickListener(new StartEngine.OnClickListener() {
      @Override
      public void onClick(String title) {
        System.out.println(title + " was clicked");
      }
    });
    listen();
  }

  private static void listen() {
    boolean quit = false;
    while(!quit) {
      int choice = scanner.nextInt();
      scanner.nextLine();
      switch(choice) {
        case 0:
          quit = true;
          break;
        case 1:
          btnPrint.onClick();

      }
    }
  }
}
