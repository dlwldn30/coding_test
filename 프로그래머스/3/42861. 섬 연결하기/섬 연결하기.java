import java.util.*;

class Solution {
    
   int[] parent;
    
    public int solution(int n, int[][] costs) {
     
        parent = new int[n];
        int answer = 0;
        
        for (int i = 0; i < n; i++){
            parent[i] = i;
        }
        
        Arrays.sort(costs, (a,b) -> a[2] - b[2]);
        
        for(int[] cost : costs){
            int a = cost[0];
            int b = cost[1];
            int w = cost[2];
            
            if(find(a) != find(b)){
                union(a,b);
                answer += w;
            }
        }
        return answer;
    }
    
    private int find(int n){
        if(parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }
    
    private void union(int a, int b){
        int rootA = parent[a];
        int rootB = parent[b];
        
        if(rootA != rootB){
            parent[rootA] = rootB;
        }
    }
    
    
}