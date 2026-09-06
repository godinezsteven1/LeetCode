class Solution {
    public int maximumSwap(int num) {
        int max = -1;
        int max_i = -1; 
        int swap_i = -1;
        int swap_j = -1;
        char[] digits = Integer.toString(num).toCharArray();
        for (int i = digits.length - 1; i >= 0; i--) { // 1993
        // max 
            if (digits[i] > max) {
                max = digits[i];
                max_i = i;
            }
        // swap
            if (digits[i] < max) {
                swap_i = i;
                swap_j = max_i;
            }
        }
        if (swap_i != -1) {
            char temp = digits[swap_i];
            digits[swap_i] = digits[swap_j];
            digits[swap_j] = temp;
        }
        return Integer.parseInt(new String(digits));
    }
}