package neetCode_150.arrays;

public class MaximumProductSubarray_152 {

  public static void main(String[] args) {
    System.out.println(maxProduct(new int[] {-2, 3, -4}));
    System.out.println(maxProduct(new int[] {2, 3, -2, 4}));
  }

  /**
   * 🔥 This is **the right question**.
   * If you understand *why the swap happens*, you don’t just “know the solution” — you **own** it.
   *
   * Let’s slow this down and build the idea from first principles.
   *
   * ---
   *
   * # 🧠 Core Truth (the entire problem in one sentence)
   *
   * > **A negative number reverses ordering.**
   *
   * That’s it. Everything comes from this.
   *
   * ---
   *
   * ## 1️⃣ What are we *really* tracking?
   *
   * At index `i`, we want:
   *
   * * `maxEndingHere` → **largest product of a subarray that MUST end at i**
   * * `minEndingHere` → **smallest (most negative) product of a subarray that MUST end at i**
   *
   * Why both?
   *
   * Because the future depends on **signs**, not just size.
   *
   * ---
   *
   * ## 2️⃣ Why tracking only max FAILS
   *
   * Example:
   *
   * ```
   * [-2, 3, -4]
   * ```
   *
   * If you only track max:
   *
   * * At `-2` → max = -2
   * * At `3`  → max = 3
   * * At `-4` → max = -4 ❌ (wrong)
   *
   * But correct answer = **24**
   *
   * 👉 The missing piece was **-6**, which later became **24**.
   *
   * So we must remember:
   *
   * > “What’s the worst product so far? It might become the best later.”
   *
   * ---
   *
   * ## 3️⃣ What does a negative number actually do?
   *
   * Let’s take two numbers:
   *
   * ```
   * maxEnding = 10
   * minEnding = -5
   * ```
   *
   * Now multiply by:
   *
   * ```
   * curr = -2
   * ```
   *
   * What happens?
   *
   * * `10 * -2 = -20`
   * * `-5 * -2 = 10`
   *
   * 📌 **The biggest becomes smallest**
   * 📌 **The smallest becomes biggest**
   *
   * That’s the key insight.
   *
   * ---
   *
   * ## 4️⃣ Why SWAP before multiplying?
   *
   * Because when `curr < 0`, multiplication **reverses order**.
   *
   * Before multiplication:
   *
   * ```
   * maxEnding > minEnding
   * ```
   *
   * After multiplying by negative:
   *
   * ```
   * maxEnding * curr < minEnding * curr
   * ```
   *
   * So if we don’t swap, we assign wrong values.
   *
   * ---
   *
   * ## 5️⃣ Visual intuition (very important)
   *
   * Think of number line:
   *
   * ```
   * minEnding -------- 0 -------- maxEnding
   * ```
   *
   * Multiply everything by `-1`:
   *
   * ```
   * maxEnding -------- 0 -------- minEnding
   * ```
   *
   * The line **flips**.
   *
   * 👉 Swapping simulates that flip.
   *
   * ---
   *
   * ## 6️⃣ Step-by-step example (real understanding)
   *
   * ### Example: `[-2, 3, -4]`
   *
   * #### Step 1: -2
   *
   * ```
   * max = -2
   * min = -2
   * ```
   *
   * ---
   *
   * #### Step 2: 3 (positive → no flip)
   *
   * ```
   * max = max(3, -2 * 3) = 3
   * min = min(3, -2 * 3) = -6
   * ```
   *
   * ---
   *
   * #### Step 3: -4 (negative → FLIP!)
   *
   * Before multiplying:
   *
   * ```
   * max = 3
   * min = -6
   * ```
   *
   * Swap:
   *
   * ```
   * max = -6
   * min = 3
   * ```
   *
   * Now multiply:
   *
   * ```
   * max = max(-4, -6 * -4) = 24
   * min = min(-4, 3 * -4) = -12
   * ```
   *
   * 🔥 This is where the magic happens.
   *
   * ---
   *
   * ## 7️⃣ Why swapping AFTER multiplication is wrong
   *
   * If you don’t swap first:
   *
   * ```
   * max = max(-4, 3 * -4) = -4
   * min = min(-4, -6 * -4) = -24
   * ```
   *
   * ❌ You lost the correct path.
   *
   * ---
   *
   * ## 8️⃣ Mental Model (REMEMBER THIS FOREVER)
   *
   * > **Positive number → order preserved**
   * > **Negative number → order reversed**
   *
   * So:
   *
   * * `curr > 0` → normal update
   * * `curr < 0` → swap first
   *
   * ---
   *
   * ## 9️⃣ Why zero doesn’t need special logic
   *
   * If `curr == 0`:
   *
   * ```
   * max = 0
   * min = 0
   * ```
   *
   * Which automatically resets the subarray.
   *
   * ---
   *
   * ## 🔑 Interview-Ready Explanation (say this)
   *
   * > We track both maximum and minimum products because a negative number can turn a minimum into a maximum.
   * > When the current number is negative, multiplication reverses order, so we swap max and min before updating.
   * > This ensures we always compute the correct product ending at each index.
   *
   * ---
   *
   * ## 🚦 Interview Signal
   *
   * If you explain it **this way**, interviewer thinks:
   *
   * > “This person understands sign behavior, not just memorized code.”
   *
   * ---
   *
   * If you want next:
   *
   * * 🔥 Draw this on a whiteboard interview-style
   * * 🔥 Compare with Kadane’s Algorithm
   * * 🔥 Variants: circular array, max product k elements
   *
   * Say the word 👊
   * @param nums
   * @return
   */
  public static int maxProduct(int[] nums) {
    int maxEnding = nums[0];
    int minEnding = nums[0];
    int result = nums[0];

    for (int i = 1; i < nums.length; i++) {
      int curr = nums[i];

      // If current number is negative, swap
      if (curr < 0) {
        int temp = maxEnding;
        maxEnding = minEnding;
        minEnding = temp;
      }

      maxEnding = Math.max(curr, maxEnding * curr);
      minEnding = Math.min(curr, minEnding * curr);

      result = Math.max(result, maxEnding);
    }

    return result;
  }

}
