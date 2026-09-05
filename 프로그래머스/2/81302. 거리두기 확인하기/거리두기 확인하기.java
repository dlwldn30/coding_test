import java.util.*;

class Solution {
    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    
    public int[] solution(String[][] places) {
        
        int[] answer = new int[places.length];
        
        for(int i = 0; i < places.length; i++){
            answer[i] = 1;
            boolean result = true;
            for(int j = 0; j < 5; j++){
                for(int k = 0; k < 5; k++){
                    if(places[i][j].charAt(k) == 'P'){
                        result = check(places[i], j, k);
                        if(result == false){
                            answer[i] = 0;
                            break;
                        }
                    }
                    if(result == false) break;
                }
                if(result == false) break;
            }
        }
        
        return answer;
    }
    
    private boolean check(String[] places, int j, int k){
        
        boolean[][] visited = new boolean[5][5];
        
        Queue<int[]> q = new ArrayDeque<>();
        
        q.offer(new int[]{j, k, 0});
        visited[j][k] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int w = cur[2];
            
            if(w == 2) continue;
            
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
                if(visited[nx][ny]) continue;
                
                if(places[nx].charAt(ny) == 'X') continue;
                else if(places[nx].charAt(ny) == 'O'){
                    q.offer(new int[]{nx, ny, w+1});
                    visited[nx][ny] = true;
                }else return false;
            }
        }
        
        
        return true;
    }
}