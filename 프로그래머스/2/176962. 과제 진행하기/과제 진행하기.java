import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        
        Arrays.sort(plans, (a,b) -> toNum(a[1]) - toNum(b[1]));
        
        String[] answer = new String[plans.length];
        
        Deque<String[]> dq = new ArrayDeque<>();
        int idx = 0;
        
        for(int i = 0; i < plans.length; i++){
            String[] plan = plans[i];
            
            dq.push(new String[]{plan[0], plan[2]});
            
            if(i == plans.length-1) break;
            
            int available = toNum(plans[i+1][1]) - toNum(plan[1]);
            
            while(available > 0 && !dq.isEmpty()) {
                String[] cur = dq.peek();
                int curTime = Integer.parseInt(cur[1]);
                
                if(curTime > available){
                    cur[1] = String.valueOf(curTime - available);
                    break;
                }
                
                available -= curTime;
                answer[idx++] = dq.pop()[0];
            }
        }
        
        while(!dq.isEmpty()){
            answer[idx++] = dq.pop()[0];
        }
        
        return answer;
    }

    private int toNum(String s){
        String[] arr = s.split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }
}