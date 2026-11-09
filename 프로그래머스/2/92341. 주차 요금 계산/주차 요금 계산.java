import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> totalTime = new HashMap<>();
        
        for(int i = 0; i < records.length; i++){
            String[] arr = records[i].split(" ");
            
            if(arr[2].equals("IN")){
                map.put(arr[1], map.getOrDefault(arr[1], 0) + toNum(arr[0]));
            }else{
                totalTime.put(arr[1], totalTime.getOrDefault(arr[1], 0) + toNum(arr[0]) - map.get(arr[1]));
                map.remove(arr[1]);
            }
        }
        
        for(String s : map.keySet()){
            totalTime.put(s, totalTime.getOrDefault(s, 0) + toNum("23:59") - map.get(s));
        }
        
        List<String> list = new ArrayList<>(totalTime.keySet());
        List<Integer> answer = new ArrayList<>();
        Collections.sort(list);
        
        for(String s : list){
            int time = totalTime.get(s);
            int money = fees[1];
            
            time -= fees[0];
            
            if(time > 0){
                int extra = (time + fees[2]-1) / fees[2];
                money += extra * fees[3];
            }
            answer.add(money);
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
    
    private int toNum(String s){
        String[] arr = s.split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }
}