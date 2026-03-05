import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        
        int[] dist = new int[n+1];
        boolean[] visited = new boolean[n+1];
        
        for(int[] ed : edge){
            int a = ed[0];
            int b = ed[1];
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;
        dist[1] = 0;
        
        while(!q.isEmpty()){
            int n1 = q.poll();
            
            for(int next : graph.get(n1)){
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(next);
                    dist[next] = dist[n1] + 1;
                }
            }
        }
        
        int max  = Integer.MIN_VALUE;
        
        for(int m : dist){
            max = Math.max(max, m);
        }
        
        int count = 0;
        for (int m : dist){
            if(m == max)
                count++;
        }
        
        
        return count;
    }
}