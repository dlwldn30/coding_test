import java.util.*;

class Solution {
    
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    
    boolean[][] visited;
    
    public int solution(int[][] maps) {
        
        int n = maps.length;
        int m = maps[0].length;
        
        int[][] route = new int[n][m];
        visited = new boolean[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(maps[i][j] == 0)
                    route[i][j] = -1;
            }
        }
        
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0});
        visited[0][0] = true;
        route[0][0] = 1;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            
            if(x == n-1 && y == m-1) return route[x][y];
            
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(route[nx][ny] == -1) continue;
                if(visited[nx][ny]) continue;
                
                route[nx][ny] = route[x][y] + 1;
                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }
        
        
        return -1;
    }
}