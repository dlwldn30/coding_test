import java.util.*;

class Solution {
    
    int[] parent;
    
    public int solution(int n, int[][] costs) {
        
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        
        parent = new int[n];
        int cost = 0;
        
        for(int i = 0; i < n; i++) parent[i] = i;
        
        for(int i = 0; i < costs.length; i++){
            int a = costs[i][0];
            int b = costs[i][1];
            int c = costs[i][2];
            
            if(union(a, b)){
                cost += c;
            }
        }
        
        return cost;
    }
            
        
        
        private int find(int n){
            if(parent[n] == n) return n;
            return parent[n] = find(parent[n]);
        }
        
        private boolean union(int a, int b){
            a = find(a);
            b = find(b);
            
            if(a ==b) return false;
            parent[a] = b;
            
            return true;
            
        }
    
}