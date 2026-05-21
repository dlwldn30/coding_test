import java.util.*;


class Solution {
    
    boolean[][] visited;
    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    
    public int solution(int[][] maps) {
        
        int n = maps.length;
        int m = maps[0].length;
        
        
        visited = new boolean[maps.length][maps[0].length];
        visited[0][0] = true;
        
        
        int[][] dist = new int[maps.length][maps[0].length];
        
        Queue<int[]> q = new LinkedList<>();
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
                
                if(nx >= 0 && ny >= 0 && nx < n && ny < m && maps[nx][ny] == 1 && !visited[nx][ny]){
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    dist[nx][ny] = dist[x][y] + 1;
                }
            }
        }
        
        
        
        return -1;
    }
}