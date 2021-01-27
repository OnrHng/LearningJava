package OOP2.Composition;

public class CompositionMain {
  // Birlesim
  // class lar arasinda ki iliskiler dir mesela pc case motherboard(ayri bir class) ile ram(class) ile iliskili bir yapidir,
  // yani bir classin icersinde baska bir classi instance variable olarak define etmeye composition denir.
  // Bir pc classimiz oldugunu dusunursenirz case monitor ve mainboard iliskilerdir ve bu class lar pc classinin instance variablelaridir.


  // OOP eger iki imkan varsa compostion veya inheritance, ilk onceligi composition a ver. cunku cok fazla advantage lari ve flexibility
  // verir.

  // let create a pc
  public static void main(String[] args) {
    Case theCase = new Case("Gaming", "Sony", "120W", new Dimensions(30,50, 50));
    Monitor monitor = new Monitor("27inch LCD", "Sony", 27, new Resolution(1920,1080));
    Motherboard motherboard = new Motherboard("Asus XY", "Asus", 2, 2, "BIOS 1.0");

    PC dell = new PC(theCase, monitor, motherboard);
    dell.powerUp();
  }


  // EXAMPLE
  // Create a single room of a house using composition.
  // Think about the things that should be included in the room.
  // Maybe physical parts of the house but furniture as well
  // Add at least one method to access an object via a getter and
  // then that objects public method as you saw in the previous video
  // then add at least one method to hide the object e.g. not using a getter
  // but to access the object used in composition within the main class
  // like you saw in this video.


}
