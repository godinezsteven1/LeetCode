class Solution {
    public int maximumSwap(int num) {
        int max = -1;
        int max_i = -1;
        int swapIndex = -1;
        int swapWithIndex = -1; 
        char[] digits = Integer.toString(num).toCharArray();

        for(int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] > max) {
                max = digits[i];
                max_i = i;
            }
            if (digits[i] < max) {
                swapIndex = i;
                swapWithIndex = max_i;
            }
        }
        if (swapIndex != -1) {
            char temp = digits[swapIndex];
            digits[swapIndex] = digits[swapWithIndex];
            digits[swapWithIndex] = temp;
        }

        return Integer.parseInt(new String(digits));        
    }
}