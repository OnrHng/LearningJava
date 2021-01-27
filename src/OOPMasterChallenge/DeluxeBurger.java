package OOPMasterChallenge;

public class DeluxeBurger extends Hamburger{
  public DeluxeBurger() {
    super("Deluxe Burger", 15, "Sausage", "White Bread");
    super.addHamburgerAddition("Chips", 3);
    this.itemizeHamburger();
    super.addHamburgerAddition("Cola", 2);

  }

  @Override
  public void addHamburgerAddition(String name, int price) {
    System.out.println("Cannot applied, Just deluxe Paket include Chips und drinks");
  }
}
