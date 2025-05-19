package sdesheet.arrays3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class majorityElement {

  // https://takeuforward.org/data-structure/find-the-majority-element-that-occurs-more-than-n-2-times/

  /**
   * Given an array nums of size n, return the majority element.
   * <p>
   * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume
   * that the majority element always exists in the array.
   * <p>
   * Example 1:
   * <p>
   * Input: nums = [3,2,3]
   * Output: 3
   * Example 2:
   * <p>
   * Input: nums = [2,2,1,1,1,2,2]
   * Output: 2
   */

  public static void main(String[] args) {
    System.out.println(majorityElement(new int[] {3, 2, 3}));
    System.out.println(majorityElement(new int[] {-1, 1, 1, 1, 2, 1}));
    System.out.println(majorityElementBetter(new int[] {-1, 1, 1, 1, 2, 1}));
  }

  /**
   * T.C = O(n log n)
   * S.C = O(1)
   *
   * @param nums
   *
   * @return
   */
  public static int majorityElement(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    Arrays.sort(nums);
    int cnt = 1;
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] == nums[i + 1]) {
        cnt++;
      } else {
        cnt = 1;
      }
      if (cnt > (nums.length / 2)) {
        return nums[i];
      }
    }
    return -1;
  }

  /**
   * Time Complexity: O(N*logN) + O(N), where N = size of the given array.
   * Reason: We are using a map data structure. Insertion in the map takes logN time. And we are
   * doing it for N elements. So, it results in the first term O(N*logN). The second O(N) is for
   * checking which element occurs more than floor(N/2) times. If we use unordered_map instead,
   * the first term will be O(N) for the best and average case and for the worst case, it will be
   * O(N2).
   * <p>
   * Space Complexity: O(N) as we are using a map data structure
   *
   * @param nums
   *
   * @return
   */
  public static int majorityElementBetter(int[] nums) {
    HashMap<Integer, Integer> majorityHashMap = new HashMap<>();
    for (int num : nums) {
      int value = majorityHashMap.getOrDefault(num, 0);
      majorityHashMap.put(num, value + 1);
    }

    for (Map.Entry<Integer, Integer> entry : majorityHashMap.entrySet()) {
      if (entry.getValue() > (nums.length / 2)) {
        return entry.getKey();
      }
    }
    return -1;
  }
}
