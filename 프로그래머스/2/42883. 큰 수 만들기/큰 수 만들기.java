import java.util.*;

class Solution {
    public String solution(String number, int k) {
       int n = number.length();
        char max = number.charAt(0);
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < n; i++){
            char c = number.charAt(i);
            
            while(k > 0 && sb.length() > 0 && sb.charAt(sb.length()-1) < c){
                sb.deleteCharAt(sb.length()-1);
                k--;
            }
            
            sb.append(number.charAt(i));
        }
        
        if(k > 0){
            sb.setLength(sb.length() - k);
        }
        
        return sb.toString();
    }
}