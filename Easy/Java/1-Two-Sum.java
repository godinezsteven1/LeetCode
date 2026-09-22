class Solution {
    public int[] twoSum(int[] nums, int target) {
        /**
        
        naive: brute force
        nums[i] + nums[j]= target?
            if yes ansewr 
        no continue 

        optimal: 
        complement = target - nums[i]

        hashmap -> <nums[i], index> 
        does complement exist in hash map && map.get(complement) != i 
        if no -> add it to hash map and contiue 

        Input: nums = [2,7,11,15], target = 9
        complement = 9 - 7 = 2 if complement exist inside 
        hashmap = 2=1, 2=1 
        */

        int complement = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[] {0,0};
    }
}