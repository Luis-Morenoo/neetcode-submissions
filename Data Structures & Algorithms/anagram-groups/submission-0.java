class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for (String word : strs) {
            // Sort the word's letters to get the key
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            // If this key doesnt exist yet, create an empty list for it
            if (!groups.containsKey(key)) {
                groups.put(key, new ArrayList<>());
            }

            // Add the original word to the keys list
            groups.get(key).add(word);
        }
        
        // Return all the groups (values) as a List
        return new ArrayList<>(groups.values());
    }
}
