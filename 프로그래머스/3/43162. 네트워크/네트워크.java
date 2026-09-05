import java.util.*;

class Solution {
    
    int answer = 0;

    public int solution(int n, int[][] computers) {
        
        boolean[] visited  = new boolean[n];
        
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                answer++;
                dfs(visited, computers, i, n);
            }
        }
        
        return answer;
    }
    
    private void dfs(boolean[] visited, int[][] computers, int a, int n){
        
        visited[a] = true;
         // 방문 여부, 전체 맵, 현재위치, 총 길이
        for(int i = 0; i < n; i++){
            if(computers[a][i] == 1 && !visited[i])
                dfs(visited, computers, i, n);
        }
        
        
    }
}