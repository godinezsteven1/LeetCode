class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>(); 

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int oldIdx = map.get(nums[i]);
                map.replace(nums[i], i);
                if (i - oldIdx <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false; 
    }
}
