import java.util.*;

class Solution {
    
    int[] rate = {10, 20, 30, 40};
    int[] answer = {0,0};
    
    public int[] solution(int[][] users, int[] emoticons) {
         
        // 각 이모티콘에 몇퍼센트를 할건지 정해야 함.
        int[] discount = new int[emoticons.length];
        dfs(users, emoticons, 0, discount);
            
            return answer;
    }
    
    private void dfs(int[][] users, int[] emoticons, int depth, int[] discount){
        
        if(depth == emoticons.length){
            
            int sub = 0;
            int money = 0;
            
            for(int i = 0; i < users.length; i++){ // 사람이 순회
                int sum = 0;
                
                for(int j = 0; j < discount.length; j++){
                    if(users[i][0] > discount[j]) continue;
                    
                    sum += emoticons[j] * (100-discount[j]) / 100;
                }
                if(sum >= users[i][1]) sub++;
                else money += sum;
            }
            
            
            if(sub > answer[0]){
                answer[0] = sub;
                answer[1] = money;
            }else if(sub == answer[0] && money > answer[1]){
                answer[0] = sub;
                answer[1] = money;
            }
            
            return;
        }
        
        
        for(int i = 0; i < 4; i++){
            discount[depth] = rate[i];
            dfs(users, emoticons, depth+1, discount);
        }
    }
}