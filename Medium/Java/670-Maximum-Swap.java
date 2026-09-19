class Solution {
    public int maximumSwap(int num) {
        int max = -1;
        int max_i = -1;
        int swapValue = -1;
        int swapWithValue = -1;
        char[] digits = Integer.toString(num).toCharArray();

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] > max) {
                max = digits[i];
                max_i = i;
            } 
            if (digits[i] < max) {
                swapValue = i;
                swapWithValue = max_i;
            }
        }

        if (swapValue != -1) {
            char temp = digits[swapValue];
            digits[swapValue] = digits[swapWithValue];
            digits[swapWithValue] = temp;
        }

        return Integer.parseInt(new String(digits));
    }
}