import java.util.*;

class Solution {
    
    List<Integer>[] graph;
    
    public int solution(int n, int[][] edge) {
        
        boolean[] visited = new boolean[n+1];
        int answer = 0;
        
        graph = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        int[] result = new int[n+1];
        int max = 0;
        
        for(int i = 0; i < edge.length; i++){
            int a = edge[i][0];
            int b = edge[i][1];
            
            graph[a].add(b);
            graph[b].add(a);
        }
        
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(1);
        visited[1] = true;
        
        while(!dq.isEmpty()){
            int c = dq.poll();
            int c1 = result[c];
            
            max = Math.max(c1, max);
            
            
            for(int next : graph[c]){
                if(!visited[next]){
                    visited[next] = true;
                    result[next] = c1 + 1;
                    dq.offer(next);
                }
            }
        }
        
        for(int i = 1; i <=n ; i++){
            if(result[i] == max) answer++;
        }
        
        return answer;
    }
}