import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        
        int rNum = routes.length;
        
        List<List<int[]>> paths = new ArrayList<>();
        
        //로봇 당 경로
        for(int i = 0; i < rNum; i++){
            
            List<int[]> path = new ArrayList<>();
            
            //시작 좌표
            int start = routes[i][0]-1;
            int r = points[start][0];
            int c = points[start][1];
            
            path.add(new int[]{r,c});
            
            for(int j = 1; j < routes[i].length; j++){
                
                int next = routes[i][j]-1;
                int tr = points[next][0];
                int tc = points[next][1];
                
                while(r != tr){
                    if(tr > r) r++;
                    else r--;
                    path.add(new int[]{r, c});
                }
                while(c != tc){
                    if(tc < c) c--;
                    else c++;
                    path.add(new int[]{r, c});
                }
            }
            
            paths.add(path);
            
        }
        
        //최대 시간
        int maxTime = 0;
        
        for(List<int[]> p : paths){
            maxTime = Math.max(maxTime, p.size());
        }
        
        int answer = 0;
        
        //시간마다 로봇의 위치
        for(int t = 0; t < maxTime; t++){
            
            
            Map<String, Integer> map = new HashMap<>();
            
            for(List<int[]> p : paths){
                
                if(t >= p.size()) continue;
                
                int[] pos = p.get(t);
                String s = pos[0] + "," + pos[1];
                
                map.put(s, map.getOrDefault(s, 0) + 1);
                
            }
            
            for(int count : map.values()){
                if(count > 1) answer++;
            }
            
        }
        
        return answer;
    }
    
    
}