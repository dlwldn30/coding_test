class Solution {
    public int solution(int[] money) {
        int length = money.length;
    
        
        
        int max1 = findMax(money, 0, length-2);
        int max2 = findMax(money, 1, length-1);
        
        int max = Math.max(max1, max2);
        
        return max;
    }
    
    private int findMax(int[] money, int start, int end){
        
        int prev1 = 0;
        int prev2 = 0;
        
        for (int i = start; i<= end; i++){
            
            int cur = Math.max(prev1, prev2+money[i]);
            
            prev2 = prev1;
            prev1 = cur;
        }
        
        return prev1;
    }
}