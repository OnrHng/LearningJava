package Interview.InterfaceVsAbstraction;

public interface IReadable {
  String read();

  default int amountOfPage() {
    return -1;
  }
}
