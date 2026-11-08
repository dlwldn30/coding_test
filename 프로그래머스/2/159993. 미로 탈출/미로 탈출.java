 import java.util.*;

class Solution {
    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    
    public int solution(String[] maps) {
        int[][] pos = new int[3][2];
        
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[0].length(); j++){
                char c = maps[i].charAt(j);
                if(c == 'S'){
                    pos[0][0] = i;
                    pos[0][1] = j;
                } else if(c == 'L'){
                    pos[1][0] = i;
                    pos[1][1] = j;
                }else if (c == 'E'){
                    pos[2][0] = i;
                    pos[2][1] = j;
                }
            }
        }
        
        int dist1 = bfs(maps, pos[0], pos[1]);
        if(dist1 == -1) return -1;
        int dist2 = bfs(maps, pos[1], pos[2]);
        if(dist2 == -1) return -1;
        
        return dist1 + dist2;
        
    }
    
    private int bfs(String[] maps, int[] s, int[] e){
        
        int n = maps.length;
        int m = maps[0].length();
        
        boolean[][] visited = new boolean[n][m];
        Deque<int[]> dq = new ArrayDeque<>();
        
        dq.offer(new int[]{s[0], s[1], 0});
        
        while(!dq.isEmpty()){
            int[] cur = dq.poll();
            int x = cur[0];
            int y = cur[1];
            int w = cur[2];
            
            if(x == e[0] && y == e[1]) return w;
            
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(visited[nx][ny]) continue;
                if(maps[nx].charAt(ny) == 'X') continue;
                
                dq.offer(new int[]{nx, ny, w+1});
                visited[nx][ny] = true;
            }
        }
        
        return -1;
    
    }
}