package sdeSheet.arrays2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeTwoSortedArray_88 {

  // https://takeuforward.org/data-structure/merge-two-sorted-arrays-without-extra-space/

  /**
   * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two
   * integers m and n, representing the number of elements in nums1 and nums2 respectively.
   * <p>
   * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
   * <p>
   * Example 1:
   * <p>
   * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
   * Output: [1,2,2,3,5,6]
   * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
   * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
   * Example 2:
   * <p>
   * Input: nums1 = [1], m = 1, nums2 = [], n = 0
   * Output: [1]
   * Explanation: The arrays we are merging are [1] and [].
   * The result of the merge is [1].
   */

  public static void main(String[] args) {
    int[] nums1 = {1, 2, 3, 0, 0, 0};
    int[] nums2 = {2, 5, 6};
    //    merge(nums1, 3, nums2, 3);
    mergeOptimized(nums1, 3, nums2, 3);
    System.out.println(Arrays.toString(nums1));
  }

  /**
   * Time Complexity: O(n+m), where n and m are the sizes of the given arrays.
   * <p>
   * Space Complexity: O(n) as we use an extra array of size n+m.
   *
   * @param nums1
   * @param m
   * @param nums2
   * @param n
   */
  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    if (n == 0) {
      return;
    }
    if (m == 0) {
      for (int i = 0; i < n; i++) {
        nums1[i] = nums2[i];
      }
    }
    int p1 = 0;
    int p2 = 0;
    List<Integer> temp = new ArrayList<>(nums1.length);

    while (p1 < m && p2 < n) {
      if (nums1[p1] < nums2[p2]) {
        temp.add(nums1[p1]);
        p1++;
      } else if (nums1[p1] == nums2[p2]) {
        temp.add(nums1[p1]);
        temp.add(nums2[p2]);
        p1++;
        p2++;
      } else {
        temp.add(nums2[p2]);
        p2++;
      }
    }

    while (p1 < m) {
      temp.add(nums1[p1]);
      p1++;
    }
    while (p2 < n) {
      temp.add(nums2[p2]);
      p2++;
    }
    for (int i = 0; i < temp.size(); i++) {
      nums1[i] = temp.get(i);
    }
  }

  /**
   * T.C = O(n + (nums1.length - m)) + O(nums1.length * log n)
   * S.C = O(1)
   *
   * @param nums1
   * @param m
   * @param nums2
   * @param n
   */
  public static void mergeOptimized(int[] nums1, int m, int[] nums2, int n) {
    if (n == 0) {
      return;
    }
    if (m == 0) {
      for (int i = 0; i < n; i++) {
        nums1[i] = nums2[i];
      }
    }
    int j = 0;
    for (int i = m; i < nums1.length && j < n; i++, j++) {
      nums1[i] = nums2[j];
    }
    Arrays.sort(nums1);
  }

}
