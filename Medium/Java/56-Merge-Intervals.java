class Solution {

    /**
    constraints: 
        always positive numbers ? yes 
        empty int[][]? no 
        smallest and largest int i can expect 
        smallest and longest interval length? 
        will there always be a sol or is it possible no merge requiered 
        space and time complexity? 
        intervals[i].length = 2?
    naive: 

        Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
        Output: [[1,6],[8,10],[15,18]]

        will brute force each section  O(n^2)
        for i
            for j 
            intervals[i]
            interval[j]
            overlap? 

    optimal: 
       Input: intervals = [[4,7],[1,4]]
       sorted intervals = [[1,4],[1,7]]

       1_2_3_4___
            _4_5_6_7_______

          2,3,4,5
        
       Output: [[1,7]]

       curr first interval 
       for i = 1
          next = interval[i] 
          compare to curr 
          {update curr pointers if needed}  curr=. next answer.addthis interval 
          
          

       check ending time and comapre it to the next start (4 >= 1 -> overlap )

       Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]);
       List<int[]> answer = new ArrayList<>();
       int[] curr = intervals[0];
       for(int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];
            if (curr[1] >= next[0]) {
                curr[1] = Math.max(curr[1], next[0]);
            } else {
                answer.add(curr);
                curr = next; 
            }
       }
       answer.add(curr);
       answer.toArray(new int[answer.size()][]);
     */


    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0])); // n log n run 
        List<int[]> answer = new ArrayList<>(); // O (n)
        int[] curr = intervals[0];
        for(int i = 1; i < intervals.length; i++) { // O(n)
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