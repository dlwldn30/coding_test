import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        // 유저는 동일한 유저에 대해 신고 횟수 1회로 -> 중복이 있으면 안됨
        // 유저가 신고한 사람이 정지를 먹는 수
        
        // 누가 누굴 신고했다 라는걸 저장해둬야 함. 꼭 다 신고하는건 아님
        // 사람 별 신고받은 횟수도 저장
        
        Set<String> set = new HashSet<>();
        
        Map<String, Integer> reList = new HashMap<>(); // 누가 얼만큼 됐는지
        Map<String, List<String>> whList= new HashMap<>();
        
        int[] answer = new int[id_list.length];
        
        for(int i = 0; i < report.length; i++) 
            set.add(report[i]);
        
        for (String s : set){
            String[] arr = s.split(" ");
            
            reList.put(arr[1], reList.getOrDefault(arr[1], 0) + 1);
            
            whList.putIfAbsent(arr[0], new ArrayList<>());
            whList.get(arr[0]).add(arr[1]);
        }
        
        
        
        for(int i = 0; i < id_list.length; i++){
            String name = id_list[i];
            
            List<String> list = whList.getOrDefault(name, new ArrayList<>());
            
            for(String s : list){
                if(reList.get(s) >= k) answer[i]++;
            }
        }
        
        
        return answer;
    }
}