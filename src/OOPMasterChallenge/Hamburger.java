package OOPMasterChallenge;

public class Hamburger {
  private String name;
  private int price;
  private String meat;
  private String breadType;

  private String additionName;
  private int additionPrice;

  public Hamburger(String name, int price, String meat, String breadType) {
    this.name = name;
    this.price = price;
    this.meat = meat;
    this.breadType = breadType;
  }

  public void addHamburgerAddition(String name, int price){
    this.additionName = name;
    this.additionPrice = price;
  }

  public int itemizeHamburger() {
    int hamburgerPrice = this.price;
    System.out.println(this.name + " on a " + this.breadType + " roll price is " + hamburgerPrice);

    if (this.additionName != null){
      hamburgerPrice += this.additionPrice;
      System.out.println("Added "+ this.additionName + " for extra " + this.additionPrice);
    }
    this.price = hamburgerPrice;
    return this.price;
  }
}
