import java.util.*;

class Solution {
    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int[][] location = new int[3][2];
    
    public int solution(String[] maps) {
        
        
        // 각 위치 찾기
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[i].length(); j++){
                char c = maps[i].charAt(j);
                if(c == 'S'){
                    location[0][0] = i;
                    location[0][1] = j;
                } else if(c == 'L'){
                    location[1][0] = i;
                    location[1][1] = j;
                } else if(c == 'E'){
                    location[2][0] = i;
                    location[2][1] = j;
                }
            }
        }
        
        int a = bfs(maps, location[0], location[1]);
        if(a == -1) return -1;
        
        int b = bfs(maps, location[1], location[2]);
        if(b == -1) return -1;
        
        
        return a+b;
    }
    
    private int bfs(String[] maps, int[] start, int[] end){
        
        int n = maps.length;
        int m = maps[0].length();
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start[0], start[1], 0});
        boolean[][] visited = new boolean[n][m];
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int w = cur[2];
            
            if(x == end[0] && y == end[1]) return w;
            
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || nx >= n || ny < 0 ||  ny >= m) continue;
                if(maps[nx].charAt(ny) == 'X') continue;
                if(visited[nx][ny]) continue;
                
                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny, w+1});
            }
        }
        
        
        return -1;
    }
}