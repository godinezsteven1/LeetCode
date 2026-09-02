class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1; 
        int right = 0;
        for (int pile: piles) {
            right = Math.max(pile,right);
        }
        int k = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            long hours = 0;
            for (int pile: piles) {
                hours += pile / mid;
                if (pile % mid != 0) {
                    hours++;
                }
            }

            if (h < hours) {
                left = mid + 1;

            } else {
                right = mid - 1;
                k = mid;
            }
        }
        
        return k;
    }
}