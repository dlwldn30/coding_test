import java.util.*;

class Solution {
    
    int[] rate = {10, 20, 30, 40};
    int[] answer = new int[2];
    
    
    public int[] solution(int[][] users, int[] emoticons) {
        // 할인율부터 정하기
        
        int[] discount = new int[emoticons.length];
        
        dfs(users, emoticons, discount, 0);
        
        return answer;
    }
    
    
    private void dfs(int[][] users, int[] emoticons, int[] discount, int n){
        
        if(n == discount.length){
            int sub = 0;
            int buy = 0;
            
            for(int i = 0; i < users.length; i++){
                int sum = 0;
                for(int j = 0; j < emoticons.length; j++){
                    if(discount[j] < users[i][0]) continue;
                    
                    int money = emoticons[j] * (100-discount[j])/100;
                    sum += money;
                }
                if(sum >= users[i][1])
                    sub++;
                else buy += sum;
            }
            
            if(sub > answer[0]){
                answer[0] = sub;
                answer[1] = buy;
            }else if(sub == answer[0] && buy > answer[1]){
                answer[1] = buy;
            }
            
            return;
        }        
        
        for(int i = 0; i < 4; i++){
            discount[n] = rate[i];
            dfs(users, emoticons, discount, n+1);
        }
    }
}