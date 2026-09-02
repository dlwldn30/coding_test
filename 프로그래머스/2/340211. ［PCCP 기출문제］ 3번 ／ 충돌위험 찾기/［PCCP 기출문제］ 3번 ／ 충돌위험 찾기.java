 import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        
        // 각각 포인트에서 포인트로 이동함
        // 위아래 다음 좌우로 이동
        // 각각 한번에 움직여야 하는데
        // 각각 시간별 위치를 저장하는게 좋아 보임, List로?
        // 각각 도착하는 시간도 다름, 시간은 가장 긴걸로 
        
        
        // 로봇별 이동경로
        Map<Integer, List<int[]>> map = new HashMap<>();
        
        for(int i = 0; i < routes.length; i++){
            map.putIfAbsent(i, new ArrayList<>());
            
            int sx = points[routes[i][0]-1][0];
            int sy = points[routes[i][0]-1][1];
            
            map.get(i).add(new int[]{sx, sy});
            
            for(int j = 1; j < routes[i].length; j++){
                int ex = points[routes[i][j]-1][0];
                int ey = points[routes[i][j]-1][1];
                
                while (sx != ex){
                    if(sx < ex) sx++;
                    else sx--;
                    map.get(i).add(new int[]{sx, sy});
                }

                while(sy != ey){
                    if(sy < ey){
                        sy++;
                    }else{
                        sy--;
                    }
                    map.get(i).add(new int[]{sx, sy});
                }
                
            }
        }
        
        int max = 0;
        int answer = 0;
        
        for(int i : map.keySet()){
            int len = map.get(i).size();
            max = Math.max(max, len);
        }
        
        for(int i = 0; i <= max; i++){
            
            Map<String, Integer> count = new HashMap<>();
            
            for(int robot : map.keySet()){
                
                List<int[]> path = map.get(robot);
                if(i >= path.size()) continue;
                
                int[] pos = path.get(i);
                
                String key = pos[0] + "," + pos[1];
                
                count.put(key, count.getOrDefault(key, 0) + 1);
            }
            
            for(int c : count.values()){
                if(c >= 2){
                    answer++;
                }
            }
        }
        
        return answer;
    }
}