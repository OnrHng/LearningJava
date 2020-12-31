package Interview.InterfaceVsAbstraction;

public class MathBook implements IReadable{
  @Override
  public String read() {
    return "What is the result of 4+4=?";
  }

  // bu concerate class tir., bunlar icinde detay barindiran classlardir, bir interface den veya
  // bir abstract class tan impliment veya extend edilmis classtir.
}
