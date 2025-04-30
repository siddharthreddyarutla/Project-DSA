package sdesheet.arrays;

public class stockBuyAndSell {

  // https://takeuforward.org/data-structure/stock-buy-and-sell/

  /**
   * Example 1:
   * <p>
   * Input: prices = [7,1,5,3,6,4]
   * Output: 5
   * Explanation: Buy on day 2 (price = 1) and
   * sell on day 5 (price = 6), profit = 6-1 = 5.
   * <p>
   * Note: That buying on day 2 and selling on day 1
   * is not allowed because you must buy before
   * you sell.
   * <p>
   * Example 2:
   * <p>
   * Input: prices = [7,6,4,3,1]
   * Output: 0
   * Explanation: In this case, no transactions are
   * done and the max profit = 0.
   */

  public static void main(String[] args) {
    System.out.println(maxProfit(new int[] {7, 6, 8, 5, 2, 3, 2}));
    System.out.println(maxProfitOptimal(new int[] {7, 6, 8, 5, 2, 3, 2}));
  }

  /**
   * Time complexity: O(n^2)
   * Space Complexity: O(1)
   *
   * @param prices
   *
   * @return
   */
  public static int maxProfit(int[] prices) {
    int profit = 0;
    for (int i = 0; i < prices.length; i++) {
      for (int j = i + 1; j < prices.length; j++) {
        if (prices[j] - prices[i] >= 0) {
          profit = Math.max(profit, prices[j] - prices[i]);
        }
      }
    }
    return profit;
  }


  public static int maxProfitOptimal(int[] prices) {
    int max = 0;
    int min = prices[0];
    for (int price : prices) {
      min = Math.min(min, price);
      max = Math.max(max, price - min);
    }
    return max;
  }
}
