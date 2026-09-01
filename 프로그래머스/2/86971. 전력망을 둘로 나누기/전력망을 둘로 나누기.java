import java.util.*;

class Solution {
    
    List<Integer>[] graph;
    public int solution(int n, int[][] wires) {
        int max = 1000;
        
        int len = wires.length;
        
        for(int i = 0; i < len; i++){
            graph = new ArrayList[n+1];
            boolean[] visited = new boolean[n+1];
            
            for(int j = 1; j <= n; j++) graph[j] = new ArrayList<>();
            
            for (int j = 0; j < len; j++){
                if(i == j) continue;
                
                int s = wires[j][0];
                int e = wires[j][1];
                
                graph[s].add(e);
                graph[e].add(s);
            }
            
            int l = dfs(visited, 1);
            int diff = Math.abs(n-2*l);
            
            max = Math.min(diff, max);
            
        }
        
        return max;
    }
    
    private int dfs(boolean[] visited, int a){
        
        int count = 1;
        visited[a] = true;
        
        for(int next : graph[a]){
            if(!visited[next]){
                count += dfs(visited, next);
            }
        }
        
        
        return count;
    }
}