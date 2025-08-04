package sdeSheet.heaps;

import java.security.Key;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class TopKFrequentWords_692 {

  // https://leetcode.com/problems/top-k-frequent-words/

  /**
   * Given an array of strings words and an integer k, return the k most frequent strings.
   * <p>
   * Return the answer sorted by the frequency from highest to lowest. Sort the words with the
   * same frequency by their lexicographical order.
   * <p>
   * Example 1:
   * <p>
   * Input: words = ["i","love","leetcode","i","love","coding"], k = 2
   * Output: ["i","love"]
   * Explanation: "i" and "love" are the two most frequent words.
   * Note that "i" comes before "love" due to a lower alphabetical order.
   * Example 2:
   * <p>
   * Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
   * Output: ["the","is","sunny","day"]
   * Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the
   * number of occurrence being 4, 3, 2 and 1 respectively.
   */

  public static void main(String[] args) {
    System.out.println(
        topKFrequent(new String[] {"i", "love", "leetcode", "i", "love", "coding"}, 2));
    System.out.println(topKFrequent(
        new String[] {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
    System.out.println("------------------------------------------------------");
    System.out.println(
        topKFrequentUsingHeap(new String[] {"i", "love", "leetcode", "i", "love", "coding"}, 2));
    System.out.println(topKFrequentUsingHeap(
        new String[] {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
  }

  public static List<String> topKFrequent(String[] words, int k) {
    Map<String, Integer> map = new HashMap<>(words.length);
    for (String word : words) {
      if (map.containsKey(word)) {
        map.put(word, map.get(word) + 1);
      } else {
        map.put(word, 1);
      }
    }
    List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
    List<String> result = new ArrayList<>();
    Collections.sort(list, (a, b) -> {
      if (!a.getValue().equals(b.getValue())) {
        return b.getValue() - a.getValue();
      } else {
        return a.getKey().compareTo(b.getKey());
      }
    });
    for (int i = 0; i < k; i++) {
      result.add(list.get(i).getKey());
    }
    return result;
  }

  /**
   * Time complexity: O(n log k)
   * Space complexity: O(n)
   *
   * @param words
   * @param k
   *
   * @return
   */
  private static List<String> topKFrequentUsingHeap(String[] words, int k) {
    Map<String, Integer> map = new HashMap<>();
    // Map with string and count of frequency
    for (String word : words) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }
    // Create a min heap with custom comparator for lexicographical order
    PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>((a, b) -> {
      if (!a.getValue().equals(b.getValue())) {
        return b.getValue() - a.getValue();
      } else {
        return a.getKey().compareTo(b.getKey());
      }
    });
    // Add all the keys to the min heap
    minHeap.addAll(map.entrySet());
    List<String> result = new ArrayList<>();
    while (k > 0 && !minHeap.isEmpty()) {
      result.add(minHeap.poll().getKey());
      k--;
    }
    return result;
  }
}
