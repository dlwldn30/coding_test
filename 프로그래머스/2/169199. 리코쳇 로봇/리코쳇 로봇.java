import java.util.*;

class Solution {
    
    boolean[][] visited;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    
    public int solution(String[] board) {
        
        int[][] pos = new int[2][2];
        visited = new boolean[board.length][board[0].length()];
        
        
        // 위치 저장
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length(); j++){
                if(board[i].charAt(j) == 'R'){
                    pos[0][0] = i;
                    pos[0][1] = j;
                } else if(board[i].charAt(j) == 'G'){
                    pos[1][0] = i;
                    pos[1][1] = j;
                }
            }
        }
        
        return bfs(board, pos);
    }
    
    
    private int bfs(String[] board, int[][] pos){
        
        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[]{pos[0][0], pos[0][1], 0});
        visited[pos[0][0]][pos[0][1]] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            int x = cur[0];
            int y = cur[1];
            int w = cur[2];
            
            if(x == pos[1][0] && y == pos[1][1])
                return w;
            
            for(int i = 0; i < 4; i++){
                int nx = x;
                int ny = y;
                
                while(true){
                    int tx = nx + dx[i];
                    int ty = ny + dy[i];
                    
                    if(tx < 0 || tx >= board.length || ty < 0 || ty >= board[i].length())
                        break;
                    
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