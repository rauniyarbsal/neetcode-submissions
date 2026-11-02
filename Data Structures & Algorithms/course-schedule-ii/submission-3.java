class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // build adj list
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int []pre : prerequisites){
            int course = pre[0];
            int prerequisite = pre[1];

            adj.get(course).add(prerequisite);
        }

        // maintain state
        int []state = new int[numCourses];
        ArrayList<Integer> ans = new ArrayList<>();

        for(int course = 0; course < numCourses; course++){

            if(hasCycle(numCourses, adj, state, course, ans)){
                return new int[0];

            }

        }

        int []result = new int[ans.size()];

        int i = 0;
        for(int x: ans){
            result[i++] = x;

        }

        return result;
    }

    public boolean hasCycle(int numCourses, List<List<Integer>> adj, int []state, int course, ArrayList<Integer> ans){
        if(state[course] == 2){ // explored and already completed
            return false;

        }

        if(state[course] == 1){ // same course we have already explored and present somewhere in our DFS path
            return true;

        }

        state[course] = 1;
        for(int pre: adj.get(course)){

            if(hasCycle(numCourses, adj, state, pre, ans)){
                return true;

            }

        }

        ans.add(course);
        state[course] = 2;
        return false;
    }
}
