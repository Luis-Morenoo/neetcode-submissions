class Solution {
    public boolean hasDuplicate(int[] nums) {
        // create a hashset to store numbers we have seen
        Set<Integer> seen = new HashSet<>();

        // Loop through each number
        for (int num: nums) {
            // if num is already in the set, return true
            if (seen.contains(num)){
                return true;
            }
            // otherwise, add num to the set
            seen.add(num);
        }   
        // if we made it here, no duplicate found
        return false;
    }
}