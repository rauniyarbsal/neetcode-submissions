class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 1. build adj list
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i < numCourses; i++){
            adj.add(new ArrayList<>());

        }

        for(int []pre: prerequisites){
            int course = pre[0];
            int prerequisite = pre[1];

            adj.get(course).add(prerequisite);
        }

        /* 
            2. build 1d dp state, to keep track of status
            0 → haven't explored this course yet
            1 → currently exploring this course
            2 → completely explored; no cycle found 
        */

        int []state = new int[numCourses];

        for(int course = 0; course < numCourses; course++){
            if(hasCycle(adj, state, course)) return false;

        }

        return true;
    }

    public boolean hasCycle(List<List<Integer>> adj, int []state, int course){
        if(state[course] == 1){
            return true;

        }

        if(state[course] == 2){
            return false;

        }

        state[course] = 1;

        for(int pre: adj.get(course)){

            if(hasCycle(adj, state, pre)){
                return true;

            }
        }

        state[course] = 2;

        return false;
    }
}



