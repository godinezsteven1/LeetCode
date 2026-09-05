class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] indegree = new int[numCourses]; 
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>()); 
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prereq = prerequisites[i][1];

            graph.get(prereq).add(course);
            indegree[course]++;
        }
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        int[] answer = new int[numCourses];
        int idx = 0;
        while (!q.isEmpty()) {
            int course = q.poll();
            answer[idx] = course;
            idx++;

            for (int e: graph.get(course)) { // [1,2]
                indegree[e]--;

                if (indegree[e] == 0) {
                    q.add(e);
                }
            }
          
        }  
        if (idx != numCourses) {
                return new int[]{};
            }
        return answer;
        
    }
}