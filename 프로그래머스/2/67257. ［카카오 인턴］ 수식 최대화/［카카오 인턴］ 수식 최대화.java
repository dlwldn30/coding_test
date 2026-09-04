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
        
        int n = expression.length();
        String num = "";
        long answer = 0;
        
        List<String> op = new ArrayList<>();
        List<Long> number = new ArrayList<>();
        
        // 문자열 파싱
        for(int i = 0; i < n; i++){
            char c = expression.charAt(i);
            
            if(Character.isDigit(c)){
                num += c;
            }else{
                op.add(String.valueOf(c));
                number.add(Long.parseLong(num));
                num = "";
            }
        }
        
        // 마지막 숫자
        number.add(Long.parseLong(num));
        
        // 6가지 우선순위
        for(int i = 0; i < 6; i++){
            
            // 원본을 훼손하면 다음 우선순위를 계산할 수 없으므로 복사
            List<String> copyOp = new ArrayList<>(op);
            List<Long> numCopy = new ArrayList<>(number);
            
            for(int j = 0; j < 3; j++){
                
                for(int k = 0; k < copyOp.size();){
                    
                    if(copyOp.get(k).equals(priority[i][j])){
                        
                        long a = numCopy.get(k);
                        long b = numCopy.get(k + 1);
                        long sum;
                        
                        if(priority[i][j].equals("+")){
                            sum = a + b;
                        }else if(priority[i][j].equals("-")){
                            sum = a - b;
                        }else{
                            sum = a * b;
                        }
                        
                        // a op b → 계산 결과 하나로 합침
                        copyOp.remove(k);
                        numCopy.set(k, sum);
                        numCopy.remove(k + 1);
                        
                        // k++ 하지 않음
                        // remove로 다음 연산자가 현재 k 자리로 당겨졌기 때문
                        
                    }else{
                        k++;
                    }
                }
            }
            
            answer = Math.max(answer, Math.abs(numCopy.get(0)));
        }
        
        return answer;
    }
}