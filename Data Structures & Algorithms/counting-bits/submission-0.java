class Solution {
    public int[] countBits(int n) {
        int []ans = new int[n+1];
        int count = 0;

        ans[0] = 0;

        for(int i = 1; i <= n; i++){
            int x = i;

            while(x > 0){
                x = x & (x - 1);
                count++;

            }

            ans[i] = count;
            count = 0;
        }
        
        return ans;
    }
}
