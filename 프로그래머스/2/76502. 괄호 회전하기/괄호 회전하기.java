import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int n = s.length();
        
        for(int i = 0; i < n; i++){
            String rotated = s.substring(i) + s.substring(0, i);
            
            if(isValid(rotated)) answer++;
        }
        
        return answer;
    }
    
    private boolean isValid(String s){
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '(')
                stack.push(s.charAt(i));
            else{
                if(stack.isEmpty()) return false;
                
                char top = stack.pop();
                if(s.charAt(i) == ')' && top != '(') return false;
                if(s.charAt(i) == ']' && top != '[') return false;
                if(s.charAt(i) == '}' && top != '{') return false;
            }
                
        }
        return stack.isEmpty();
    }
}