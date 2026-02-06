package sdeSheet.arrays1;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(productExceptSelf(new int[] {1, 2, 3, 4})));
    System.out.println(Arrays.toString(productExceptSelfOptimized(new int[] {1, 2, 3, 4})));
  }


  public static int[] productExceptSelf(int[] nums) {

    int n = nums.length;
    int product = 1;
    int[] ans = new int[n];
    for (int i = 0; i < n; i++) {
      int k = (i + 1) % n;
      while (k != i) {
        product *= nums[k];
        k++;
        k = k % n;
      }
      ans[i] = product;
      product = 1;
    }
    return ans;
  }

  public static int[] productExceptSelfOptimized(int[] nums) {
    int n = nums.length;
    int[] prefixProduct = new int[n];
    int[] suffixProduct = new int[n];
    int[] ans = new int[n];
    prefixProduct[0] = 1;
    suffixProduct[n - 1] = 1;

    for (int i = 1; i < n; i++) {
      prefixProduct[i] = prefixProduct[i - 1] * nums[i - 1];
    }

    for (int i = n - 2; i >= 0; i--) {
      suffixProduct[i] = suffixProduct[i + 1] * nums[i + 1];
    }

    for (int i = 0; i < n; i++) {
      ans[i] = prefixProduct[i] * suffixProduct[i];
    }

    return ans;
  }
}
