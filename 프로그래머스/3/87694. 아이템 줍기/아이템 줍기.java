import java.util.*;

class Solution {
    
    boolean[][] visited = new boolean[102][102];
    int[][] map = new int[102][102];
    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        for(int[] r : rectangle){
            
            int x1 = r[0] * 2;
            int y1 = r[1] * 2;
            int x2 = r[2] * 2;
            int y2 = r[3] * 2;
            
            for(int i = x1; i <= x2; i++){
                for(int j = y1; j <= y2; j++){
                    
                    if(map[i][j] == 2) continue;
                    
                    if(i == x1 || i == x2 || j == y1 || j == y2) map[i][j] = 1;
                    
                    else map[i][j] = 2;
                }
            }
        }
        
        return bfs(characterX*2, characterY*2, itemX*2, itemY*2)/2;
    }
    
    private int bfs(int sx, int sy, int ex, int ey){
        
        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[]{sx, sy, 0});
        visited[sx][sy] = true;
        
        while(!q.isEmpty()){
            
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int w = cur[2];
            
            if(x == ex && y == ey) return w;
            
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || nx >= 102 || ny < 0 || ny >= 102) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny] != 1) continue;
                
                visited[nx][ny] = true;
                
                q.offer(new int[]{nx, ny, w+1});
            }
            
        }
        
        return 0;
    }
}