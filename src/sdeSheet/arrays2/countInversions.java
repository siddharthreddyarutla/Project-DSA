package sdeSheet.arrays2;

import java.util.ArrayList;
import java.util.List;

public class countInversions {

  /**
   * Given an array of integers arr[]. Find the Inversion Count in the array.
   * Two elements arr[i] and arr[j] form an inversion if arr[i] > arr[j] and i < j.
   * <p>
   * Inversion Count: For an array, inversion count indicates how far (or close) the array is
   * from being sorted. If the array is already sorted then the inversion count is 0.
   * If an array is sorted in the reverse order then the inversion count is the maximum.
   * <p>
   * Examples:
   * <p>
   * Input: arr[] = [2, 4, 1, 3, 5]
   * Output: 3
   * Explanation: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
   * Input: arr[] = [2, 3, 4, 5, 6]
   * Output: 0
   * Explanation: As the sequence is already sorted so there is no inversion count.
   */

  public static void main(String[] args) {
    System.out.println(inversionCount(new int[] {2, 4, 1, 3, 5}));
    System.out.println(inversionCountOptimized(new int[] {2, 4, 1, 3, 5}));
    System.out.println(inversionCountOptimized(new int[] {2, 3, 4, 5, 6}));
    System.out.println(inversionCountOptimized(new int[] {5, 3, 2, 4, 1}));
  }

  /**
   * Time Complexity: O(N2), where N = size of the given array.
   * Reason: We are using nested loops here and those two loops roughly run for N times.
   * <p>
   * Space Complexity: O(1) as we are not using any extra space to solve this problem.
   *
   * @param arr
   *
   * @return
   */
  public static int inversionCount(int[] arr) {
    int inversionCount = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[i] > arr[j] && i < j) {
          inversionCount++;
        }
      }
    }
    return inversionCount;
  }


  /**
   * Using merge sort we are finding n no of steps required to sort the array
   *
   * @param arr
   *
   * @return
   */

  public static int inversionCountOptimized(int[] arr) {
    return mergeSort(arr, 0, arr.length - 1);
  }

  public static int mergeSort(int[] nums, int low, int high) {
    int inversionCount = 0;
    if (low >= high) {
      return inversionCount;
    }
    int mid = (low + high) / 2;
    inversionCount += mergeSort(nums, low, mid);
    inversionCount += mergeSort(nums, mid + 1, high);
    inversionCount += merge(nums, low, mid, high);
    return inversionCount;
  }

  public static int merge(int[] arr, int low, int mid, int high) {
    List<Integer> temp = new ArrayList<>(arr.length);
    int left = low;
    int right = mid + 1;
    int inversionCount = 0;
    while ((left <= mid) && (right <= high)) {
      if (arr[left] <= arr[right]) {
        temp.add(arr[left]);
        left++;
      } else {
        temp.add(arr[right]);
        inversionCount += (mid - left + 1);
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
    return inversionCount;
  }
}
