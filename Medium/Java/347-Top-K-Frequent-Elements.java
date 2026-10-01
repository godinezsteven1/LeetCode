class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];

        for(int key: map.keySet()) {
            int freq = map.get(key);

            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }

        List<Integer> answer = new ArrayList<>();
        for(int i = buckets.length - 1; answer.size() < k; i--) {
            if (buckets[i] != null) {
                answer.addAll(buckets[i]);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}