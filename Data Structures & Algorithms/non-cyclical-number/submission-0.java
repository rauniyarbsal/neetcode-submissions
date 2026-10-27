class Solution {
    public boolean isHappy(int n) {
        int sum = 0;
        Set<Integer> seen = new HashSet<>();

        while(n > 1){

            sum = findSumOfDigit(n);
            n = sum;

            if(!seen.add(sum)) return false;

        }

        return true;
        
    }

    public int findSumOfDigit(int n){
        int newDigit = 0;

        while(n > 0){
            int val = n % 10;

            newDigit += val * val;

            n = n / 10;
        }

        return newDigit;
    }
}
