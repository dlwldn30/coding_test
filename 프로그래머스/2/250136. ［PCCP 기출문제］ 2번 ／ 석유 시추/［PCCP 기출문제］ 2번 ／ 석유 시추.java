import java.util.*;

class Solution {
    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    int[][] idMap;
    
    
    public int solution(int[][] land) {
        
        int n = land.length;
        int m = land[0].length;
        
        idMap = new int[n][m];
        
        int id = 1;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(land[i][j] == 1&& idMap[i][j] == 0){
                    int count = bfs(land, id, i, j);
                    map.put(id, count);
                    id++;
                }
            }
        }
        
        int answer = 0;
        
        for (int i = 0; i < m; i++){
            Set<Integer> visited = new HashSet<>();
            
            int sum = 0;
            
            for(int j = 0; j < n; j++){
                int curId = idMap[j][i];
                
                if(curId > 0 && !visited.contains(curId)){
                    visited.add(curId);
                    sum += map.get(curId);
                }
            }
            
            answer = Math.max(sum, answer);
            
        }
        
        
        
        return answer;
    }
    
    private int bfs(int[][] land, int id, int i, int j){
        
        int n = land.length;
        int m = land[0].length;
        
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i, j});
        idMap[i][j] = id;
        
        int count = 1;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            
            for(int k = 0; k < 4; k++){
                int nx = cx + dx[k];
                int ny = cy + dy[k];
                
                if(nx >= 0 && nx < n && ny >= 0 && ny < m){
                    if(land[nx][ny] == 1&& idMap[nx][ny] == 0){
                        q.offer(new int[]{nx, ny});
                        idMap[nx][ny] = id;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}