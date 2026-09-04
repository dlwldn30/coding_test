import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> totalTime = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        
        for(int i = 0; i < records.length; i++){
            String[] arr = records[i].split(" ");
            int num = toNum(arr[0]);
            
            if(arr[2].equals("IN")){
                map.put(arr[1], map.getOrDefault(arr[1], 0) + num);
            }else{
                totalTime.put(arr[1], totalTime.getOrDefault(arr[1], 0) + num - map.get(arr[1]));
                map.remove(arr[1]);
            }
        }
        
        for(String s : map.keySet()){
            int n = toNum("23:59") - map.get(s);
            totalTime.put(s, totalTime.getOrDefault(s, 0) + n);
        }
        
        //이제 문자열로 정렬해야함
        List<String> name = new ArrayList<>(totalTime.keySet());
        List<Integer> cars = new ArrayList<>();
        
        Collections.sort(name);
        
        for(String s : name){
            int time = totalTime.get(s) - fees[0];
            int money = 0;
            
            if(time <=0) money += fees[1];
            else{
                money += fees[1] + ((time - 1) / fees[2] + 1) * fees[3];
            }
            
            cars.add(money);   
        }
        
        
        
        return cars.stream().mapToInt(i->i).toArray();
    }
    
    
    private int toNum(String s){
        String[] arr = s.split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }
}