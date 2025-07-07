package sdeSheet.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrintAllSubsets {

  public static void main(String[] args) {
    System.out.println(printAllTheSubsets(new int[] {2, 3}));
  }

  public static List<List<Integer>> printAllTheSubsets(int[] arr) {
    List<List<Integer>> listOfSubsets = new ArrayList<>();
    printAllSubsets(0, arr, new ArrayList<>(), listOfSubsets);
    return listOfSubsets;
  }

  /**
   * With mutation
   *
   * @param index
   * @param arr
   * @param subsets
   * @param listOfSubsets
   */
  public static void printAllSubsets(int index, int[] arr, List<Integer> subsets,
      List<List<Integer>> listOfSubsets) {
    if (index == arr.length) {
      listOfSubsets.add(new ArrayList<>(subsets));
      return;
    }

    subsets.add(arr[index]);
    printAllSubsets(index + 1, arr, subsets, listOfSubsets);
    subsets.remove(subsets.size() - 1);
    printAllSubsets(index + 1, arr, subsets, listOfSubsets);
  }

  /**
   * Time complexity: O(2^n)
   * Space complexity: O(2^n)
   *
   * @param index
   * @param arr
   * @param subsets
   * @param listOfSubsets
   */
  public static void printAllSubsetsWithoutMutation(int index, int[] arr, List<Integer> subsets,
      List<List<Integer>> listOfSubsets) {
    if (index == arr.length) {
      listOfSubsets.add(subsets);
      return;
    }

    printAllSubsets(index + 1, arr,
        Stream.concat(subsets.stream(), Stream.of(arr[index])).collect(Collectors.toList()),
        listOfSubsets);
    printAllSubsets(index + 1, arr, subsets, listOfSubsets);
  }
}
