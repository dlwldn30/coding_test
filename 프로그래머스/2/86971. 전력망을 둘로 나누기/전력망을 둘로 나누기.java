class Solution {
    
    int result = 100;
    
    public int solution(int n, int[][] wires) {
        
        for (int i = 0; i < wires.length; i++){
            boolean[] visited = new boolean[n+1];
            int m = wires[i][0];
            int count = dfs(n ,wires, visited, wires[i][0], i);
            
            int diff = Math.abs((n - count) - count);
            
            result = Math.min(diff, result);
        }
        
        return result;
    }
    
    
    private int dfs(int n, int[][] wires, boolean[] visited, int node, int skip){
        
        visited[node] = true;
        int count = 1;
        
        for (int i = 0; i < wires.length; i++){
            if(i == skip) continue;
            
            int a = wires[i][0];
            int b = wires[i][1];
            
            if(a == node && !visited[b])
                count += dfs(n, wires, visited, b, skip);
            else if(b == node && !visited[a])
                count += dfs(n, wires, visited, a, skip);
                
            
        }
        
        return count;
        
    
    }
}
