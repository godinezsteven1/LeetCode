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


    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // sr = x, sc = y 
        // we are at edges, we have seen pixel. 
        // bases cases: sr and/or sc out of bounds, image empty, same color as target
        if (color == image[sr][sc]) {
            return image;
        }



        int target = image[sr][sc];
        bfs(image, sr, sc, color, target);
        return image;
    }

    public void bfs(int[][] image, int sr, int sc, int color, int target) {
        Queue<Pair> q = new LinkedList<>(); 
        q.add(new Pair(sr, sc));
        image[sr][sc] = color;

        while (!q.isEmpty()) {
            Pair cell = q.remove();
            int x = cell.x;
            int y = cell.y;
            checkNeighbors(image, q, x, y, color, target);
        }
    }

    private void checkNeighbors(int[][] image, Queue<Pair> q, int x, int y, int color, int target) {
        if (x - 1 >= 0 && image[x - 1][y] == target) {
            q.add(new Pair(x - 1, y));
            image[x - 1][y] = color;
        }
        if (x + 1 < image.length && image[x + 1][y] == target) {
            q.add(new Pair(x + 1, y));
            image[x + 1][y] = color;
        }
        if (y - 1 >= 0 && image[x][y - 1] == target) {
            q.add(new Pair(x, y - 1));
            image[x][y - 1] = color;
        }
        if (y + 1 < image[0].length && image[x][y + 1] == target) {
            q.add(new Pair(x, y + 1)); 
            image[x][y + 1] = color;
        }
    }

}