import java.util.Queue;
import java.util.LinkedList;

class Solution {

    private class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int orangesRotting(int[][] grid) {
        int counter = 0;
        int fresh = 0;

        Queue<Pair> q = new LinkedList<>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 2) {
                    q.add(new Pair(row, col));
                }
                if (grid[row][col] == 1) {
                    fresh++;
                }
            }
        }
        return bfs(grid, q, counter, fresh);

    }

    private int bfs(int[][] grid, Queue<Pair> q, int counter, int fresh) {
        while (!q.isEmpty() && fresh > 0) {
            int minuteLevel = q.size();
            for (int i = 0; i < minuteLevel; i++) {
                Pair cell = q.remove();
                int x = cell.x;
                int y = cell.y;
                fresh = checkNeighbors(grid, q, x, y, fresh);
            }
            counter++;
        }
        if (fresh > 0) {
            return -1;
        } else {
            return counter;
        }
    }

    private int checkNeighbors(int[][] grid, Queue<Pair> q, int x, int y, int fresh) {
        if (x - 1 >= 0 && grid[x - 1][y] == 1) {
            q.add(new Pair(x - 1, y));
            grid[x - 1][y] = 2;
            fresh--;
        }
        if (x + 1 < grid.length && grid[x + 1][y] == 1) {
            q.add(new Pair(x + 1, y));
            grid[x + 1][y] = 2;
            fresh--;
        }
        if (y - 1 >= 0 && grid[x][y - 1] == 1) {
            q.add(new Pair(x, y - 1));
            grid[x][y - 1] = 2;
            fresh--;
        }
        if (y + 1 < grid[0].length && grid[x][y + 1] == 1) {
            q.add(new Pair(x, y + 1));
            grid[x][y + 1] = 2;
            fresh--;
        }
        return fresh;
    }
    
}