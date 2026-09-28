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
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    islandCounter++;
                    bfs(grid, row, col);
                }
            }
        }

        return islandCounter;
    }

    private void bfs(char[][] grid, int row, int col) {
        Queue<Pair> q = new LinkedList<>();
        grid[row][col] = '0';
        q.add(new Pair(row, col));

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
        if (x + 1 < grid.length && grid[x + 1][y] == '1') {
            grid[x + 1][y] = '0';
            q.add(new Pair(x + 1, y));
        }
        if (y - 1 >= 0 && grid[x][y - 1] == '1') {
            grid[x][y - 1] = '0';
            q.add(new Pair(x, y - 1));
        }
        if (y + 1 < grid[0].length && grid[x][y + 1] == '1') {
            grid[x][y + 1] = '0';
            q.add(new Pair(x, y + 1));
        }
    }
}