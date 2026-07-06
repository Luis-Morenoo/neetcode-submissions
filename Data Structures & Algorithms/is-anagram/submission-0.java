class Solution {
    public boolean isAnagram(String s, String t) {
        // edge case: if lenghts are diffrent, cant be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // convert both strings to char arrays and sort them
        char[] s_chars = s.toCharArray() ;
        char[] t_chars = t.toCharArray() ;

        Arrays.sort(s_chars);
        Arrays.sort(t_chars);

        // compare the sorted arrays
        return Arrays.equals(s_chars, t_chars);

    }
}
