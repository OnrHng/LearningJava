package OOPMasterChallenge;

public class MasterChallenge {
  public static void main(String[] args) {
    Hamburger hamburger = new Hamburger("Basic", 10, "Ketchap" , "Normal White");
    hamburger.addHamburgerAddition("Cheese", 2);
    hamburger.itemizeHamburger();
    hamburger.addHamburgerAddition("Sossis", 4 );
    System.out.println("Total price is " + hamburger.itemizeHamburger());


    HealthyBurger healthyBurger = new HealthyBurger(12, "Lamb");
    healthyBurger.addHealthyAddition("Carotte", 1);
    healthyBurger.itemizeHamburger();
    healthyBurger.addHealthyAddition("Egg" , 3);
    System.out.println("Total Price is for " +
            healthyBurger.getClass().getSimpleName() + " Euro " + healthyBurger.itemizeHamburger());

//    Deluxe Hamburger
    DeluxeBurger deluxeBurger = new DeluxeBurger();
    deluxeBurger.addHamburgerAddition("Cheese", 3);
//    deluxeBurger.itemizeHamburger();

    System.out.println("Total Price is for " +
            deluxeBurger.getClass().getSimpleName() + " Euro " + deluxeBurger.itemizeHamburger());

  }
}
