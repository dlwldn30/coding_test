import java.util.*;

class Solution {
    
    boolean[][] visited; 
    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        int count = 0;
        int[][] dist = new int[n][m];
        visited = new boolean[n][m];
        
        Queue<int[]> q = new LinkedList<>();
        visited[0][0] = true;
        q.offer(new int[]{0,0});
        dist[0][0] = 1;
        
        while(!q.isEmpty()){
            
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            
            if(x == n-1 && y == m-1) return dist[x][y];
            
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx >= 0 && nx < n && ny>= 0 && ny < m && maps[nx][ny] == 1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                    dist[nx][ny] = dist[x][y] + 1;
                }
            }
            
            
            
            
        }
        return -1;
       
    }
    
    
    
}