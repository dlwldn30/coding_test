import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < 10; i++){
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
        }
        
        int n = 0;
        
        for(int i = 10; i <= discount.length; i++){
            
            boolean result = true;
            int sum = 0;
            
            for(int j = 0; j < want.length; j++){
                if(map.getOrDefault(want[j], 0) == number[j]){
                    sum++;
                }
            }
            
            if(sum == want.length) answer++;
            
            if(i == discount.length) break;
            
            map.put(discount[n], map.getOrDefault(discount[n], 0) - 1);
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
            n++;   
        }
        
        
        
        
        
        return answer;
    }
}