package sdeSheet.greedyAlgorithm;

import utils.GenericUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class nMeetingsInOneRoom {

  // https://takeuforward.org/data-structure/n-meetings-in-one-room/

  /**
   * You are given timings of n meetings in the form of (start[i], end[i]) where start[i] is the
   * start time of meeting i and end[i] is the finish time of meeting i. Return the maximum
   * number of meetings that can be accommodated in a single meeting room, when only one meeting
   * can be held in the meeting room at a particular time.
   * <p>
   * Note: The start time of one chosen meeting can't be equal to the end time of the other
   * chosen meeting.
   * <p>
   * Examples :
   * <p>
   * Input: start[] = [1, 3, 0, 5, 8, 5], end[] =  [2, 4, 6, 7, 9, 9]
   * Output: 4
   * Explanation: Maximum four meetings can be held with given start and end timings. The
   * meetings are - (1, 2), (3, 4), (5,7) and (8,9)
   * Input: start[] = [10, 12, 20], end[] = [20, 25, 30]
   * Output: 1
   * Explanation: Only one meetings can be held with given start and end timings.
   * Input: start[] = [1, 2], end[] = [100, 99]
   * Output: 1
   */

  public static void main(String[] args) {
    System.out.println(maxMeetings(new int[] {1, 3, 0, 5, 8, 5}, new int[] {2, 4, 6, 7, 9, 9}));
  }

  /**
   * Time Complexity: O(n) to iterate through every position and insert them in a data structure.
   * O(n log n)  to sort the data structure in ascending order of end time. O(n)  to iterate
   * through the positions and check which meeting can be performed.
   * <p>
   * Overall : O(n) +O(n log n) + O(n) ~O(n log n)
   * <p>
   * Space Complexity: O(n)  since we used an additional data structure for storing the start
   * time, end time, and meeting no.
   *
   * @param start
   * @param end
   *
   * @return
   */
  public static int maxMeetings(int start[], int end[]) {
    List<GenericUtils.Pair<Integer, Integer>> pairList = new ArrayList<>();
    for (int i = 0; i < start.length; i++) {
      GenericUtils.Pair<Integer, Integer> pair = new GenericUtils.Pair<>(start[i], end[i]);
      pairList.add(pair);
    }
    pairList.sort(Comparator.comparingInt(a -> a.second));
    int nMeetings = 1;
    int mEnd = pairList.get(0).second;
    for (int i = 1; i < pairList.size(); i++) {
      if (pairList.get(i).first > mEnd) {
        nMeetings++;
        mEnd = pairList.get(i).second;
      }
    }
    return nMeetings;
  }
}
