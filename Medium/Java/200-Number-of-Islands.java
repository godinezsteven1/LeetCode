class Solution {

    private class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int numIslands(char[][] grid) {
        int islandCounter = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    islandCounter++;
                    bfs(row, col, grid);
                }
            }
        }
        return islandCounter;
    }

    private void bfs(int row, int col, char[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        grid[row][col] = '0';

        while (!q.isEmpty()) {
            Pair cell = q.poll();
            checkNeighbors(cell.x, cell.y, q, grid);
        }

    }

    private void checkNeighbors(int x, int y, Queue<Pair> q, char[][] grid) {
        if (x - 1 >= 0 && grid[x - 1][y] == '1') {
            grid[x - 1][y] = '0';
            q.add(new Pair(x - 1, y));
        }
        if (x + 1 <= grid.length - 1 && grid[x + 1][y] == '1') {
            grid[x + 1][y] = '0';
            q.add(new Pair(x + 1, y));
        }
        if (y - 1 >= 0 && grid[x][y - 1] == '1') {
            grid[x][y - 1] = '0';
            q.add(new Pair(x, y - 1));
        }
        if (y + 1 <= grid[0].length - 1 && grid[x][y + 1] == '1') {
            grid[x][y + 1] = '0';
            q.add(new Pair(x, y + 1));
        }
    }
}