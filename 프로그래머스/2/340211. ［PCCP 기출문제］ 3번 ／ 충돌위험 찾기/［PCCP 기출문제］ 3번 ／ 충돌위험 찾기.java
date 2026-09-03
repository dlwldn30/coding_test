import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        
        Map<Integer, List<int[]>> map = new HashMap<>();
        int answer = 0;
        
        for(int i = 0; i < routes.length; i++){
            
            // 원본 points 변경 방지
            int[] start = points[routes[i][0] - 1].clone();
            
            map.put(i, new ArrayList<>());
            map.get(i).add(new int[]{start[0], start[1]});
            
            for(int j = 1; j < routes[i].length; j++){
                int[] des = points[routes[i][j] - 1];
                
                while(start[0] != des[0]){
                    if(start[0] < des[0]){
                        start[0]++;
                    }else{
                        start[0]--;
                    }
                    
                    map.get(i).add(new int[]{start[0], start[1]});
                }
                
                while(start[1] != des[1]){
                    if(start[1] < des[1]){
                        start[1]++;
                    }else{
                        start[1]--;
                    }
                    
                    map.get(i).add(new int[]{start[0], start[1]});
                }
            }
        }
        
        int max = 0;
        
        for(int i : map.keySet()){
            max = Math.max(map.get(i).size(), max);
        }
        
        for(int i = 0; i < max; i++){
            
            int count = 0;
            
            Map<String, Integer> check = new HashMap<>();
            
            for(int robot : map.keySet()){
                List<int[]> path = map.get(robot);
                
                // 여기 >=
                if(i >= path.size()) continue;
                
                int[] pos = path.get(i);
                
                String key = pos[0] + "," + pos[1];
                
                check.put(key, check.getOrDefault(key, 0) + 1);
            }
            
            for(int n : check.values()){
                if(n >= 2){
                    count++;
                }
            }
            
            answer += count;
        }
        
        return answer;
    }
}