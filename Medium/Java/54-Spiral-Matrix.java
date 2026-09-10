class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowStart = 0;
        int colStart = 0;
        int rowEnd = matrix.length - 1;
        int colEnd = matrix[0].length - 1;
        ArrayList<Integer> answer = new ArrayList<>();

        while (rowStart <= rowEnd && colStart <= colEnd) {
            // moving right is [i][j + 1]
            for (int j = colStart; j <= colEnd; j++) {
                answer.add(matrix[rowStart][j]);
            }
            rowStart++;
            // moving down is [i + 1][j]
            for (int j = rowStart; j <= rowEnd; j++) {
                answer.add(matrix[j][colEnd]);
            }
            colEnd--;
            // moving left is [i][j - 1]
            if (rowStart <= rowEnd) {
                for (int j = colEnd; j >= colStart; j--) {
                    answer.add(matrix[rowEnd][j]);
                }
                rowEnd--;
            }

            // moving up is [i - 1][j]
            if (colStart <= colEnd) {
                for (int j = rowEnd; j >= rowStart; j--) {
                    answer.add(matrix[j][colStart]);
                }
                colStart++;
            }
        }
        return answer;

    }
}