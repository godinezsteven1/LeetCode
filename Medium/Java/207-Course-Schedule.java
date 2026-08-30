class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int pre = prereq[1];

            graph.get(pre).add(course);
        }

        int[] state = new int[numCourses];

        for (int course = 0; course < numCourses; course++) {
            if (dfs(graph, course, state)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(List<List<Integer>> graph, int course, int[] state) {

        if (state[course] == 1) {
            return true;  // cycle
        }
        if (state[course] == 2) {
            return false; // non cycle
        }
        state[course] = 1; 

        for (int neighbor : graph.get(course)) {
            if (dfs(graph, neighbor, state)) {
                return true;
            }
        }
        state[course] = 2; 
        return false;
    }
}