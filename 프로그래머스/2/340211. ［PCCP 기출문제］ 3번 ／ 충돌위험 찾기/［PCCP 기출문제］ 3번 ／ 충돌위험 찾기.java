import java.util.*;

class Solution {
    
    List<List<int[]>> paths = new ArrayList<>();
    
    public int solution(int[][] points, int[][] routes) {
        int rCount = routes.length;
        
        for(int i = 0; i < rCount; i++){
            List<int[]> path = new ArrayList<>();
            
            int start = routes[i][0] - 1;
            
            int r = points[start][0];
            int c = points[start][1];
            
            path.add(new int[]{r, c});
            
            for(int j = 1; j < routes[i].length; j++){
                int next = routes[i][j]-1;
                
                int tr = points[next][0];
                int tc = points[next][1];
                
                while(r != tr){
                    
                    if(r < tr) r++;
                    else r--;
                    path.add(new int[]{r, c});
                }
                
                while(c != tc){
                    
                    if(c < tc) c++;
                    else c--;
                    
                    path.add(new int[]{r, c});
                }
            }
            
            paths.add(path);
        }
        
        int max = 0;
        
        for(List<int[]> path : paths){
            max = Math.max(path.size(), max);
        }
        
        
        int answer = 0;
        
        for(int t = 0; t < max; t++){
            Map<String, Integer> map = new HashMap<>();
            
            for(List<int[]> path : paths){
                if(t >= path.size())
                    continue;
                
                int[] pos = path.get(t);
                
                int r = pos[0];
                int c = pos[1];
                
                String key = r + "," + c;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            
            for(int count : map.values()){
                
                if(count >= 2)
                    answer++;
            }
        }
        
        
        return answer;
    }
}