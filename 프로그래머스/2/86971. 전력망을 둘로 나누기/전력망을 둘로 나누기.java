import java.util.*;

class Solution {
    
    List<Integer>[] graph;
    
    public int solution(int n, int[][] wires) {
        
        int max = 1000;
        
        for(int i = 0; i < wires.length; i++){
            graph = new ArrayList[n+1];
            boolean[] visited = new boolean[n+1];
            
            
            for(int j = 1; j <= n; j++) graph[j] = new ArrayList<>();
            
            for(int j = 0; j < wires.length; j++){
                if(i == j) continue;
                int a = wires[j][0];
                int b = wires[j][1];
                
                graph[a].add(b);
                graph[b].add(a);
            }
            
            int l = dfs(visited, 1);
            
            int diff = Math.abs((n-l)- l);
            
            max = Math.min(diff, max);
            
           
            
        }
        
        
        return max;
    }
    
    
    private int dfs(boolean[] visited, int node){
        
        int count = 1;
        visited[node] = true;
        
        for(int next: graph[node]){
            if(!visited[next]){
                count += dfs(visited, next);
            }
        }
        
        return count;
    }
}