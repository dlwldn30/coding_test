import java.util.*;

class Solution {
    public long solution(String expression) {
        
        String[][] priority = {
            {"+", "-", "*"},
            {"+", "*", "-"},
            {"-", "+", "*"},
            {"-", "*", "+"},
            {"*", "+", "-"},
            {"*", "-", "+"}
        };
        
        List<Long> number = new ArrayList<>();
        List<String> op = new ArrayList<>();
        
        String num = "";
        
        for(int i = 0; i < expression.length(); i++){
            char c = expression.charAt(i);
            
            if(Character.isDigit(c)){
                num += c;
            }else{
                op.add(String.valueOf(c));
                number.add(Long.parseLong(num));
                num = "";
            }
        }
        
        number.add(Long.parseLong(num));
        
        long max = 0;
        
        for(int i = 0; i < 6; i++){
            
            List<Long> copyLong = new ArrayList<>(number);
            List<String> copyOp = new ArrayList<>(op);
            
            for(int j = 0; j < 3; j++){
                
                String target = priority[i][j];
                
                for(int k = 0; k < copyOp.size();){
                    
                    if(copyOp.get(k).equals(target)){
                        
                        long a = copyLong.get(k);
                        long b = copyLong.get(k+1);
                        
                        long result = 0;
                        
                        if(target.equals("*")){
                            result = a*b;
                        }else if(target.equals("+")){
                            result = a+b;
                        }else{
                            result = a-b;
                        }
                        
                        
                        copyLong.set(k, result);
                        copyLong.remove(k+1);
                        copyOp.remove(k);
                    }
                    else{
                        k++;
                    }
                }
            }
            
            long answer = Math.abs(copyLong.get(0));
            max = Math.max(max, answer);
        }
        
        
        return max;
    }
                       
}