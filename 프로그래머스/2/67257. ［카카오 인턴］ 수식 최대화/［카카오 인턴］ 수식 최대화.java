import java.util.*;

class Solution {
    
    String[][] priority = {
            {"+", "-", "*"}, 
            {"+", "*", "-"},
            {"*", "+", "-"},
            {"*", "-", "+"},
            {"-", "*", "+"},
            {"-", "+", "*"}
        };
    
    public long solution(String expression) {
        
        List<String> op = new ArrayList<>();
        List<Long> numbers = new ArrayList<>();
        long max = 0;
        String num = "";
        
        for(int i = 0; i < expression.length(); i++){
            
            
            
            char c = expression.charAt(i);
            if(Character.isDigit(c)){
                num+=c;
            }else{
                op.add(String.valueOf(c));
                numbers.add(Long.parseLong(num));
                num = "";
            }
        }
        
        numbers.add(Long.parseLong(num));
        
        for(int i = 0; i < 6; i++){
            
            List<Long> copyNumbers = new ArrayList<>(numbers);
            List<String> copyOp = new ArrayList<>(op);
            
            for(int j = 0; j < 3; j++){
                String s = priority[i][j];
                
                for(int k = 0; k < copyOp.size();){
                    if(copyOp.get(k).equals(s)){
                        long n1 = copyNumbers.get(k);
                        long n2 = copyNumbers.get(k+1);
                        
                        long result = 0;
                        
                        if(s.equals("+")){
                            result = n1 + n2;
                        }else if(s.equals("*")){
                            result = n1*n2;
                        }else{
                            result = n1-n2;
                        }
                        
                        copyNumbers.set(k, result);
                        copyNumbers.remove(k+1);
                        copyOp.remove(k);
                    }
                    else{
                        k++;
                    }
                }
            }
            long answer = Math.abs(copyNumbers.get(0));
            max = Math.max(max, answer);
        }
            
        return max;
    }
}