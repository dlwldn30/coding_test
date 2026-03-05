class Solution {
    public int solution(int[] money) {
        int n = money.length;
        
        int max1 = findMax(0, n-1, money);
        int max2 = findMax(1, n, money);
        
        return Math.max(max1, max2);
    }
    
    private int findMax(int start, int end, int[] money){
        int prev1 = 0;
        int prev2 = 0;
        
        for(int i = start; i < end; i++){
            int cur = Math.max(prev1, money[i] + prev2);
            prev2 = prev1;
            prev1 = cur;
        }
        
        return prev1;
    }
}