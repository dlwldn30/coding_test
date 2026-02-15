import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        int result = 1;
        
        for (String[] cloth : clothes){
            String name = cloth[0];
            String type = cloth[1];
            map.put(type, map.getOrDefault(type, 0)+1 );
        }
        
        for (int count : map.values()){
            result *= count+1;
        }
        
        return result-1;
    }
}