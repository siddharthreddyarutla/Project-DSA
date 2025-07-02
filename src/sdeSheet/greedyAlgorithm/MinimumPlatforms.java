package sdeSheet.greedyAlgorithm;

import utils.GenericUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinimumPlatforms {

  // https://takeuforward.org/data-structure/minimum-number-of-platforms-required-for-a-railway/

  /**
   * You are given the arrival times arr[] and departure times dep[] of all trains that arrive at
   * a railway station on the same day. Your task is to determine the minimum number of platforms
   * required at the station to ensure that no train is kept waiting.
   * <p>
   * At any given time, the same platform cannot be used for both the arrival of one train and
   * the departure of another. Therefore, when two trains arrive at the same time, or when one
   * arrives before another departs, additional platforms are required to accommodate both trains.
   * <p>
   * Examples:
   * <p>
   * Input: arr[] = [900, 940, 950, 1100, 1500, 1800], dep[] = [910, 1200, 1120, 1130, 1900, 2000]
   * Output: 3
   * Explanation: There are three trains during the time 9:40 to 12:00. So we need a minimum of 3
   * platforms.
   * Input: arr[] = [900, 1235, 1100], dep[] = [1000, 1240, 1200]
   * Output: 1
   * Explanation: All train times are mutually exclusive. So we need only one platform
   * Input: arr[] = [1000, 935, 1100], dep[] = [1200, 1240, 1130]
   * Output: 3
   * Explanation: All 3 trains have to be there from 11:00 to 11:30
   */

  public static void main(String[] args) {
    System.out.println(findPlatform(new int[] {900, 940, 950, 1100, 1500, 1800},
        new int[] {910, 1200, 1120, 1130, 1900, 2000}));
    System.out.println();
    System.out.println(countPlatforms(new int[] {900, 940, 950, 1100, 1500, 1800},
        new int[] {910, 1200, 1120, 1130, 1900, 2000}));
  }


  /**
   * Time Complexity: O(n^2)  (due to two nested loops).
   * <p>
   * Space Complexity: O(1)  (no extra space used).
   *
   * @param arr
   * @param dep
   *
   * @return
   */
  public static int findPlatform(int arr[], int dep[]) {
    List<GenericUtils.Pair<Integer, Integer>> pairList = new ArrayList<>(arr.length);
    for (int i = 0; i < arr.length; i++) {
      GenericUtils.Pair<Integer, Integer> pair = new GenericUtils.Pair<>(arr[i], dep[i]);
      pairList.add(pair);
    }
    pairList.sort(Comparator.comparingInt(a -> a.first));

    int nOfPlatforms = 0;
    while (!pairList.isEmpty()) {
      nOfPlatforms++;
      int lastDepature = pairList.get(0).second;
      List<GenericUtils.Pair<Integer, Integer>> assigned = new ArrayList<>();
      assigned.add(pairList.get(0));
      for (int i = 1; i < pairList.size(); i++) {
        if (pairList.get(i).first > lastDepature) {
          lastDepature = pairList.get(i).second;
          assigned.add(pairList.get(i));
        }
      }
      pairList.removeAll(assigned);
    }
    return nOfPlatforms;
  }

  /**
   * Time Complexity: O(n^2)  (due to two nested loops).
   * <p>
   * Space Complexity: O(1)  (no extra space used).
   *
   * @param arr
   * @param dep
   *
   * @return
   */
  public static int countPlatforms(int arr[], int dep[]) {
    int n = arr.length;
    int ans = 1;
    for (int i = 0; i <= n - 1; i++) {
      int count = 1;
      for (int j = i + 1; j <= n - 1; j++) {
        if ((arr[i] >= arr[j] && arr[i] <= dep[j]) || (arr[j] >= arr[i] && arr[j] <= dep[i])) {
          count++;
        }
      }
      ans = Math.max(ans, count); //updating the value
    }
    return ans;
  }

  /**
   * Time Complexity: O(nlogn)   (Sorting takes O(nlogn) and traversal of arrays takes O(n) so
   * overall time complexity is O(nlogn)).
   * <p>
   * Space complexity: O(1)   (No extra space used).
   *
   * @param arr
   * @param dep
   *
   * @return
   */
  static int findPlatformOptimized(int arr[], int dep[]) {
    if (arr.length == 1) {
      return 1;
    }
    int n = arr.length;
    Arrays.sort(arr);
    Arrays.sort(dep);

    int i = 0;
    int j = 0;
    int res = 0;
    int cnt = 0;
    while (i < n && j < n) {
      if (arr[i] <= dep[j]) {
        cnt++;
        i++;
      } else {
        cnt--;
        j++;
      }
      res = Math.max(res, cnt);
    }
    return res;
  }
}
