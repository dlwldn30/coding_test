class Solution {
    
    int max = 0;
    boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        
        dfs(dungeons, 0, k);
        
        
        return max;
    }
    
    private void dfs(int[][] dungeons, int n, int k){
        if(n > max) max = n;
        
        for(int i = 0; i < dungeons.length; i++){
            if(!visited[i]){
                if(k >= dungeons[i][0]){
                    visited[i] = true;
                    dfs(dungeons, n+1, k-dungeons[i][1]);
                    visited[i] = false;
                }
            }
        }
    }
    
   
    
}