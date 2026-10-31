class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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

        // 2. maintain 1d dp state to keep track of each course while exploring DFS path
        int []state = new int[numCourses];

        List<Integer> ans = new ArrayList<>();

        for(int course = 0; course < numCourses; course++){

            if(hasCycle(adj, state, course, ans)){
                return new int[0];

            }

            
        }

        System.out.println(ans);

        int[] result = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            result[i] = ans.get(i);
        }

        return result;
        
    }

    public boolean hasCycle(List<List<Integer>> adj, int []state, int course, List<Integer> ans){
        if(state[course] == 1){
            return true;

        }

        if(state[course] == 2){
            return false;

        }

        state[course] = 1;

        for(int prerequisite: adj.get(course)){
            if(hasCycle(adj, state, prerequisite, ans)){
                return true;
            }

        }

        ans.add(course);
        state[course] = 2;

        return false;
    }
}
