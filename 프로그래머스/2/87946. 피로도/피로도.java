class Solution {
    
    boolean[] visited;
    int max = 0;
    
    public int solution(int k, int[][] dungeons) {
        int n = dungeons.length;
        visited = new boolean[dungeons.length];
        
        dfs(dungeons, k, 0);
        
        return max;
    }
    
    private void dfs(int[][] dungeons, int k, int count){
        
        max = Math.max(max, count);
        
        for(int i = 0; i < dungeons.length; i++){
            if(!visited[i] && k-dungeons[i][0] >= 0){
                visited[i] = true;
                dfs(dungeons, k-dungeons[i][1], count+1);
                visited[i] = false;
            }
        }
    }
}