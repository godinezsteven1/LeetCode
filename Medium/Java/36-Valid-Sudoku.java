class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();
        for(int row = 0; row < 9; row++) {
            for(int col = 0; col < 9; col++) {
                char curr = board[row][col];
                if (curr != '.') {
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