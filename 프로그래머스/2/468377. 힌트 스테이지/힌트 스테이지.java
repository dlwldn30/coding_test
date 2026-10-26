import java.util.*;

class Solution {
    
    int min = Integer.MAX_VALUE;
    
    public int solution(int[][] cost, int[][] hint) {
        int answer = 0;
        
        int[] haveHint = new int[cost.length];
        
        dfs(cost, hint, answer, 0, haveHint);
        
        
        return min;
    }
    
    private void dfs(int[][] cost, int[][] hint, int answer, int cur, int[] haveHint){
        
        // 스테이지 풀고 힌트 번들을 살것이냐
        if(cur == cost.length){
            min = Math.min(min, answer);
            return;
        }
        
        if(answer >= min) return;
        
        int useHint = Math.min(haveHint[cur], cost.length - 1);
        answer += cost[cur][useHint];
        
        dfs(cost, hint, answer, cur+1, haveHint);
        
        if(cur < hint.length){
            int[] buyHint = haveHint.clone();
            
            for(int i = 1; i < hint[cur].length; i++){
                int stageIndex = hint[cur][i] - 1;
                buyHint[stageIndex]++;
            }
            dfs(cost, hint, answer + hint[cur][0], cur+1, buyHint);
        }
        
        
    }
}