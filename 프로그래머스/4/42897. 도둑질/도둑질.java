import java.util.*;

class Solution {
    public int solution(int[] money) {
        int n = money.length;
        
        return Math.max(find(0, n-1, money), find(1, n, money));
    }
    
    private int find(int start, int end, int[] money){
        
        int prev1 = 0;
        int prev2 = 0;
        
        for(int i = start; i < end; i++){
            int cur = Math.max(prev1, prev2 + money[i]);
            
            prev2 = prev1;
            prev1 = cur;
        }
        
        return prev1;
    }
}