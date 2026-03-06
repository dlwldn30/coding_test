import java.util.*;

class Solution {

    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        
        int[] result = new int[sources.length];
        
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        
        for(int[] road : roads){
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        
        int[] dist = bfs(graph, destination, n);
        
        for(int i = 0; i < sources.length; i++){
            result[i] = dist[sources[i]];
        }
        
        return result;
    }
    
    private int[] bfs(List<List<Integer>> graph, int start, int n){
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);
        
        Queue<Integer> q = new LinkedList<>();
        
        q.offer(start);
        dist[start] = 0;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int next : graph.get(cur)){
                if(dist[next] == -1){
                    dist[next] = dist[cur] + 1;
                    q.offer(next);
                }
            }
        }
        
        return dist; 
    }
}