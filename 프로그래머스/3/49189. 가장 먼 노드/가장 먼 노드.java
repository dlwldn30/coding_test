import java.util.*;

class Solution {
    
    List<List<Integer>> list = new ArrayList<>();
    
    public int solution(int n, int[][] edge) {
        
        
        
        for(int i = 0; i <= n; i++){
            list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < edge.length; i++){
            int a = edge[i][0];
            int b = edge[i][1];
            
            list.get(a).add(b);
            list.get(b).add(a);
        }
        
        int max = 0;
        int count = 0;
        
        
        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        
        visited[1] = true;
        q.add(1);
        int[] dist = new int[n+1];
        dist[1] = 0;
        
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int l : list.get(cur)){
                if(!visited[l]){
                    visited[l] = true;
                    dist[l] = dist[cur] + 1;
                    q.add(l);
                }
            }
        }
        
        for(int i = 1; i <=n; i++){
            max = Math.max(max, dist[i]);
        }
        
        for(int i = 1; i <= n; i++){
            if(dist[i] == max) count++;
        }
        
        
        return count;
    }
}