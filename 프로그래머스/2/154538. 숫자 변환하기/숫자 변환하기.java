import java.util.*;

class Solution {
    
    boolean[] visited;
    
    public int solution(int x, int y, int n) {
        
        visited = new boolean[y*3];
        Queue<int[]> q = new ArrayDeque<>();
        
        q.add(new int[]{x, 0});
        visited[x] = true;
        
        while(!q.isEmpty()){
            
            int[] cur = q.poll();
            int c = cur[0];
            
            if(c == y) return cur[1];
            
            int n1 = c+n;
            int n2 = c*2;
            int n3 = c*3;
            
            
            
            if(!visited[n1] && n1 <= y){
                q.add(new int[]{n1, cur[1] + 1});
                visited[n1] = true;

            }
            
            if(!visited[n2] && n2 <= y){
                q.add(new int[]{n2, cur[1] + 1});
                visited[n2] = true;
            }
            
            if(!visited[n3] && n3 <= y ){
                q.add(new int[]{n3, cur[1] + 1});
                visited[n3] = true;
            }
            
        }
        
        
        
        
        
        return -1;
        
    }
}