class Solution {

    public List<String> wordsAbbreviation(List<String> words) {
        int[] prefixLengths = new int[words.size()];
        Arrays.fill(prefixLengths, 1);

        List<String> result = new ArrayList<>();
        boolean hasCollision = true;

        while (hasCollision) {
            hasCollision = false;
            result.clear();

            HashMap<String, List<Integer>> groups = new HashMap<>();
            for (int i = 0; i < words.size(); i++) {
                String abbreviation = abbreviate(words.get(i), prefixLengths[i]);
                result.add(abbreviation);
                if (!groups.containsKey(abbreviation)) {
                    groups.put(abbreviation, new ArrayList<>());
                }
                groups.get(abbreviation).add(i);
            }

            for (List<Integer> indices : groups.values()) {
                if (indices.size() > 1) {
                    hasCollision = true;
                    for (int idx : indices) {
                        prefixLengths[idx]++;
                    }
                }
            }

        }
        return result;

    }

    private String abbreviate(String word, int prefixLength) {
        int abbreviatedCount = word.length() - prefixLength - 1;
        if (abbreviatedCount <= 1) {
            return word;
        }

        return word.substring(0, prefixLength) + abbreviatedCount + word.charAt(word.length() - 1);
    }

}