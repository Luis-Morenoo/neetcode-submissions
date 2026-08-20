class Solution {

    public String encode(List<String> strs) {
        // For each word in the list:
        //  Append: (length of word) + "#" + (the word itself)
        // Return the concatenated result

        StringBuilder sb = new StringBuilder();
        for (String word: strs) {
            sb.append(word.length()); 
            sb.append("#"); 
            sb.append(word); 
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        // i = 0
        // While i < length of encoded string:
        //    1. Read characters starting at i until you hit "#" — that's the length number
        //    2. Convert that length substring to an integer
        //    3. Move past the "#" 
        //    4. Read exactly (length) characters — that's the word
        //    5. Add the word to result list
        //    6. Move i forward past this word, repeat
        // Return result list

        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {  
            int j = i; 
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i,j));
            i = j + 1;
            String word = str.substring(i,i + length);
            result.add(word);
            i = i + length;
        }
        return result;
    }
}
