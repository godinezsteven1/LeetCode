class Solution {

    /**
    constraints: 
        smallest target and biggest target number
        nums.lenght < 2?
        largest nums.length
        smallest and largest value nums will have 

    naive: 

        Input: nums = [2,7,11,15], target = 9
        Input: nums = [2,7,11,15], target = 4 answer cannot be i,i or 0,0 
        Output: [0,1]

        O(n^2)
        for i
            for j
                does i + j add up to target? 
    optimal:

    2 + 7 = 9 
    9 - 2 = 7 - this 
    9 - 7 = 2 - this 


    Input: nums = [2,7,11,15], target = 9
    for i = 0 
    complement = 9 - 2 = 7 
    map.add(nums[0] = 2)

    for i = 1; 
    complement =. 9 - 7 = 2 
    map.containsKey(2) yes!


            // complement, index
    HashMap<Integer, Integer> map = new HashMap<>();
    for i 
        int complement = target - nums[i]
        if (map.containsKey(complement) map.get(complement) != 1) {
            return new int[] {map.get(complement), i}
        }
        map.add(nums[i])    

    return new int[] {0,0};
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        
        return new int[] {0,0};
    }
}