import java.util.*;

class Solution {
    
    int result = 100;
    List<Integer>[] graph;

    public int solution(int n, int[][] wires) {
        
        for (int skip = 0; skip < wires.length; skip++){
            
            graph = new ArrayList[n+1];
            for(int i = 0; i <=n; i++){
                graph[i] = new ArrayList<>();
            }
            
            for(int i = 0; i < wires.length; i++){
                if(i == skip) continue;
                
                int a = wires[i][0];
                int b = wires[i][1];
                
                graph[a].add(b);
                graph[b].add(a);
            }
            
            boolean[] visited = new boolean[n + 1];
            int count = dfs(1, visited);
            
            int diff = Math.abs((n-count) - count);
            result = Math.min(result, diff);
            
        }
        
        return result;
    }
    
    private int dfs(int node, boolean[] visited){
        
        visited[node] = true;
        int count = 1;
        
        for(int next : graph[node]){
            if(!visited[next]){
                 count += dfs(next, visited);
            }
        }
        
        return count;
    }

       
}