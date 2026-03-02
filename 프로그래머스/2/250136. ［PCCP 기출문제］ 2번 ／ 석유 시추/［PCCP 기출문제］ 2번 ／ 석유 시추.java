import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        
        int[][] idMap = new int[n][m];  // 덩어리 번호 저장
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        Map<Integer, Integer> sizeMap = new HashMap<>();
        
        int id = 1;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && idMap[i][j] == 0) {
                    int size = bfs(i, j, land, idMap, dx, dy, id);
                    sizeMap.put(id, size);
                    id++;
                }
            }
        }
        
        int answer = 0;
        
        for(int col = 0; col < m; col++){
            Set<Integer> visited = new HashSet<>();
            
            int sum = 0;
            
            for (int row = 0; row < n; row++){
                int curId = idMap[row][col];
                
                if(curId > 0 && !visited.contains(curId)){
                    visited.add(curId);
                    sum += sizeMap.get(curId);
                }
            }
            
            answer = Math.max(answer, sum);
            
        }
        
        return answer;
    }
    
    
    
    private int bfs(int x, int y, int[][] land, int[][] idMap, int[] dx, int[] dy, int id) {
        
        int n = land.length;
        int m = land[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        idMap[x][y] = id;
        
        int count = 1;
        
        while(!q.isEmpty()){
            
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            
            for(int d = 0; d < 4; d++){
                
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                
                if(nx >= 0 && ny >= 0 && nx < n && ny < m){
                    
                    if(land[nx][ny] == 1 && idMap[nx][ny] == 0){
                        
                        idMap[nx][ny] = id;
                        q.offer(new int[]{nx, ny});
                        count++;
                    }
                }
            }
            
            
        }
        return count;
    }
}