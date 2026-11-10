import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (a,b) -> a[1] - b[1]);
        int answer = 1;
        int idx = targets[0][1];
        int n = 1;
        
        for(int i = 1; i < targets.length; i++){
            int start = targets[i][0];
            
            if(start >= idx){
                answer++;
                idx = targets[i][1];
            }
        }
        
        return answer;
    }
}