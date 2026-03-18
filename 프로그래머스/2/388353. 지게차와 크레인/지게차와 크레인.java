import java.util.*;


class Solution {
    
    char[][] map;
    int n, m;
    
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    boolean[][] visited;
    
    public int solution(String[] storage, String[] requests) {
        
        n = storage.length;
        m = storage[0].length();
        
        map = new char[n+2][m+2];
        
        visited = new boolean[n][m];
        
        for(int i = 0; i < n+2; i ++){
            for(int j = 0; j < m+2; j++)
                map[i][j] = '*';
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                map[i+1][j+1] = storage[i].charAt(j);
            }
        }
        
        for(int i = 0; i < requests.length; i++){
            if(requests[i].length() == 2){
                deleteAll(requests[i].charAt(0));
            }else{
                bfs(requests[i].charAt(0));
            }   
        }
        
        int count = 0;
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(map[i][j] != '*')
                    count++;
            }
        }
        
        return count;
    }
    
    private void deleteAll(char c){
        for(int i = 1; i<= n; i++){
            for(int j = 1; j <= m; j++){
                if(map[i][j] == c)
                    map[i][j] = '*';
            }
        }
    }
    
    private void bfs(char c){

    visited = new boolean[n+2][m+2];

    Queue<int[]> q = new ArrayDeque<>();
    q.add(new int[]{0,0});
    visited[0][0] = true;

    while(!q.isEmpty()){
        int[] cur = q.poll();

        for(int i = 0; i < 4; i++){
            int nx = cur[0] + dx[i];
            int ny = cur[1] + dy[i];

            if(nx<0||ny<0||nx>=n+2||ny>=m+2||visited[nx][ny])
                continue;

            if(map[nx][ny] == c){
                map[nx][ny] = '*';
            } else if(map[nx][ny] == '*'){
                q.add(new int[]{nx, ny});
            }

            visited[nx][ny] = true;
        }
    }
}
    
}