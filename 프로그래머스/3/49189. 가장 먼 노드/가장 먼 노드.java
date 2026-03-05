import java.util.*;


class Solution {
    public int solution(int n, int[][] edge) {
        
        boolean[] visited = new boolean[n+1];
        
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        
        for(int[] ed : edge){
            graph.get(ed[0]).add(ed[1]);
            graph.get(ed[1]).add(ed[0]);
        }
        
        int[] dist = new int[n+1];
        
        Queue<Integer> q = new LinkedList<>();
        
        q.offer(1);
        dist[1] = 0;
        visited[1] = true;
        
        while(!q.isEmpty()){
            
            int cur = q.poll();
            
            for(int next : graph.get(cur)){
                if(!visited[next]){
                    dist[next] = dist[cur]+1;
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
        
        int max = 0;
        int count = 0;
        
        for(int i = 1; i <= n; i++){
            max = Math.max(dist[i], max);
        }
        
        for(int i = 1; i <= n; i++){
            if(dist[i] == max){
                count++;
            }
        }
        
        return count;
        
    } 
}