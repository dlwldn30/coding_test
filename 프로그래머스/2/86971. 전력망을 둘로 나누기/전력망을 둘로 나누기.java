import java.util.*;

class Solution {
    
    List<Integer>[] graph;

    public int solution(int n, int[][] wires) {
        int answer = 1000;
    
        
    
        for(int i = 0; i < wires.length; i++){
            
            graph = new ArrayList[n+1];
            
            boolean[] visited = new boolean[n+1];
            
            for(int j = 1; j <= n; j++) graph[j] = new ArrayList<>();
            
            for(int j = 0; j < wires.length; j++){
                if(i == j) continue;
                
                graph[wires[j][0]].add(wires[j][1]);
                graph[wires[j][1]].add(wires[j][0]);
            }
            
            int n1 = dfs(visited, 1);
            
            
            int diff = Math.abs(n - 2 * n1);
            
            answer = Math.min(diff, answer);
        }
        
        return answer;
    }

    private int dfs(boolean[] visited, int s){
        
        int count = 1;
        visited[s] = true;
        
        for(int n : graph[s]){
            if(!visited[n]){

                count += dfs(visited, n);
            }
        }
        
        return count;
    }
}