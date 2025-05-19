package sdesheet.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

  // https://takeuforward.org/data-structure/merge-sort-algorithm/

  /**
   * Problem:  Given an array of size n, sort the array using Merge Sort.
   * <p>
   * Examples:
   * <p>
   * Example 1:
   * Input: N=5, arr[]={4,2,1,6,7}
   * Output: 1,2,4,6,7,
   * <p>
   * <p>
   * Example 2:
   * Input: N=7,arr[]={3,2,8,5,1,4,23}
   * Output: 1,2,3,4,5,8,23
   */

  public static void main(String[] args) {
    System.out.println(Arrays.toString(sortArray(new int[] {5, 2, 3, 1})));
  }

  /**
   * Time complexity: O(nlogn)
   * Reason: At each step, we divide the whole array, for that logn and we assume n steps are
   * taken to get a sorted array, so overall time complexity will be nlogn
   * Space complexity: O(n)
   * Reason: We are using a temporary array to store elements in sorted order.
   * Auxiliary Space Complexity: O(n)
   *
   * @param nums
   *
   * @return
   */
  public static int[] sortArray(int[] nums) {
    int n = nums.length;
    mergeSort(nums, 0, n - 1);
    return nums;
  }

  public static void mergeSort(int[] nums, int low, int high) {
    if (low >= high) {
      return;
    }
    int mid = (low + high) / 2;
    mergeSort(nums, low, mid);
    mergeSort(nums, mid + 1, high);
    merge(nums, low, mid, high);
  }

  public static void merge(int arr[], int low, int mid, int high) {
    List<Integer> temp = new ArrayList<>(arr.length);
    int left = low;
    int right = mid + 1;
    while ((left <= mid) && (right <= high)) {
      if (arr[left] <= arr[right]) {
        temp.add(arr[left]);
        left++;
      } else {
        temp.add(arr[right]);
        right++;
      }
    }
    while (left <= mid) {
      temp.add(arr[left]);
      left++;
    }
    while (right <= high) {
      temp.add(arr[right]);
      right++;
    }
    for (int i = low; i <= high; i++) {
      arr[i] = temp.get(i - low);
    }
  }
}
