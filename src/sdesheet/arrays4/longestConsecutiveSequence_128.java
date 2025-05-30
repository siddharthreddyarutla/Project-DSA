package sdesheet.arrays4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.TreeMap;
import java.util.TreeSet;

public class longestConsecutiveSequence_128 {

  // https://takeuforward.org/data-structure/longest-consecutive-sequence-in-an-array/

  /**
   * Given an unsorted array of integers nums, return the length of the longest consecutive
   * elements sequence.
   * <p>
   * You must write an algorithm that runs in O(n) time.
   * <p>
   * Example 1:
   * <p>
   * Input: nums = [100,4,200,1,3,2]
   * Output: 4
   * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length
   * is 4.
   * Example 2:
   * <p>
   * Input: nums = [0,3,7,2,5,8,4,6,0,1]
   * Output: 9
   * Example 3:
   * <p>
   * Input: nums = [1,0,1,2]
   * Output: 3
   */

  public static void main(String[] args) {
    System.out.println(longestConsecutive(new int[] {100, 4, 200, 1, 3, 2}));
    System.out.println();
    System.out.println(longestConsecutiveOptimized(new int[] {100, 4, 200, 1, 3, 2}));
    System.out.println();
    System.out.println(
        longestConsecutiveOptimized1(new int[] {9, 1, -3, 2, 4, 8, 3, -1, 6, -2, -4, 7}));
  }

  /**
   * Time Complexity: O(NlogN) + O(N), N = size of the given array.
   * Reason: O(NlogN) for sorting the array. To find the longest sequence, we are using a loop
   * that results in O(N).
   * <p>
   * Space Complexity: O(1), as we are not using any extra space to solve this problem.
   *
   * @param nums
   *
   * @return
   */
  public static int longestConsecutive(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return 1;
    }
    Arrays.sort(nums);
    int count = 1;
    int longestConsecutive = count;
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] + 1 == nums[i + 1]) {
        count++;
        longestConsecutive = Math.max(count, longestConsecutive);
      } else if (nums[i] == nums[i + 1]) {
        continue;
      } else {
        count = 1;
      }
    }
    return longestConsecutive;
  }

  public static int longestConsecutiveOptimized(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return 1;
    }
    TreeMap<Integer, Integer> integerHashMap = new TreeMap<>();
    int count = 1;
    int longestConsecutive = count;
    for (int i = 0; i < nums.length; i++) {
      integerHashMap.put(nums[i], i);
    }
    List<Integer> keys = new ArrayList<>(integerHashMap.keySet());
    for (int i = 0; i < keys.size() - 1; i++) {
      if (keys.get(i) + 1 == keys.get(i + 1)) {
        count++;
        longestConsecutive = Math.max(count, longestConsecutive);
      } else {
        count = 1;
      }
    }
    return longestConsecutive;
  }

  /**
   * Time Complexity: O(N) + O(2*N) ~ O(3*N), where N = size of the array.
   * Reason: O(N) for putting all the elements into the set data structure. After that for every
   * starting element, we are finding the consecutive elements. Though we are using nested loops,
   * the set will be traversed at most twice in the worst case. So, the time complexity is O(2*N)
   * instead of O(N2).
   * <p>
   * Space Complexity: O(N), as we are using the set data structure to solve this problem.
   * <p>
   * Note: The time complexity is computed under the assumption that we are using unordered_set
   * and it is taking O(1) for the set operations.
   * <p>
   * If we consider the worst case the set operations will take O(N) in that case and the total
   * time complexity will be approximately O(N2).
   * And if we use the set instead of unordered_set, the time complexity for the set operations
   * will be O(logN) and the total time complexity will be O(NlogN).
   *
   * @param nums
   *
   * @return
   */
  public static int longestConsecutiveOptimized1(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return 1;
    }
    TreeSet<Integer> hashSet = new TreeSet<>();
    int count = 1;
    int longestConsecutive = count;
    for (int num : nums) {
      hashSet.add(num);
    }
    for (Object num : hashSet.toArray()) {
      int key = (int) num + 1;
      if (hashSet.contains(key)) {
        count++;
        longestConsecutive = Math.max(count, longestConsecutive);
      } else {
        count = 1;
      }
    }
    return longestConsecutive;
  }
}
