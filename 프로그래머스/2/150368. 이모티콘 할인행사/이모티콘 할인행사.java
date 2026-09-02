class Solution {
    
    int[] discount = {10, 20, 30 ,40};
    int r1 = 0;
    int r2 = 0;
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        // 이모티콘마다 할인율을 다르게 함, 구독을 제일 오래하는 거 도출
        
        int[] sale = new int[emoticons.length];
        int n =0;
        
        dfs(users, emoticons, sale, n);
        
        return new int[]{r1, r2};
    }
    
    
    private void dfs(int[][] users, int[] emoticons, int[] sale, int n){
        
        
        if(n == emoticons.length){
            int n1 = 0;
            int n2 = 0;
            
            for(int i = 0; i < users.length; i++){
                int d1 = users[i][0];
                int m1 = users[i][1];
                
                int sum = 0;
                
                for(int j = 0; j < emoticons.length; j++){
                    if(sale[j] < d1) continue;
                    
                    sum += emoticons[j] * (100-sale[j]) /100;
                }
                if(sum >= m1){
                    n1++;
                }else{
                    n2 += sum;
                }
                
            }
            
            if(n1>r1){
                r1 = n1;
                r2 = n2;
            }else if(n1 == r1 && n2 > r2){
                r2 = n2;
            }
            
            return;
        }
        
        for(int i =0 ; i < discount.length; i++){
            sale[n] = discount[i];
            dfs(users, emoticons, sale, n+1);
        }
    }
}