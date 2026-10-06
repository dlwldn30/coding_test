import java.util.*;

class Solution {
    
    boolean[] visited;
    List<List<Integer>> list = new ArrayList<>();
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        
        visited = new boolean[n+1];
        for(int i = 0; i <= n; i++) list.add(new ArrayList<>());
        int[] result = new int[n+1];
        
        
        for(int i = 0; i < roads.length; i++){
            int a = roads[i][0];
            int b = roads[i][1];
            
            list.get(a).add(b);
            list.get(b).add(a);
        }
        
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{destination, 0});
        visited[destination] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int num = cur[0];
            int w = cur[1];
            
            for(int m : list.get(num)){
                if(!visited[m]){
                    q.add(new int[]{m, w+1});
                    visited[m] = true;
                    result[m] = w+1;
                }
            }
        }
        
        int[] answer = new int[sources.length];
        
        for(int i = 0; i < sources.length; i++){
            if(sources[i] == destination){
                answer[i] = 0; 
            } else if(result[sources[i]] == 0){
                answer[i] = -1;
            } else {
                answer[i] = result[sources[i]];
            }
        }
        
        
        return answer;
    }
}