
public class SimpleLoop {
  /**
   * Computes the sum of integers between low and high (inclusive). Yes, this can
   * be done without a loop, but the point is to practice the syntax for a loop.
   *
   * Sample input / output:
   * input: low=3, high=4
   * output: 3 + 4 = 7
   *
   * input: low=-1, high = 3
   * output: -1 + 0 + 1 + 2 + 3 = 5
   * 
   * @param low
   * @param high
   * @return An integer that is the sum of numbers between low and high
   */
  public static int sum(int low, int high) {
    int sum = 0;
    for (int i = low; i <= high; i++) {
      sum += i;
    }
    return sum;
  }
}
