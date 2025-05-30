package sdesheet.arrays4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class fourSum_18 {

  //  https://takeuforward.org/data-structure/4-sum-find-quads-that-add-up-to-a-target-value/

  /**
   * Given an array nums of n integers, return an array of all the unique quadruplets [nums[a],
   * nums[b], nums[c], nums[d]] such that:
   * <p>
   * 0 <= a, b, c, d < n
   * a, b, c, and d are distinct.
   * nums[a] + nums[b] + nums[c] + nums[d] == target
   * You may return the answer in any order.
   * <p>
   * <p>
   * <p>
   * Example 1:
   * <p>
   * Input: nums = [1,0,-1,0,-2,2], target = 0
   * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
   * Example 2:
   * <p>
   * Input: nums = [2,2,2,2,2], target = 8
   * Output: [[2,2,2,2]]
   */

  public static void main(String[] args) {
    System.out.println(fourSum(new int[] {1, 0, -1, 0, -2, 2}, 0));
    System.out.println(fourSum(new int[] {2, 2, 2, 2}, 8));
    System.out.println();
    System.out.println(fourSumBetter(new int[] {1, 0, -1, 0, -2, 2}, 0));
    System.out.println(fourSumBetter(new int[] {2, 2, 2, 2}, 8));
    System.out.println();
    System.out.println(fourSumOptimized(new int[] {1, 0, -1, 0, -2, 2}, 0));
    System.out.println(fourSumOptimized(new int[] {2, 2, 2, 2}, 8));
    System.out.println();
    System.out.println(fourSumOptimized1(new int[] {1, 0, -1, 0, -2, 2}, 0));
    System.out.println(fourSumOptimized1(new int[] {2, 2, 2, 2}, 8));
  }

  /**
   * Time Complexity: O(N4), where N = size of the array.
   * Reason: Here, we are mainly using 4 nested loops. But we not considering the time complexity
   * of sorting as we are just sorting 4 elements every time.
   * <p>
   * Space Complexity: O(2 * no. of the quadruplets) as we are using a set data structure and a
   * list to store the quads.
   *
   * @param nums
   * @param target
   *
   * @return
   */
  public static List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> fourSumResult = new ArrayList<>();
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        for (int k = j + 1; k < n; k++) {
          for (int l = k + 1; l < n; l++) {
            if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
              fourSumResult.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k], nums[l])));
            }
          }
        }
      }
    }
    return fourSumResult;
  }

  /**
   * Time Complexity: O(N3*log(M)), where N = size of the array, M = no. of elements in the set.
   * Reason: Here, we are mainly using 3 nested loops, and inside the loops there are some
   * operations on the set data structure which take log(M) time complexity.
   * <p>
   * Space Complexity: O(2 * no. of the quadruplets)+O(N)
   * Reason: we are using a set data structure and a list to store the quads. This results in the
   * first term. And the second space is taken by the set data structure we are using to store
   * the array elements. At most, the set can contain approximately all the array elements and so
   * the space complexity is O(N).
   *
   * @param nums
   * @param target
   *
   * @return
   */
  public static List<List<Integer>> fourSumBetter(int[] nums, int target) {
    int n = nums.length; // size of the array
    HashSet<List<Integer>> st = new HashSet<>();

    // checking all possible quadruplets:
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        HashSet<Long> hashset = new HashSet<>();
        for (int k = j + 1; k < n; k++) {
          // taking bigger data type
          // to avoid integer overflow:
          long sum = nums[i] + nums[j];
          sum += nums[k];
          long fourth = target - sum;
          if (hashset.contains(fourth)) {
            List<Integer> temp = new ArrayList<>();
            temp.add(nums[i]);
            temp.add(nums[j]);
            temp.add(nums[k]);
            temp.add((int) fourth);
            temp.sort(Integer::compareTo);
            st.add(temp);
          }
          // put the kth element into the hashset:
          hashset.add((long) nums[k]);
        }
      }
    }
    return new ArrayList<>(st);
  }

  public static List<List<Integer>> fourSumOptimized(int[] nums, int target) {
    Arrays.sort(nums);
    HashSet<List<Integer>> fourSumPairs = new HashSet<>();
    for (int i = 0; i < nums.length - 3; i++) {
      for (int l = i + 1; l < nums.length - 2; l++) {
        int j = l + 1;
        int k = nums.length - 1;
        while (j < k) {
          long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
          if (sum == target) {
            fourSumPairs.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k], nums[l])));
            j++;
            k--;
          } else if (sum > target) {
            k--;
          } else {
            j++;
          }
        }
      }
    }
    return new ArrayList<>(fourSumPairs);
  }

  /**
   * Time Complexity: O(N3), where N = size of the array.
   * Reason: Each of the pointers i and j, is running for approximately N times. And both the
   * pointers k and l combined can run for approximately N times including the operation of
   * skipping duplicates. So the total time complexity will be O(N3).
   * <p>
   * Space Complexity: O(no. of quadruplets), This space is only used to store the answer. We are
   * not using any extra space to solve this problem. So, from that perspective, space complexity
   * can be written as O(1).
   *
   * @param nums
   * @param target
   *
   * @return
   */
  public static List<List<Integer>> fourSumOptimized1(int[] nums, int target) {
    Arrays.sort(nums);
    HashSet<List<Integer>> fourSumPairs = new HashSet<>();
    for (int i = 0; i < nums.length - 3; i++) {
      if (i != 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      for (int l = i + 1; l < nums.length - 2; l++) {
        if (l > i + 1 && nums[l] == nums[l - 1]) {
          continue;
        }
        int j = l + 1;
        int k = nums.length - 1;
        while (j < k) {
          long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
          if (sum == target) {
            fourSumPairs.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k], nums[l])));
            j++;
            k--;
            while (j < k && nums[j] == nums[j - 1]) {
              j++;
            }
            while (j < k && nums[k] == nums[k + 1]) {
              k--;
            }
          } else if (sum > target) {
            k--;
          } else {
            j++;
          }
        }
      }
    }
    return new ArrayList<>(fourSumPairs);
  }
}
