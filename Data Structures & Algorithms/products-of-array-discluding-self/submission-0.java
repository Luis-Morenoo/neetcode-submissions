/*
         Steps:
         1. Brute force would be O(n^2) — for each index, loop through the whole array again
            excluding that index. Too slow for n up to 100,000.
         2. Better idea: split each answer into "everything to the left" times "everything to the right."
         3. Build left[] in one pass, left to right:
              left[0] = 1 (nothing to the left of index 0)
              left[i] = left[i-1] * nums[i-1]
         4. Build right[] in one pass, right to left:
              right[n-1] = 1 (nothing to the right of the last index)
              right[i] = right[i+1] * nums[i+1]
         5. Combine: output[i] = left[i] * right[i]
         This gives O(n) time overall (three linear passes), no division needed.
*/
class Solution {
    public int[] productExceptSelf(int[] nums) {
      int n = nums.length;
      int[] left = new int[n];
      int[] right = new int[n];
      int[] output = new int[n];

      // Build left[] : left[i] = product of everything left of i
      left[0] = 1;
      for (int i = 1; i < n; i++) {
        left[i] = left[i-1] * nums[i-1];
      }

      // Build right[] : right[i] = product of everything right of i
      right[n-1] = 1;
      for (int i = n -2; i >= 0; i--) {
        right[i] = right[i+1] * nums[i+1];
      }

      // Combine
      for (int i = 0; i < n; i++) {
        output[i] = left[i] * right[i];
      }
      return output;
    }
}  
