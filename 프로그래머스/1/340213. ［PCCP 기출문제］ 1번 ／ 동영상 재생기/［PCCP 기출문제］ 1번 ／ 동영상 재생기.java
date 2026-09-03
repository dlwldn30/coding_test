import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        // 1. prev인 경우 10초 전으로 이동 0보다 작으면 0으로
        // 2. next인 경우 10초 후로 최대보다 크면 그냥 최대로
        // 3. 오프닝 구간에 있을 경우 오프닝 끝으로
        
        int len = toNum(video_len);
        int pn = toNum(pos);
        int osn = toNum(op_start);
        int oen = toNum(op_end);
        
        if(pn <= oen && pn >= osn) pn = oen;
        
        for(String s : commands){
            
            if(s.equals("next")){
                pn += 10;
                if(pn >= len) pn = len;
            }else{
                pn -= 10;
                if(pn < 0) pn = 0;
            }
            
            if(pn <= oen && pn >= osn) pn = oen;
        }
        
        int m = pn / 60;
        int s = pn % 60;
        
        return String.format("%02d:%02d", m, s);
        
    }
    
    private int toNum(String s){
        String[] arr = s.split(":");
        
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }
}