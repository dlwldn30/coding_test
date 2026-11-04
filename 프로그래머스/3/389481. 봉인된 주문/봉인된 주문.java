import java.util.*;

class Solution {
    public String solution(long n, String[] bans) {
        // 먼저 각 숫자가 몇번째인지 확인 후 정수 배열로 
        // 입력받은 정수를 나눗셈하면서 알파벳 구하기
        // 사전보다 앞에 있는 놈들 만큼 더하기
        
        long[] intBans = new long[bans.length];
        StringBuilder answer = new StringBuilder();
        
        // 정수 배열로 치환
        for(int i = 0; i < bans.length; i++){
            String s = bans[i];
            long loc = 0;
            long op = 1;
            for(int j = s.length()-1; j >= 0; j--){
                char c = s.charAt(j);
                int num = c - 'a' + 1;
                loc += num * op;
                op *= 26;
            }
            
            intBans[i] = loc;
        }
        
        Arrays.sort(intBans);
        
        for(long b : intBans){
            if(n < b) break;
            n++;
        }
        
        while(n != 0){
            n--;
            long a = n % 26;
            char c = (char)('a' + a);
            answer.append(c);
            
            n/=26;
        }
        
        return answer.reverse().toString();
    }
}