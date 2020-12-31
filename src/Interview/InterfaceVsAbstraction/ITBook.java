package Interview.InterfaceVsAbstraction;

public class ITBook implements IReadable{

  @Override
  public String read() {
    return "Learn IT quickly!!!";
  }
}
