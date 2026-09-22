class Solution {
    public int[][] merge(int[][] intervals) {
        /**

        constraints: 
            intervals[i].length = 2;
            postive integers 
            can be out of order 

        naive: 
            brute force: O (n^2)
                if curr range is within range of next? (do something) ok now try taht one next 
                for i 
                    for j
        optimal: 

            Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
            Output: [[]]


            sort O(n log n) (sort by start time)
            curr = intervals[0]
            List<int[]> answer = new ArrayList<>();
            for loop here starts i = 1;
            next = intervals[i]
            curr[1] >= next[1] conflict
                curr[1] = Math.max(curr[1], next[1])
            else {
                answer.add(curr);
                curr = next;
            }
            return answer.toArray(new int[answer.size()][]);
        */
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0])); // O(n log n) running time 
        int[] curr = intervals[0];// O(1)
        List<int[]> answer = new ArrayList<>(); // O(n) space complexity 
        for(int i = 1; i < intervals.length; i++) { // O(n)
            int[] next = intervals[i];
            if (curr[1] >= next[0]) {
                // conflict 
                curr[1] = Math.max(curr[1], next[1]);
            } else {
                // no conflict , no merging 
                answer.add(curr);
                curr = next;
            }
        }
        answer.add(curr);
        return answer.toArray(new int[answer.size()][]);
    }
}