package OOP2.Encapsulation;

public class Printer {

  private int tonerLevel;
  private int pagesPrinted;
  private boolean duplex;

  public Printer(int tonerLevel, boolean duplex) {
    if (tonerLevel >-1 &&  tonerLevel <= 100 ) {
      this.tonerLevel = tonerLevel;
    } else {
      this.tonerLevel = -1;
    }

    this.pagesPrinted = 0;
    this.duplex = duplex;
  }

  public int addToner(int tonerAmount) {
    if (tonerAmount > 0 && tonerAmount <= 100) {
      if (tonerAmount + tonerLevel > 100) {
        return -1;
      }

      this.tonerLevel += tonerAmount;
      return  this.tonerLevel;
    } else {
      return -1;
    }
  }

  public int printPages(int pages) {

    int pagesToPrint = pages;
    if (this.duplex){
      pagesToPrint = (pages / 2) + (pages % 2);
      System.out.println("Printing in duplex mode");
    }

    this.pagesPrinted += pagesToPrint;
    return pagesToPrint;

  }

  public int getPagesPrinted() {
    return pagesPrinted;
  }


}


class Main{
  public static void main(String[] args) {
    Printer printer = new Printer(50, true);
    System.out.println("Initial page count - " + printer.getPagesPrinted());

    int pagesPrinted = printer.printPages(4);
    System.out.println("Printed pages " + pagesPrinted + " new print count of Printer " + printer.getPagesPrinted());
    pagesPrinted = printer.printPages(3);
    System.out.println("Printed pages " + pagesPrinted + " new print count of Printer " + printer.getPagesPrinted());

  }
}