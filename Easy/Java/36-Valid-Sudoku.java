class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>(); 
        for(int row = 0; row < 9; row++) {
            for(int col = 0; col < 9; col++) {
                char num = board[row][col];
                if (num != '.') {
                    if (!seen.add(num + "row" + row)
                    || !seen.add(num + "col" + col)
                    || !seen.add(num + "box" + row / 3 + "-" + col / 3)) {
                        return false;
                    }
                }
                
            }
        }
        return true;
    }
}