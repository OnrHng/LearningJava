package OOPMasterChallenge;

public class HealthyBurger extends Hamburger{
  private String healthyExtraName;
  private int healthyExtraPrice;
  private int basePrice;


  public HealthyBurger(int price, String meat) {
    super("Healthy Burger", price, meat, "Brown Bread");
    this.basePrice = super.itemizeHamburger();
  }

  public void addHealthyAddition(String name, int price) {
    this.healthyExtraName = name;
    this.healthyExtraPrice = price;
  }

  @Override
  public int itemizeHamburger() {

    if (this.healthyExtraName != null) {
      this.basePrice += this.healthyExtraPrice;
      System.out.println("Added " + this.healthyExtraName +  " Price for an Extra " + this.healthyExtraPrice +" Euro");
    }
    return this.basePrice;
  }
}
