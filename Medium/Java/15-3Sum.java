class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        for (int a = 0; a < nums.length; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) { // dupes
                continue;
            }
            int b = a + 1; // right of a 
            int c = nums.length - 1;  // end of array 
            while (b < c) { 
                int sum = nums[a] + nums[b] + nums[c];
                if (sum == 0) {
                    answer.add(Arrays.asList(nums[a], nums[b], nums[c]));
                    b++;
                    c--; 
                    // dupes pt 2 
                    while (b < c && nums[b] == nums[b - 1]) {
                        b++;
                    }
                } else
                if (sum > 0) { 
                c--; 
                } else
                if (sum < 0) {
                    b++;
                }
            }
        }
        return answer;
    }
}