class Solution {

    /**
    
    constraints: 
        anything out of bounds treat it as water. 
        connections: horizontally and vertically 
        biggest island we can get ( biggest m x n)
        what is smallest we can get; 
        grid ever have anythign that is not land or water? 
        will it ever not have any land? 
        longest length we can expect? 
        least amount of rows to expext 
    
    niave: 
        for row 
            for col 
                if we see 1 incremenet counter 
    
    
    optimal: BFS and every time it sees a 1 we count then turn adjecency -> 0 
        for row 
            for col 
                every 1 we see we are going to run bfs 
                counter++ 
    Input: grid = [
    ["1","1","1","1","0"], grid[0].length = 5
    ["1","1","0","1","0"],
    ["1","1","0","0","0"],
    ["0","0","0","0","0"]
    ]
    Output: 1
    
    */

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
                    bfs(row, col, grid);
                    islandCounter++;
                }
            }
        }

        return islandCounter;
    }

    private void bfs(int row, int col, char[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        grid[row][col] = '0';
        q.add(new Pair(row, col));

        while (!q.isEmpty()) {
            Pair cell = q.poll();
            checkNeighbors(cell.x, cell.y, q, grid);
        }
    }

    private void checkNeighbors(int x, int y, Queue<Pair> q, char[][] grid) {
        // up 
        if (x - 1 >= 0 && grid[x - 1][y] == '1') {
            grid[x - 1][y] = '0';
            q.add(new Pair(x - 1, y));
        }
        // down 
        if (x + 1 <= grid.length - 1 && grid[x + 1][y] == '1') {
            grid[x + 1][y] = '0';
            q.add(new Pair(x + 1, y));
        }
        // left 
        if (y - 1 >= 0 && grid[x][y - 1] == '1') {
            grid[x][y - 1] = '0';
            q.add(new Pair(x, y - 1));
        }
        // right 
        if (y + 1 <= grid[0].length - 1 && grid[x][y + 1] == '1') {
            grid[x][y + 1] = '0';
            q.add(new Pair(x, y + 1));
        }

        /**
        
        
          c o l -  y grid[0].length 
        r
        o
        w
        |
        x. grid.length - 1
        
         */
    }
}