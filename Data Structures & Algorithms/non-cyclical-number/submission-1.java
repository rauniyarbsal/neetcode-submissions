class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = n;

        do{
            slow = findSumOfDigit(slow);
            fast = findSumOfDigit(findSumOfDigit(fast));


        }while(slow != fast);

        return slow == 1;
        
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
