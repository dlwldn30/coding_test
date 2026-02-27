class Solution {
    
    int result = 0;
    boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        
        int count = 0;
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, count, visited);
       
        
        
        return result;
    }
    
    
    private void dfs(int k, int[][] dungeons, int count, boolean[] visited){
        
        result = Math.max(result, count);
        
        for(int i = 0; i < dungeons.length; i++){
            if(k-dungeons[i][0] >= 0 && !visited[i]){
                visited[i] = true;
                dfs(k-dungeons[i][1], dungeons, count+1, visited);
                visited[i] = false;
            }
        }
        
        
        
    }
    
    
}