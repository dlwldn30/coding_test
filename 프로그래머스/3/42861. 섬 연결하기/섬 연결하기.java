import java.util.*;

class Solution {
    
    int[] parent;
    
    public int solution(int n, int[][] costs) {
        
        Arrays.sort(costs, (a,b) -> a[2] - b[2]);
        
        parent = new int[n+1];
        int result = 0;
        
        for(int i = 1; i <= n ; i++) parent[i] = i;
        
        for(int i = 0; i < costs.length; i++){
            int a = costs[i][0];
            int b = costs[i][1];
            int w = costs[i][2];
            
            if(find(a) != find(b)){
                result += w;
                union(a,b);
            }
            
            
            
            
        }
        return result;
    }
    
    public int find(int a){
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
    
    private void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a!=b)
            parent[a] = b;
    }
}