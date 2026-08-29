class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        dfs(rooms, 0, visited);
        return visited.size() == rooms.size();
    }

    private void dfs(List<List<Integer>> rooms, int room, Set<Integer> visited) {
        visited.add(room);
        for (int key: rooms.get(room)) {
            if (!visited.contains(key)) {
                dfs(rooms, key, visited);
            }
        }
    }
}