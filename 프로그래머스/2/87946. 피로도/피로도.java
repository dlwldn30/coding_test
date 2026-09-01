class Solution {
    
    int max = 0;
    
    public int solution(int k, int[][] dungeons) {
        
        boolean[] visited = new boolean[dungeons.length];
        
        dfs(dungeons, visited, k, 0);
        
        
        return max;
    }
    
    private void dfs(int[][] dungeons, boolean[] visited, int k, int s){
        
        if(max < s) max = s;
        
        for(int i = 0; i < dungeons.length; i++){
            if(!visited[i] && k-dungeons[i][0] >= 0){
                visited[i] = true;
                dfs(dungeons, visited, k-dungeons[i][1], s+1);
                visited[i] = false;
            }
        }
    }
}