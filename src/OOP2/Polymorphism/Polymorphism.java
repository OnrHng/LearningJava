package OOP2.Polymorphism;

public class Polymorphism {
  public static void main(String[] args) {
    Car car = new Car(8, "Base Car");
    System.out.println(car.startEngine());
    System.out.println(car.accelerate());
    System.out.println(car.brake());

    BMW bmw = new BMW(4, "BMW");
    System.out.println(bmw.startEngine());
    System.out.println(bmw.accelerate());
    System.out.println(bmw.brake());

  }
}


class Car {
  private boolean engine;
  private int cylinders;
  private String name;
  private int wheels;

  public Car(int cylinders, String name) {
    this.cylinders = cylinders;
    this.name = name;
    this.wheels = 4;
    this.engine = true;
  }

  public boolean isEngine() {
    return engine;
  }

  public int getCylinders() {
    return cylinders;
  }

  public String getName() {
    return name;
  }

  public int getWheels() {
    return wheels;
  }

  public String startEngine() {
    return "CAR ->  startEngine()";
  }

  public String accelerate() {
    return "Car -> accelerate()";
  }

  public String brake() {
    return "Car -> brake()";
  }
}

class BMW extends Car{

  public BMW(int cylinders, String name) {
    super(cylinders, name);
  }

  @Override
  public String startEngine() {
    return "BMW -> started";
  }

  @Override
  public String accelerate() {
    return "BMW -> accelerate";
  }

  @Override
  public String brake() {
    return "BMW -> brake";
  }
}

