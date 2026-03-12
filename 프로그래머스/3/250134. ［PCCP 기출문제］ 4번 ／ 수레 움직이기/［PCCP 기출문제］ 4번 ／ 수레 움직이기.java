class Solution {
    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    
    int[] rs;
    int[] bs;
    int[] re;
    int[] be;
    
    int n, m;
    
    boolean[][] redVisited;
    boolean[][] blueVisited;
    
    int answer = Integer.MAX_VALUE;
    
    public int solution(int[][] maze) {
        n = maze.length;
        m = maze[0].length;

        
        
        // 위치 저장
        for (int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(maze[i][j] == 1) rs = new int[]{i,j};
                else if(maze[i][j] == 2) bs = new int[]{i,j};
                else if(maze[i][j] == 3) re = new int[]{i,j};
                else if(maze[i][j] == 4) be = new int[]{i,j};
            }
        }
        
        redVisited = new boolean[n][m];
        blueVisited = new boolean[n][m];
        
        redVisited[rs[0]][rs[1]]= true;
        blueVisited[bs[0]][bs[1]] = true;
        
        dfs(maze, rs[0], rs[1], bs[0], bs[1], 0);
        
        
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    
    void dfs(int[][] maze, int rx, int ry, int bx, int by, int turn){
        if(turn >= answer) return;
        
        if(rx == re[0] && ry == re[1] && bx == be[0] && by == be[1]){
            answer = Math.min(answer, turn);
            return;
        }
        
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                
                int nrx = rx;
                int nry = ry;
                int nbx = bx;
                int nby = by;
                
                if(!(rx == re[0] && ry == re[1])){
                    nrx = rx + dx[i];
                    nry = ry + dy[i];
                }
                
                if(!(bx == be[0] && by == be[1])){
                    nbx = bx + dx[j];
                    nby = by + dy[j];
                }
                
                if(!inRange(nrx, nry) || !inRange(nbx, nby)) continue;
                if(maze[nrx][nry]==5 || maze[nbx][nby]==5) continue;
                if(!(nrx == re[0] && nry == re[1]) && redVisited[nrx][nry]) continue;
                if(!(nbx == be[0] && nby == be[1]) && blueVisited[nbx][nby]) continue;
                if(nrx==nbx && nry==nby) continue;
                if(rx==nbx && ry==nby && bx==nrx && by==nry) continue;
                
                redVisited[nrx][nry] = true;
                blueVisited[nbx][nby] = true;
                
                dfs(maze, nrx, nry, nbx, nby, turn+1);
                
                redVisited[nrx][nry] = false;
                blueVisited[nbx][nby] = false;
            }
        }
        
        
        
    }
    
    private boolean inRange(int x, int y){
        return x>=0 && x<n && y>=0 && y<m;
    }
    
}