class Solution {
    public int lastStoneWeightII(int[] stones) {

        /**
        constraints: 
            int[] size?  1 to 30
            stone weight 1 to 100 
            int[] positive integer? 
            choose at "random" two stones to smash? 
            if x = y destroyed and if x != y we only track the biggest one w new weight of subtractingh them 


        naive: 
            brute force; 
                all possible combinatiosn of stone smashing and return optimal value. DP approach O(n^2)

        optimal 
            sum =  23 
                  / \ 
                 12 11 = 1 
                 8,4   2,7,1,1

                      3.  = 1
            int target = sum / 2
            int[] dp = new int[target  + 1]
            dp[i] = Math.max(dp[i], dp[i - stone] + stone);

            for(stone: stones) {
                for(int i = target; i >= stone; i--) {
                    dp[i] = Math.max(dp[i], dp[i - stone] + stone);
                }
            }
            return sum - 2 * dp[target];
            Input: stones = [2,7,4,1,8,1]
            Output: 1
            choose 7 4 
            [2,3,1,8,1]
            chose 2 3 
            [1,1,8,1]
            not optimal because 8 big 
        */
        int sum = Arrays.stream(stones).sum();
        int target = sum / 2;
        int[] dp = new int[target + 1]; // space O(n/2) = O(n)
        for(int stone: stones) { // O(n) time 
            for(int i = target; i >= stone; i--) { // O(n / 2 - 100^*) = O(n/2 - 1) = O(n)
                dp[i] = Math.max(dp[i], dp[i - stone] + stone);
            }
        }

        return sum - 2 * dp[target];

    }
}