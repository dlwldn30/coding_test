import java.util.*;

class Solution {
    
    List<Integer>[] graph;
    
    public int solution(int n, int[][] wires) {
        
        int answer = n-2;
        
        for(int i = 0; i < wires.length; i++){
            
            graph = new ArrayList[n+1];
            for(int j = 1; j <= n; j++) graph[j] = new ArrayList<>();
            boolean[] visited = new boolean[n+1];
        
            for(int j = 0; j < wires.length; j++){
                if(i == j) continue;
                int a = wires[j][0];
                int b = wires[j][1];
                graph[a].add(b);
                graph[b].add(a);
            }
            
            int n1 = dfs(graph, visited, 1);
            int min = Math.abs(n - 2 * n1);
            
            answer = Math.min(answer, min);
        }
        
        return answer;
    }
    
    private int dfs(List<Integer>[] graph, boolean[] visited, int n){
        
        int count = 1;
        visited[n] = true;
        
        for(int i : graph[n]){
            if(!visited[i]){
                count +=dfs(graph, visited, i);
            }
        }
        
        
        return count;
    }
}