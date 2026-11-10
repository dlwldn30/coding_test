import java.util.*;

class Solution {
    
    int[] rate = {10, 20, 30, 40};
    int[] answer = {0,0};
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        int[] discount = new int[emoticons.length];
        
        dfs(users, emoticons, discount, 0); 
        
        return answer;
    }
    
    private void dfs(int[][] users, int[] emoticons, int[] discount, int cur){
        
        if(cur == emoticons.length){
            int plus = 0;
            int money = 0;
            
            for(int i = 0; i < users.length; i++){
                int userDiscount = users[i][0];
                int num = 0;
                
                for(int j = 0; j < cur; j++){
                    if(discount[j] < userDiscount) continue;
                    
                    num += emoticons[j] * (100-discount[j]) / 100;
                }
                if(num >= users[i][1]){
                    plus++;
                }else{
                    money += num;
                }
            }
            
            if(answer[0] < plus){
                answer[0] = plus;
                answer[1] = money;
            }else if(answer[0] == plus && answer[1] < money){
                answer[1] = money;
            }
            
            return ;
        }
        
        
        
        for(int i = 0; i < 4; i++){
            discount[cur] = rate[i];
            dfs(users, emoticons, discount, cur+1);
        }
        
    }
}