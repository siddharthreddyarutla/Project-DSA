package neetCode_150.strings;

import java.util.ArrayList;
import java.util.List;

public class encodeDecode {

  /**
   * Input: dummy_input = ["Hello","World"]
   * <p>
   * Output: ["Hello","World"]
   * <p>
   * Explanation:
   * Machine 1:
   * Codec encoder = new Codec();
   * String msg = encoder.encode(strs);
   * Machine 1 ---msg---> Machine 2
   * <p>
   * Machine 2:
   * Codec decoder = new Codec();
   * String[] strs = decoder.decode(msg);
   */


  public String encode(List<String> strs) {
    StringBuilder builder = new StringBuilder();
    for (String string : strs) {
      builder.append(string);
      builder.append("`");
    }
    return builder.toString();
  }

  public List<String> decode(String str) {
    List<String> ans = new ArrayList<>();
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) != '`') {
        builder.append(str.charAt(i));
      } else {
        ans.add(builder.toString());
        builder = new StringBuilder();
      }
    }
    Integer[] arr = new Integer[ans.size()];
    arr = ans.toArray(arr);
    return ans;
  }

}
