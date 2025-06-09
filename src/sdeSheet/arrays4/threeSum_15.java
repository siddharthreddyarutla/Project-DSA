package sdeSheet.arrays4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class threeSum_15 {

  // https://takeuforward.org/data-structure/3-sum-find-triplets-that-add-up-to-a-zero/

  /**
   * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i
   * != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
   * <p>
   * Notice that the solution set must not contain duplicate triplets.
   * <p>
   * <p>
   * <p>
   * Example 1:
   * <p>
   * Input: nums = [-1,0,1,2,-1,-4]
   * Output: [[-1,-1,2],[-1,0,1]]
   * Explanation:
   * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
   * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
   * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
   * The distinct triplets are [-1,0,1] and [-1,-1,2].
   * Notice that the order of the output and the order of the triplets does not matter.
   */

  public static void main(String[] args) {
    System.out.println(threeSum(new int[] {-2, 0, 1, 1, 2}));
    System.out.println(threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
  }


  /**
   * Time Complexity: O(N2 * log(no. of unique triplets)), where N = size of the array.
   * Reason: Here, we are mainly using 3 nested loops. And inserting triplets into the set takes
   * O(log(no. of unique triplets)) time complexity. But we are not considering the time
   * complexity of sorting as we are just sorting 3 elements every time.
   * <p>
   * Space Complexity: O(2 * no. of the unique triplets) + O(N) as we are using a set data
   * structure and a list to store the triplets and extra O(N) for storing the array elements in
   * another set.
   *
   * @param nums
   *
   * @return
   */
  public static List<List<Integer>> threeSum(int[] nums) {
    HashSet<List<Integer>> hashset = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      HashSet<Integer> temp = new HashSet<>();
      for (int j = i + 1; j < nums.length; j++) {
        int target = -(nums[i] + nums[j]);
        if (temp.contains(target)) {
          hashset.add(
              new ArrayList<>(Arrays.asList(nums[i], nums[j], target)).stream().sorted().toList());
        } else {
          temp.add(nums[j]);
        }
      }
    }
    return new ArrayList<>(hashset);
  }

  public static List<List<Integer>> threeSumBetter(int[] nums) {
    Arrays.sort(nums);
    HashSet<List<Integer>> threeSumPairs = new HashSet<>();
    for (int i = 0; i < nums.length - 2; i++) {
      int j = i + 1;
      int k = nums.length - 1;
      int target = -nums[i];
      while (j < k) {
        if (nums[j] + nums[k] == target) {
          threeSumPairs.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
          j++;
          k--;
        } else if ((nums[j] + nums[k]) > target) {
          k--;
        } else {
          j++;
        }
      }
    }
    return new ArrayList<>(threeSumPairs);
  }

  /**
   * Time Complexity: O(NlogN)+O(N2), where N = size of the array.
   * Reason: The pointer i, is running for approximately N times. And both the pointers j and k
   * combined can run for approximately N times including the operation of skipping duplicates.
   * So the total time complexity will be O(N2).
   * <p>
   * Space Complexity: O(no. of quadruplets), This space is only used to store the answer. We are
   * not using any extra space to solve this problem. So, from that perspective, space complexity
   * can be written as O(1).
   *
   * @param arr
   *
   * @return
   */
  public List<List<Integer>> threeSumOptimized(int[] arr) {
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(arr);
    for (int i = 0; i < arr.length; i++) {
      //remove duplicates:
      if (i != 0 && arr[i] == arr[i - 1]) {
        continue;
      }
      //moving 2 pointers:
      int j = i + 1;
      int k = arr.length - 1;
      while (j < k) {
        int sum = arr[i] + arr[j] + arr[k];
        if (sum < 0) {
          j++;
        } else if (sum > 0) {
          k--;
        } else {
          List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
          ans.add(temp);
          j++;
          k--;
          //skip the duplicates:
          while (j < k && arr[j] == arr[j - 1]) {
            j++;
          }
          while (j < k && arr[k] == arr[k + 1]) {
            k--;
          }
        }
      }
    }
    return ans;
  }
}
