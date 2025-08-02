package sdeSheet.binarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedianOfSortedArrays_4 {

  // https://takeuforward.org/data-structure/median-of-two-sorted-arrays-of-different-sizes/

  /**
   * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of
   * the two sorted arrays.
   * <p>
   * The overall run time complexity should be O(log (m+n)).
   * <p>
   * Example 1:
   * <p>
   * Input: nums1 = [1,3], nums2 = [2]
   * Output: 2.00000
   * Explanation: merged array = [1,2,3] and median is 2.
   * Example 2:
   * <p>
   * Input: nums1 = [1,2], nums2 = [3,4]
   * Output: 2.50000
   * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
   */

  public static void main(String[] args) {
    System.out.println(findMedianSortedArrays(new int[] {1, 2}, new int[] {3, 4}));
    System.out.println(findMedianSortedArraysBetter(new int[] {1, 2}, new int[] {3, 4}));
  }

  /**
   * Time Complexity: O(n1+n2), where  n1 and n2 are the sizes of the given arrays.
   * Reason: We traverse through both arrays linearly.
   * <p>
   * Space Complexity: O(n1+n2), where  n1 and n2 are the sizes of the given arrays.
   * Reason: We are using an extra array of size (n1+n2) to solve this problem.
   *
   * @param nums1
   * @param nums2
   *
   * @return
   */
  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    List<Integer> list = new ArrayList<>();
    for (int num : nums1) {
      list.add(num);
    }
    for (int num : nums2) {
      list.add(num);
    }
    Collections.sort(list);
    int n = nums1.length + nums2.length;
    if (n % 2 == 0) {
      return (list.get(n / 2) + list.get((n - 1) / 2)) / 2.0;
    } else {
      return (double) list.get(n / 2);
    }
  }

  // Using merge sort algo

  /**
   * Time Complexity: O(n1+n2), where  n1 and n2 are the sizes of the given arrays.
   * Reason: We traverse through both arrays linearly.
   * <p>
   * Space Complexity: O(n1+n2), where  n1 and n2 are the sizes of the given arrays.
   * Reason: We are using an extra array of size (n1+n2) to solve this problem.
   *
   * @param nums1
   * @param nums2
   *
   * @return
   */
  public static double findMedianSortedArraysBetter(int[] nums1, int[] nums2) {
    List<Integer> list = new ArrayList<>();
    int n = nums1.length;
    int m = nums2.length;
    int i = 0;
    int j = 0;
    while (i < n && j < m) {
      if (nums1[i] < nums2[j]) {
        list.add(nums1[i]);
        i++;
      } else {
        list.add(nums2[j]);
        j++;
      }
    }
    while (i < n) {
      list.add(nums1[i]);
      i++;
    }
    while (j < m) {
      list.add(nums2[j]);
      j++;
    }
    Collections.sort(list);
    int k = nums1.length + nums2.length;
    if (k % 2 == 0) {
      return (double) (list.get(k / 2) + list.get((k - 1) / 2)) / 2.0;
    } else {
      return (double) list.get(k / 2);
    }
  }
}
