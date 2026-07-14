class Solution {
    public int[] twoSum(int[] nums, int target) {
        // create a hashmap to store number -> index
        Map<Integer, Integer> seen = new HashMap<>();

        // Loop through the array
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i]; // holds current index in nums
            int needed = target - current; // holds the diffrence of target - current

            // check if we have seen the needed number before
            if (seen.containsKey(needed)) { // checks "have I seen this number before?"
                return new int[] {seen.get(needed), i}; // "give me the index caule thats stored for the key needed"
            }

            // Add current number and its index to the map
            seen.put(current, i); // "store this number and its index in the hashmap"
        }

        // should never reach here based on problem constraints
        return new int[] {};
    }
}
