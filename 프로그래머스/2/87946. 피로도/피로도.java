class Solution {
    
    int result = 0;
    
    public int solution(int k, int[][] dungeons) {
        
        boolean[] visited = new boolean[dungeons.length];
        
        int count = 0;
        
        dfs(dungeons, visited, count, k);
        
        return result;
    }
    
    private void dfs(int[][] dungeons, boolean[] visited, int count, int k){
        
        result = Math.max(count, result);
        
        for (int i = 0; i < dungeons.length; i++){
            if(!visited[i] && k-dungeons[i][0] >= 0){
                visited[i] = true;
                dfs(dungeons, visited,  count+1, k-dungeons[i][1]);
                visited[i] = false;
            }
        }
    }
    
}