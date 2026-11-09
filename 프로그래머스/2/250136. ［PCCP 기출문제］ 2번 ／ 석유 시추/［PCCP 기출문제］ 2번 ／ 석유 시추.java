import java.util.*;

class Solution {
    
    boolean[][] visited;
    int[] answer;

    
    int[] dx = {1, -1, 0 ,0};
    int[] dy = {0, 0, 1, -1};
    
    public int solution(int[][] land) {
        // 먼저 석유량을 알아야 함.
        // 
        int n = land.length;
        int m = land[0].length;
        
        answer = new int[m];
        visited = new boolean[n][m];
        
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j] && land[i][j] == 1){
                    bfs(land, i, j);
                }
            }
        }
        
        int max = 0;
        
        for(int i = 0; i < m; i++){
            max = Math.max(max, answer[i]);
        }
        
        return max;
    }
    
    private void bfs(int[][] land, int i1, int j1){
        
        boolean[] av = new boolean[land[0].length];
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i1, j1});
        visited[i1][j1] = true;
        av[j1] = true;
        int sum = 1;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || nx >= land.length || ny < 0 || ny >= land[0].length) continue;
                if(visited[nx][ny]) continue;
                if(land[nx][ny] == 0) continue;
                
                q.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
                sum++;
                av[ny] = true;
            }
        }
        
        for(int i = 0; i < land[0].length; i++){
            if(av[i]) answer[i] += sum;
        }
    }
}