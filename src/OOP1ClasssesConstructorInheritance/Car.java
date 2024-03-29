package OOP1ClasssesConstructorInheritance;

public class Car extends Vehicle{
  private int wheels; // tekerlekler
  private int doors;
  private int gears; // vites
  private boolean isManual;

  private int currentGear;

  public Car(String name, String size, int wheels, int doors, int gears, boolean isManual) {
    super(name, size);
    this.wheels = wheels;
    this.doors = doors;
    this.gears = gears;
    this.isManual = isManual;
    this.currentGear = 1;
  }

  public void changeGear(int currentGear) { // vitesi degistir
    this.currentGear = currentGear;
    System.out.println("Car.setCurrentGear(): Changed to " + this.currentGear + " gear.");
  }

  public void changeVelocity(int speed, int direction) { // hizi degistir
    System.out.println("Car.changeVelocity() : Velocity " + speed + " direction " + direction);
    move(speed, direction);
  }

}
