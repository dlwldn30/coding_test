import java.util.*;

class Solution {
    
    int[] dx = {1, -1 ,0, 0};
    int[] dy = {0, 0, 1, -1};
    
    int[][] map = new int[102][102];
    boolean[][] visited = new boolean[102][102];
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        for(int[] rect : rectangle){
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;
            
            for(int x = x1; x <= x2; x++){
                for(int y = y1; y <= y2; y++){
                    if(x > x1 && x < x2 && y > y1 && y < y2){
                        map[x][y] = 2;
                    }else{
                        if(map[x][y] != 2){
                            map[x][y] = 1;
                        }
                    }
                }
            }
        }
        
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;
        
        return bfs(characterX, characterY, itemX, itemY)/2;
    }
    
    
    private int bfs(int startX, int startY, int itemX, int itemY){
        
        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[]{startX, startY, 0});
        visited[startX][startY] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int w = cur[2];
            
            if(x == itemX && y == itemY) return w;
            
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(!visited[nx][ny] && map[nx][ny] == 1){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, w+1});
                }
            }
        }
        
        return -1;
    }
}