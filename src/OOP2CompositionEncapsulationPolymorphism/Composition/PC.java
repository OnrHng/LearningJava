package OOP2CompositionEncapsulationPolymorphism.Composition;

public class PC {
  private Case theCase;
  private Monitor monitor;
  private Motherboard motherboard;

  public PC(Case theCase, Monitor monitor, Motherboard motherboard) {
    this.theCase = theCase;
    this.monitor = monitor;
    this.motherboard = motherboard;
  }

  public void powerUp() {
    theCase.pressPowerButton();
    drawLogo(1000, 500, "Blue");
  }

  private void drawLogo(int x, int y, String color) {
    // Fancy graphics
    monitor.drawPixelAt(x, y, color);
  }
}
