class Solution {
    public int[][] merge(int[][] intervals) {
        /**
        constraints: 
            intervals[i].length == 2 
            positive int 
            out of order 
        naive: 
            Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
            Output: [[1,6],[8,10],[15,18]]
            brute force O(n^2) merge 
            we are checking for (ith interval with ith + 1 ... interval.length )
        optimal: 
            Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
            Output:            [[1,6],[8,10],[15,18]]

            Input: intervals = [1,4][4,7][5,8]
            Output: [[1,7]]
            curr = interval[0]
            for i = 1
            compare our current 
            curr[1] vs next[0]
                new interval curr[0] with max curr[1] with next[1] 

            Arrays.sort(intervals(a,b) -> Integer.compare(a[0],b[0]));
        
        */
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0])); //. O(n log n) 
        int[] curr = intervals[0];
        List<int[]> answer = new ArrayList<>(); // O(n) space 
        for(int i = 1; i < intervals.length; i++) { // time O(n)
            int[] next = intervals[i];
            if (curr[1] >= next[0]) {
                curr[1] = Math.max(curr[1], next[1]);
            } else {
                answer.add(curr);
                curr = next;
            }
        }
        answer.add(curr);
        return answer.toArray(new int[answer.size()][]);
    }
}