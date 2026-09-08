class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        HashMap<String, List<String>> map = new HashMap<>();
        for (String word: wordList) {
            for (int i = 0; i < word.length(); i++) {
                char[] charWord = word.toCharArray(); // ['h','e','l','l','o']
                charWord[i] = '_';
                String pattern = new String(charWord);
                if (!map.containsKey(pattern)) {
                    map.put(pattern, new ArrayList<>());
                }
                map.get(pattern).add(word);
            }
        }
        return bfs(beginWord, endWord, map);
    }


    private int bfs(String beginWord, String endWord, HashMap<String, List<String>> map) {
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        visited.add(beginWord);
        q.add(beginWord);
        int answer = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String word = q.poll();
                if (word.equals(endWord)) {
                    return answer;
                }
                // neighbors
                for (int j = 0; j < word.length(); j++) {
                    char[] charWord = word.toCharArray(); // ['h','e','l','l','o']
                    charWord[j] = '_';
                    String pattern = new String(charWord);
                    for(String neighborWord: map.getOrDefault(pattern, new ArrayList<>())) {
                        if (!visited.contains(neighborWord)) {
                            visited.add(neighborWord);
                            q.add(neighborWord);
                        }
                    }
                }
            }
            answer++;
        }
        return 0;
    }
}