package sdesheet.arrays4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class twoSum_1 {

  // https://takeuforward.org/data-structure/two-sum-check-if-a-pair-with-given-sum-exists-in-array/

  /**
   * Given an array of integers nums and an integer target, return indices of the two numbers
   * such that they add up to target.
   * <p>
   * You may assume that each input would have exactly one solution, and you may not use the same
   * element twice.
   * <p>
   * You can return the answer in any order.
   * <p>
   * <p>
   * <p>
   * Example 1:
   * <p>
   * Input: nums = [2,7,11,15], target = 9
   * Output: [0,1]
   * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
   * Example 2:
   * <p>
   * Input: nums = [3,2,4], target = 6
   * Output: [1,2]
   * Example 3:
   * <p>
   * Input: nums = [3,3], target = 6
   * Output: [0,1]
   */

  public static void main(String[] args) {
    System.out.println(Arrays.toString(twoSum(new int[] {2, 7, 11, 15}, 9)));
    System.out.println(Arrays.toString(twoSumBetter(new int[] {2, 7, 11, 15}, 9)));
    System.out.println(Arrays.toString(twoSumOptimized(new int[] {2, 7, 11, 15}, 9)));

    System.out.println(Arrays.toString(twoSum(new int[] {3, 2, 4}, 6)));
    System.out.println(Arrays.toString(twoSumBetter(new int[] {3, 2, 4}, 6)));
    System.out.println(Arrays.toString(twoSumOptimized(new int[] {3, 2, 4}, 6)));
  }

  /**
   * Time Complexity: O(N2), where N = size of the array.
   * Reason: There are two loops(i.e. nested) each running for approximately N times.
   * <p>
   * Space Complexity: O(1) as we are not using any extra space
   *
   * @param nums
   * @param target
   *
   * @return
   */
  public static int[] twoSum(int[] nums, int target) {
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[] {i, j};
        }
      }
    }
    return new int[] {};
  }

  /**
   * T.C = O(n* logn)
   * S.C = O(n)
   *
   * @param nums
   * @param target
   *
   * @return
   */
  public static int[] twoSumBetter(int[] nums, int target) {
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      hashMap.put(i, nums[i]);
    }
    Arrays.sort(nums);
    int left = 0;
    int right = nums.length - 1;
    int a = 0;
    int b = 0;
    int[] result = new int[2];
    while (left < right) {
      if (nums[left] + nums[right] == target) {
        a = nums[left];
        b = nums[right];
        break;
      } else if ((nums[left] + nums[right]) > target) {
        right--;
      } else {
        left++;
      }
    }
    int i = 0;
    for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
      if (entry.getValue().equals(a) || entry.getValue().equals(b)) {
        result[i] = entry.getKey();
        i++;
      }
    }
    return result;
  }


  /**
   * Time Complexity: O(N), where N = size of the array.
   * Reason: The loop runs N times in the worst case and searching in a hashmap takes O(1)
   * generally. So the time complexity is O(N).
   * *
   * Space Complexity: O(N) as we use the map data structure.
   *
   * @param nums
   * @param target
   *
   * @return
   */
  public static int[] twoSumOptimized(int[] nums, int target) {
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    int[] result = new int[2];
    for (int i = 0; i < nums.length; i++) {
      int searchKey = target - nums[i];
      if (hashMap.containsKey(searchKey)) {
        result[0] = hashMap.get(searchKey);
        result[1] = i;
      } else {
        hashMap.put(nums[i], i);
      }
    }
    return result;
  }
}
