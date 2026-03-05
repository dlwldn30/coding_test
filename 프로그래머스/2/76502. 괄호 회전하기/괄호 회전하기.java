import java.util.*;


class Solution {
    public int solution(String s) {
        
        int n = s.length();
        int answer = 0;
        
        for(int i = 0; i < n; i++){
            String rotated = s.substring(i) + s.substring(0, i);
            
            if(isValid(rotated)) answer++;
        }
        
        return answer;
    }
    
    
    private boolean isValid(String rotated){
        
        Stack<Character> stack = new Stack<>();
        
        for(char c : rotated.toCharArray()){
            if(c == '{' || c == '(' || c == '[')
                stack.push(c);
            else{
                if(stack.isEmpty()) return false;
                
                char top = stack.pop();
                if(c == ')' && top != '(') return false;
                if(c == ']' && top != '[') return false;
                if(c == '}' && top != '{') return false;
            }
        }
        
        
        return stack.isEmpty();
    }
    
    
}