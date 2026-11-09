import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        Map<String, Integer> map = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        
        for(String s : terms){
            String[] arr = s.split(" ");
            map.put(arr[0], map.getOrDefault(arr[0], 0) + Integer.parseInt(arr[1]) * 28);
        }
        
        int pre = toNum(today);
        
        for(int i = 0; i < privacies.length; i++){
            String[] arr = privacies[i].split(" ");
            int num = toNum(arr[0]);
            num += map.get(arr[1]);
            
            if(pre >= num) answer.add(i+1);
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
    
    private int toNum(String s){
        String[] arr = s.split("\\.");
        
        return Integer.parseInt(arr[0]) * 12 * 28 + Integer.parseInt(arr[1]) * 28 + Integer.parseInt(arr[2]);
    }
}