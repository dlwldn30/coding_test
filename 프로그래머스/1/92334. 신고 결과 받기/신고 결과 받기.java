import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        
        // 1. 한 유저가 동일한 유저에 대해 신고해도 1회임
        // 2. k번 이상이면 정지 그리고 자신이 신고한 사람이 정지됐을때의 수
        
        // 자신이 얼만큼 신고 당했는지, 내가 누굴 신고했는지 그리고 그 사람이 진짜 정지 먹었는지
        
        Set<String> set = new HashSet<>(); // 중복 안되게
        Map<String, Integer> toReport = new HashMap<>(); // 내가 얼만큼 신고 당했는지
        Map<String, List<String>> iReport = new HashMap<>(); // 내가 누굴했는지
        
        for(String r : report) set.add(r);
        
        for(String s : set){
            String[] arr = s.split(" ");
            
            toReport.put(arr[1], toReport.getOrDefault(arr[1], 0) + 1);
            iReport.putIfAbsent(arr[0], new ArrayList<>());
            iReport.get(arr[0]).add(arr[1]);
        }
        
        int[] result = new int[id_list.length];
        
        for(int i = 0; i < id_list.length; i++){
            String s = id_list[i];
            
            List<String> list = iReport.getOrDefault(s, new ArrayList<>());
            
            for(String p : list){
                if(toReport.get(p) >= k) result[i]++;
            }
            
        }
        
        
        return result;
    }
}