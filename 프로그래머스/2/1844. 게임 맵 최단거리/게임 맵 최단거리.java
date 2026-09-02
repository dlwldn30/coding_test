import java.util.*;

class Solution {
    
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    
    boolean[][] visited;
    
    public int solution(int[][] maps) {
        
        int[][] routes = new int[maps.length][maps[0].length];
        visited = new boolean[maps.length][maps[0].length];
        
        int n = maps.length;
        int m = maps[0].length;
        
        
        
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[0].length; j++){
                if(maps[i][j] == 0){
                    routes[i][j] = -1;
                }
            }
        }
        
        
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0});
        visited[0][0] = true;
        routes[0][0] = 1;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            
            if(x == n-1 && y == m-1) return routes[x][y];
            
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx >= 0 && ny >= 0 && nx < n && ny < m){
                    if(!visited[nx][ny] && routes[nx][ny] != -1){
                        q.offer(new int[]{nx, ny});
                        routes[nx][ny] = routes[x][y] + 1;
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        
        
        return -1;
    }
}