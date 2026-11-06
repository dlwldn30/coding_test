import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int[] dp = new int[m];
        
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int i = 0; i < info.length; i++){
            
            int a = info[i][0];
            int b = info[i][1];
             
            int[] next = new int[m];
            Arrays.fill(next, Integer.MAX_VALUE);
            
            for(int j = 0; j < m; j++){
                if (dp[j] == Integer.MAX_VALUE) continue;
                
                if(dp[j] + a < n){
                    next[j] = Math.min(next[j], dp[j] + a);
                }
                
                if(b + j < m) next[b+j] = Math.min(next[b+j], dp[j]);
            }
            
            dp = next;
        }
        
        int answer = Integer.MAX_VALUE;
        for(int a : dp) answer = Math.min(answer, a);
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}