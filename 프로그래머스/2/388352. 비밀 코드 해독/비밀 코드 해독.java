class Solution {
    
    int count = 0;
    boolean[] visited;
    
    
    public int solution(int n, int[][] q, int[] ans) {
        
        visited = new boolean[n+1];
        
        dfs(n,q,ans, 0, 1);
        
        return count;
    }
    
    private void dfs(int n, int[][] q, int[] ans, int cnt, int idx){
        
        if(cnt == 5){
            if(check(visited, q, ans))
                count++;
            return;
        }
        
        
        for(int i = idx; i <= n; i++){
            
            if(!visited[i]){
                visited[i] = true;
                dfs(n, q, ans, cnt+1, i+1);
                visited[i] = false;
            }
        }
        
    }
    
    private boolean check(boolean[] visited, int[][] q, int[] ans){
        
        boolean find = true;
        
        for(int i = 0; i < q.length; i++){
            int cnt = 0;
            for(int j = 0; j < 5; j++){
                if(visited[q[i][j]])
                    cnt++;
            }
            if(cnt != ans[i]){
                find = false;
                return find;
            }
        }
        return find;
    }
}