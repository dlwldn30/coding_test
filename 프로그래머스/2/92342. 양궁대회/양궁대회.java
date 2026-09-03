import java.util.*;

class Solution {
    
    int max = 0;
    int[] answer = {-1};
    
    public int[] solution(int n, int[] info) {
        
        int[] lion = new int[11];
        
        int used = 0;
        
        
        dfs(info, lion, 0, used, n);
        
        return answer;
    }
    
    
    private void dfs(int[] info, int[] lion, int idx, int used, int n){
        
        
        if(idx == 10){
            if(used < n){
                lion[10] += n-used;
            }
            
            int l = 0;
            int a = 0;
            
            for(int i = 0; i < 11; i++){
                if(lion[i] == 0 && info[i] == 0) continue;
                
                if(lion[i] > info[i]) l += 10-i;
                else a += 10-i;
            }
            
           int diff = l-a;
            
            
            if(diff > 0){
                if(max < diff){
                    max = diff;
                    answer = lion.clone();
                }else if(max == diff){
                    for(int i = 10; i >= 0; i--){
                        if(answer[i] < lion[i]){
                            answer = lion.clone();
                            break;
                        }
                        if(lion[i] < answer[i]){
                            break;
                        }
                    }
                }
            }
             lion[10] = 0;
            return;
        }
        
        int need = info[idx]+1;
        
        if(need + used <= n){
            lion[idx] = need;
            dfs(info, lion, idx+1, used+need, n);
            lion[idx] = 0;
        }
        
        dfs(info, lion, idx+1, used, n);
        
        
        
    }
}