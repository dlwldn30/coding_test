class Solution {
    
    private int toSec(String s){
        String[] p = s.split(":");
        return Integer.parseInt(p[0])*60 + Integer.parseInt(p[1]);
    }
    
    private String toTime(int n){
        int t = n/60;
        int s = n%60;
        
        return String.format("%02d:%02d", t, s);
    }
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        int v = toSec(video_len);
        int p = toSec(pos);
        int s = toSec(op_start);
        int e = toSec(op_end);
        
        if(p >= s && p <= e) p = e;
        
        for(String st : commands){
           
            if(st.equals("next")){
                if(p+10 >= v) p = v;
                else p += 10;
            }else{
                if(p-10 <= 0) p = 0;
                    else p -= 10;
            }
             if(p >= s && p <= e) p = e;
        }
        
        return toTime(p);
        
        
    }
}