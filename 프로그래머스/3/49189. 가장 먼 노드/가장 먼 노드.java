import java.util.*;

class Solution {
    
    boolean[] visited;
    List<List<Integer>> list = new ArrayList<>();
    int[] result;
    int answer = 0;
    
    public int solution(int n, int[][] edge) {
        
        for(int i = 0; i <= n; i++) list.add(new ArrayList<>());
        visited = new boolean[n+1];
        result = new int[n+1];
        int max = 0;
        
        
        for(int i = 0; i< edge.length; i++){
            int a = edge[i][0];
            int b = edge[i][1];
            
            list.get(a).add(b);
            list.get(b).add(a);
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        visited[1] = true;
        q.add(1);
        result[1] = 1;
        
        while(!q.isEmpty()){
            int n1 = q.poll();
            int w = result[n1];
            
            if(max < w) max = w;
            
            for(int m : list.get(n1)){
                if(!visited[m]){
                    visited[m] = true;
                    q.add(m);
                    result[m] = w+1;
                }
            }
        }
        
        for(int i = 1; i <=n ; i++){
            if(result[i] == max) answer++;
        }
        
        return answer;
    }
}