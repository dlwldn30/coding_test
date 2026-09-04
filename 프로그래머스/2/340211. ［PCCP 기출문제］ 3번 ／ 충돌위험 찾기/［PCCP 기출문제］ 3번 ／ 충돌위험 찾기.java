import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        
        // 각 routes 별로 어디서 어디로 가는지 좌표의 변화를 기록
        Map<Integer, List<int[]>> map = new HashMap<>();
        
        for(int i = 0; i < routes.length; i++){
            
            int[] s = points[routes[i][0] - 1].clone();
            map.putIfAbsent(i, new ArrayList<>());
            map.get(i).add(new int[]{s[0], s[1]});
            
            for(int j = 1; j < routes[i].length; j++){
                int[] d = points[routes[i][j] - 1];
                
                while(s[0] != d[0]){
                    if(s[0] < d[0]) s[0]++;
                    else s[0]--;
                    
                    map.get(i).add(new int[]{s[0], s[1]});
                }
                
                while(s[1] != d[1]){
                    if(s[1] < d[1]) s[1]++;
                    else s[1]--;
                    
                    map.get(i).add(new int[]{s[0], s[1]});
                }
            }
        }
        
        int maxLength = 0;
        
        for(int i : map.keySet()){
            maxLength = Math.max(map.get(i).size(), maxLength);
        }
        
        int answer = 0;
        
        for(int i = 0; i < maxLength; i++){
            Map<String, Integer> count = new HashMap<>();
            
            for(int j : map.keySet()){
                List<int[]> po = map.get(j);
                
                if(po.size() <= i) continue;
                
                int[] cur = po.get(i);
                String p = cur[0] + " " + cur[1];
                
                count.put(p, count.getOrDefault(p, 0) + 1);
            }
            for(int n : count.values()){
                if(n >= 2){
                    answer++;
                }
            }
        }
        
        return answer;
    }
}