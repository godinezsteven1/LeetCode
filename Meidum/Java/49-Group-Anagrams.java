class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        /**
        
        constraints;
            all lowercase english 
            only letters 

        naive:
            Input: strs = ["eat","tea","tan","ate","nat","bat"]
            Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
            for(string word: strs) {
                brute force combination of every possible comb of word
                does this combination exist in strs
                if yes make into new arraylist of string 
                no? just add it by itself 
            }

        optimal:  alphabetized , list of words that fall into this condition
        HashMap< String ,List<String>>

        eat tea taen ate nat bat 
        eat -> aet, if map does not contain aet put aet w new array list 
        tea -> aet this exist in map so we will map.get(aet).add(strs[i])
        return new ArrayList<>(map.values())
        */

        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            char[] word = strs[i].toCharArray();
            Arrays.sort(word);
            String sorted = new String(word);
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<String>());
            }
            map.get(sorted).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}