package sdesheet.arrays3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class majorityElementNBy3_229 {

  // https://takeuforward.org/data-structure/majority-elementsn-3-times-find-the-elements-that-appears-more-than-n-3-times-in-the-array/

  /**
   * Problem Statement: Given an array of N integers. Find the elements that appear more than N/3
   * times in the array. If no such element exists, return an empty vector.
   * <p>
   * Pre-requisite: Majority Element(>N/2 times)
   * <p>
   * Examples
   * <p>
   * Example 1:
   * Input Format: N = 5, array[] = {1,2,2,3,2}
   * Result: 2
   * Explanation: Here we can see that the Count(1) = 1, Count(2) = 3 and Count(3) = 1.Therefore,
   * the count of 2 is greater than N/3 times. Hence, 2 is the answer.
   * <p>
   * Example 2:
   * Input Format:  N = 6, array[] = {11,33,33,11,33,11}
   * Result: 11 33
   * Explanation: Here we can see that the Count(11) = 3 and Count(33) = 3. Therefore, the count
   * of both 11 and 33 is greater than N/3 times. Hence, 11 and 33 is the answer.
   */

  public static void main(String[] args) {
    System.out.println(majorityElement(new int[] {11, 33, 33, 11, 33, 11}));
    System.out.println(majorityElementOptimized(new int[] {3, 2, 3}));
    System.out.println(majorityElementOptimized(new int[] {1, 2}));
  }

  /**
   * Time Complexity: O(N*logN), where N = size of the given array.
   * Reason: We are using a map data structure. Insertion in the map takes logN time. And we are
   * doing it for N elements. So, it results in the first term O(N*logN).
   * If we use unordered_map instead, the first term will be O(N) for the best and average case
   * and for the worst case, it will be O(N2).
   * <p>
   * Space Complexity: O(N) as we are using a map data structure. We are also using a list that
   * stores a maximum of 2 elements. That space used is so small that it can be considered constan
   *
   * @param nums
   *
   * @return
   */
  public static List<Integer> majorityElement(int[] nums) {
    Map<Integer, Integer> integerMap = new HashMap<>();
    List<Integer> majorityElements = new ArrayList<>();
    for (int num : nums) {
      int value = integerMap.getOrDefault(num, 0);
      integerMap.put(num, value + 1);
    }
    for (Map.Entry<Integer, Integer> entry : integerMap.entrySet()) {
      if (entry.getValue() > (nums.length / 3)) {
        majorityElements.add(entry.getKey());
      }
    }
    return majorityElements;
  }

  /**
   * Time Complexity: O(N) + O(N), where N = size of the given array.
   * Reason: The first O(N) is to calculate the counts and find the expected majority elements.
   * The second one is to check if the calculated elements are the majority ones or not.
   * <p>
   * Space Complexity: O(1) as we are only using a list that stores a maximum of 2 elements. The
   * space used is so small that it can be considered constant.
   *
   * @param nums
   *
   * @return
   */
  public static List<Integer> majorityElementOptimized(int[] nums) {
    int votes1 = 0;
    int votes2 = 0;
    int candidate1 = -1;
    int candidate2 = -1;
    for (int num : nums) {
      if (votes1 == 0 && candidate2 != num) {
        candidate1 = num;
        votes1 = 1;
      } else if (votes2 == 0 && candidate1 != num) {
        candidate2 = num;
        votes2 = 1;
      } else if (candidate1 == num) {
        votes1++;
      } else if (candidate2 == num) {
        votes2++;
      } else {
        votes1--;
        votes2--;
      }
    }
    List<Integer> majorityList = new ArrayList<>();
    int cnt1 = 0;
    int cnt2 = 0;
    for (int num : nums) {
      if (candidate1 == num) {
        cnt1++;
      } else if (candidate2 == num) {
        cnt2++;
      }
    }
    int min = (nums.length / 3) + 1;
    if (cnt1 >= min) {
      majorityList.add(candidate1);
    }
    if (cnt2 >= min) {
      majorityList.add(candidate2);
    }
    return majorityList.stream().sorted().toList();
  }
}
