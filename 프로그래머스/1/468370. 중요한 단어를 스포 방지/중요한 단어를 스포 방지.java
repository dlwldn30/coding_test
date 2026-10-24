import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int answer = 0;
        
        List<String> notIm = new ArrayList<>();
        List<String> im = new ArrayList<>();
        
        int len = message.length();
        int start = 0;
        String st = "";
        
        for(int i = 0; i < len; i++){
            char c = message.charAt(i);
            if(c == ' ' || i == len-1){
                if(i == len-1)
                    st += c;
                boolean isIm = false;
                for(int k = start; k < i; k++){
                    for(int j = 0; j < spoiler_ranges.length; j++){
                        if(spoiler_ranges[j][0] <= k && spoiler_ranges[j][1] >= k){
                            im.add(st);
                            isIm = true;
                            break;
                        }
                    }
                    if(isIm) break;
                }
                if(!isIm) notIm.add(st);
                st = "";
                start = i+1;
                
                continue;
            }
            st+=c;
            
        }
        
        for(String s : im){
            System.out.println(s);
            if(!notIm.contains(s)){
                answer++;
                notIm.add(s);
            }
        }
        
        return answer;
    }
}