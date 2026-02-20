package neetCode_150.recursion;

public class TowersOfHanoi {

  public static void main(String[] args) {
  }

  public int towerOfHanoi(int n, int from, int to, int aux) {
    return towersOfHanoi(n, from, aux, to);
  }

  public int towersOfHanoi(int n, int source, int helper, int destination) {

    if (n == 0) {
      return 0;
    }

    int left = towersOfHanoi(n - 1, source, destination, helper);
    int move = 1;
    int right = towersOfHanoi(n - 1, helper, source, destination);
    return left + right + move;
  }
}
