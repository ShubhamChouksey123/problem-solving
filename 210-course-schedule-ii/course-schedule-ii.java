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

    private boolean isCycleExist(List<List<Integer>> graph, int startCourse, int[] state, List<Integer> correctOrder) {

        if (state[startCourse] == 1) {
            return true;
        }

        if (state[startCourse] == 2)
            return false;

        state[startCourse] = 1;

        for (Integer preCourse : graph.get(startCourse)) {
            if (isCycleExist(graph, preCourse, state, correctOrder)) {
                return true;
            }
        }
        correctOrder.add(startCourse);
        state[startCourse] = 2;
        return false;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        createGraph(graph, prerequisites, numCourses);
        
        int[] state = new int[numCourses];
        List<Integer> correctOrder = new ArrayList<>();

        for (int course = 0; course < numCourses; course++) {
            if (state[course] == 0 && isCycleExist(graph, course, state, correctOrder)) {
                return new int[0];
            }
        }

        int[] order = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            order[i] = correctOrder.get(i);
        }
        return order;
    }
}