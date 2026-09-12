class Solution {
    public int maximumSwap(int num) {
        // base cases : no positive nuber, 
        // constraints

        // naive / non optimal O(n)    O(n)     
        /**
        9999
        max = 
        max i = 
        replaceIndex = 
        swapWithIndex = max_i 

        if (num[i] < max)
        if (num[i] > max) 
        */
        int max = -1;
        int max_i = -1;
        int replaceIndex = -1;
        int swapWithIndex = -1;
        char[] digits = Integer.toString(num).toCharArray();

        for(int i = digits.length - 1; i >=0; i--) {
            if (digits[i] > max) {
                max = digits[i];
                max_i = i;
            }
            if (digits[i] < max) {
                replaceIndex = i;
                swapWithIndex = max_i;
            }
        }
        if (replaceIndex != -1) {
            char temp = digits[replaceIndex];
            digits[replaceIndex] = digits[swapWithIndex];
            digits[swapWithIndex] = temp;
        }
        return Integer.parseInt(new String(digits));
    }
}