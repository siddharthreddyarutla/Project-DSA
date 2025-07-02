package utils;

public class GenericUtils {

  public static class Pair<T, U> {
    public final T first;
    public final U second;

    public Pair(T first, U second) {
      this.first = first;
      this.second = second;
    }
  }
}
