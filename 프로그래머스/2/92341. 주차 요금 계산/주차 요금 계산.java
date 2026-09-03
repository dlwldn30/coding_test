import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        Map<String, Integer> totalTime = new HashMap<>();
        Map<String, Integer> totalMoney = new HashMap<>();
        
        for(String s : records){
            String[] arr = s.split(" ");
            int time = toNum(arr[0]);
            
            if(arr[2].equals("IN")){
                totalTime.put(arr[1], totalTime.getOrDefault(arr[1], 0) + time);
            }else{
                totalMoney.put(arr[1], totalMoney.getOrDefault(arr[1], 0) + time - totalTime.get(arr[1]));
                totalTime.remove(arr[1]);
            }
        }
        
        for (String s : totalTime.keySet()){
            totalMoney.put(s, totalMoney.getOrDefault(s, 0) + (23*60+59 - totalTime.get(s)));
        }
        
        // 차량 번호가 작은 순으로??
        
        List<String> cars = new ArrayList<>(totalMoney.keySet());
        
        Collections.sort(cars);
        
        List<Integer> answer = new ArrayList<>();
        
        for(String s : cars){
            int time = totalMoney.get(s);
            if(time <= fees[0]){
                answer.add(fees[1]);
                continue;
            }
            int money = fees[1] + (((totalMoney.get(s) - fees[0] -1)/fees[2]+1)*fees[3]);
            answer.add(money);
        }
        
        return answer.stream().mapToInt(i->i).toArray();

    }
    
    private int toNum(String s){
        String[] arr = s.split(":");
        
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }
}