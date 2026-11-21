class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();

        return canPartition(s, ans, 0, new ArrayList<>());
    }

    public List<List<String>> canPartition(String s, List<List<String>> ans, int idx, List<String> tempSet){
        if(idx >= s.length()){
            ans.add(new ArrayList<>(tempSet));


        }

        for(int end = idx; end < s.length(); end++){
            String st = s.substring(idx, end + 1);

            if(isPalin(st)){
                tempSet.add(st); // choose

                canPartition(s, ans, end + 1, tempSet); // explore

                tempSet.remove(tempSet.size()-1); // backtrack
            }
        }

        return ans;
    }


    public boolean isPalin(String s){
        int i = 0, j = s.length()-1;

        while(i < j){

            if(s.charAt(i) != s.charAt(j)) return false;

            i++;
            j--;
        }

        return true;
    }
}
