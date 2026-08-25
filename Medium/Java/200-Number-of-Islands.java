import java.util.Queue;
import java.util.LinkedList;

class Solution {

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int numIslands(char[][] grid) {
        // horizontal vertical connections are islands. 
        int islandCounter = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
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
        q.add(new Pair(row, col));
        grid[row][col] = '0';

        while (!q.isEmpty()) {
            Pair cell = q.remove();
            int x = cell.x;
            int y = cell.y;
            checkNeighbors(grid, q, x, y);
        }
    }


    private void checkNeighbors(char[][] grid, Queue<Pair> q, int x, int y) {
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