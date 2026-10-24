class Solution {
    /**
    constraints
        empty array? no 
        smallest array we can expect? 
        largest array we can expect?
        smallest stone weight 
        largest stone weight 
        we wont encounter negative values 
    naive: 
        Input: stones = [2,7,4,1,8,1]
        Output: 1

        do until one stone left 
        get rand [2,7,4,1,8,1] 
        fromArray.remove(rand)
        subtract it with anohter rand 
            x === y both destroyed otherwise add back to array 

        [2,7,4,1,8,1] 
        [2,6,4,8,1]
        [2,6,4,7]
        [4,4,8,1]
        [8,1]
        [7]
    optimal: 

        Input: stones = [2,7,4,1,8,1]
        Output: 1

        sum = 23 
            /.   \ 
           12    11    if these two groups = 1
         8 + 4.| 2 + 7 + 1 + 1     
        creating groups of sum / 2 and hit those groups 

        we only need to keep track of half 

        only focus on one subgroup 12 

        8 + 4 = 4 not optimal sol
         
        mult by 2 and then subtrack it from sum 
        sum / 2 
        dp[target]


        int sum = Arrays.stream(stones).sum(); 
        int target = sum / 2;
        int[] dp = new int[target + 1];

        for(int stone: stones) {
            for(int i = target; i >= stone; i--) {
                dp[i] = Math.max(dp[i], dp[i - stone] + stone);
            }
        }

        return sum - 2 * dp[target];

     */
    
    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int target = sum / 2;
        int[] dp = new int[target + 1];

        for(int stone: stones) {
            for(int i = target; i >= stone; i--) {
                dp[i] = Math.max(dp[i], dp[i - stone] + stone);
            }
        }

        return sum - 2 * dp[target];
    }
}