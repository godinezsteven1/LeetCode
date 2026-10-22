class Solution {
    public boolean isValidSudoku(char[][] board) {

        /** 
        constraints: 
            always going to have integer 1-9 ex) numbers > 9, negatives, other things 
            expect: 1-9, and '.'
            if it is a valid sudoko (so far) -> right 
            can we always expect a 9x9? or can there be nxn 

        naive:
            brute force 
                for 
                    for 
                        we see a 5
                             now look the entire row for another 5 
                             now look the entire col for another 5
                             calculate position of box location and look 3x3 around it 
        
        optimal solution 

        hashSet<String> seen = new HashSet<>(); 

        for row 
            for col 
            char curr = board[row][col] 
            if (curr != '.') {
                if (!seen.add(curr + "row" + row)
                || !seen.add(curr + "col" + col)
                || !seen.add(curr + "box" + row / 3 + "-" + col / 3)) {
                    return false; 

                }
            }

        
        row / 3 col / 3 
        
          0 1 2 3 4 5 6 7 8 
        0
        1
        2
        3
        4
        5
        6
        7
        8                   x. 

        
        
        
        
        
         */
        
        HashSet<String> seen = new HashSet<>(); // space: O(E) = O(<181) 
        for(int row = 0; row < 9; row++) {
            for(int col = 0; col < 9; col++) { // Run O(n^2) size O(9 x 9) O (181) = O(1) ... n x n = O(n)
                char curr = board[row][col];
                if (curr != '.') { // run same as map: O(1) 
                    if (!seen.add(curr + "row" + row)
                    || !seen.add(curr + "col" + col)
                    || !seen.add(curr + "box" + row / 3 + "-" + col / 3)) {
                        return false; 
                }
                }
            }
        }

        return true; 
    }
}