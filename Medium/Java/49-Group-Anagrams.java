class Solution {

    /**

    Input: strs = ["eat","tea","tan","ate","nat","bat"]

    Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

    constraints: 
        emtpy strs? 
        smallest and largest strs.length 
        smallest and largest strs[0].length 
        smallest and largest char word? 
        will strs always be english lower case alphabetical char and words 

    naive: 
        Input: strs = ["eat","tea","tan","ate","nat","bat"]
        Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

        ultra brute froce 
        for i 
            for j 
                find all combinations for word i, then check it against j  3_C_2
    optimal: 

        Input: ["eat","tea","tan","ate","nat","bat"]

        Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

        eat -> tea, ate 

        order it alphabetically 

        if we order everything 
        ["aet","aet","ant","aet","ant","abt"]
                sorted      list 
        hash map <String, ArrayList<String>>

        HashMap<String, ArrayList<<String>> map = new HashMap<>();
        for(int i = 0; i < strs.lenght; i++) {
            char[] word = strs[i].toCharArray();
            Arrays.sort(word);
            String sorted = new String(word);
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(strs[i]);
        }

    */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            char[] word = strs[i].toCharArray();
            Arrays.sort(word);
            String sorted = new String(word);
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(strs[i]);
        }

        return new ArrayList<>(map.values());       
    }
}