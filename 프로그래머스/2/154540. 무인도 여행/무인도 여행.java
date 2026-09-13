import java.util.*;

class Solution {
    
    boolean[][] visited;
    
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    
    public int[] solution(String[] maps) {
        
        int n = maps.length;
        int m = maps[0].length();
        
        visited = new boolean[n][m];
        List<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                
                if (maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                    
                    int sum = 0;
                    
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        
                        int x = cur[0];
                        int y = cur[1];
                        
                        sum += maps[x].charAt(y) - '0';
                        
                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            
                            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                            if (visited[nx][ny]) continue;
                            if (maps[nx].charAt(ny) == 'X') continue;
                            
                            visited[nx][ny] = true;
                            q.offer(new int[]{nx, ny});
                        }
                    }
                    
                    answer.add(sum);
                }
            }
        }
        
        if (answer.isEmpty()) {
            return new int[]{-1};
        }
        
        Collections.sort(answer);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}