class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        /**
        constraints: lowercase letters 

        naive: 
            strs = ["eat","tea","tan","ate","nat","bat"]

            for i 
                eat get length = 3; brute force all possible combinations and if we see that combination in strs  
                append that to answer; 


        optimal: 
            strs = ["eat","tea","tan","ate","nat","bat"]
                    alphabetical version, [list of the words that satisfy]
            hashmap <char/string, arrayList<String>();
            for i 

            "eat" -> "aet"
            if hashmap has aet 
                append the word eat to map.get(aet)
            map.put(aet, new ArrayList)
            
        
        */

        HashMap<String, List<String>> map = new HashMap<>(); // space complexity O(V * K)
        for (int i = 0; i < strs.length; i++) { // run time O(n)
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray); // run time of java arrays sort first 
            String sorted = new String(charArray);
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<String>());
            }
            map.get(sorted).add(strs[i]);
        }

        return new ArrayList<>(map.values());

    }
        

    
}