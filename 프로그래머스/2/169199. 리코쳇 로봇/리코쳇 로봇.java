import java.util.*;

class Solution {
    
    boolean[][] visited;
    
    int[] dx = {-1, 1, 0, 0};
    
    int[] dy = {0, 0, 1, -1};
    
    public int solution(String[] board) {
        
        int n = board.length;
        int m = board[0].length();
        
        int[][] pos = new int[2][2];
        visited = new boolean[n][m];
        
        // 시작점 끝점 위치 찾기
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i].charAt(j) == 'R'){
                    pos[0][0] = i;
                    pos[0][1] = j;
                } else if(board[i].charAt(j) == 'G'){
                    pos[1][0] = i;
                    pos[1][1] = j;
                }
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        
        
        q.offer(new int[]{pos[0][0], pos[0][1], 0});
        visited[pos[0][0]][pos[0][1]] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int w = cur[2];
            
            if(x == pos[1][0] && y == pos[1][1]) return w;
            
            
            
            for(int i = 0; i < 4; i++){
                int nx = x;
                int ny = y;
                
                while(true){
                    
                    int tx = nx + dx[i];
                    int ty = ny + dy[i];      
                    
                    if(tx < 0 || tx >= n || ty < 0 || ty >= m) break;
                    if(board[tx].charAt(ty) == 'D') break;
                    
                    nx = tx;
                    ny = ty;
                }
                
                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, w+1});
                }
                
                
            }
        }
        
        return -1;
    }
}