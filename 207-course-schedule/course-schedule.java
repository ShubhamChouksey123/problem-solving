class Solution {
    
    private void createGraph(List<List<Integer>> graph, int[][] prerequisites, int numCourses) {

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int preCourse = prerequisite[1];
            graph.get(course).add(preCourse);
        }

    }


    private boolean isCycleExists(List<List<Integer>> graph, int[] state, int startCourse) {

        if (state[startCourse] == 1) {
            return true;
        }
        if (state[startCourse] == 2) {
            return false;
        }

        state[startCourse] = 1;
        for (Integer preCourse : graph.get(startCourse)) {
            if (isCycleExists(graph, state, preCourse)) {
                return true;
            }

        }
        state[startCourse] = 2;
        return false;
    }

    /**
     * if there exists a cycle in the directed graph return false
     * else true
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        createGraph(graph, prerequisites, numCourses);

        int[] state = new int[numCourses];

        for (int course = 0; course < numCourses; course++) {
            if (state[course] == 0 && isCycleExists(graph, state, course)) {
                return false;
            }

        }

        return true;
    }
}