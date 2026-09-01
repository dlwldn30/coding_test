import java.util.*;

class Solution {
    
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1}; 
    
    public int solution(int[][] maps) {
        
        int x = maps.length;
        int y = maps[0].length;
        
        int[][] routes = new int[x][y];
        boolean[][] visited = new boolean[x][y];
        
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                if(maps[i][j] == 0) routes[i][j] = -1;
            }
        }
        
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0});
        visited[0][0] = true;
        routes[0][0] = 1;
        
        while(!q.isEmpty()){
            
            int[] cur = q.poll();
            int nx = cur[0];
            int ny = cur[1];
            
            if(nx == x-1 && ny == y-1) return routes[nx][ny];
            
            for(int i = 0; i < 4; i++){
                int n = nx+dx[i];
                int m = ny+dy[i];
                
                if(n >= 0 && m >= 0 && n < x && m < y){
                    if(!visited[n][m] && routes[n][m] != -1){
                        visited[n][m] = true;
                        routes[n][m] = routes[nx][ny] + 1;
                        q.offer(new int[]{n,m});
                    }
                }
            }
        }
        
        return -1;
    }
}