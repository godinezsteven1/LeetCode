class Solution {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); //min
        for(int i = 0; i < stones.length; i++) {
            maxHeap.add(stones[i]);
        }
        while (maxHeap.size() > 1) {
            int first = maxHeap.poll(); // largest 
            int second = maxHeap.poll(); // second 
            if (second > first) {
                maxHeap.add(second - first);
            } else {
                maxHeap.add(first - second);
            }
        }
        return maxHeap.poll();
    }
}