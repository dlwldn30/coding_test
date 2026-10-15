class Solution {
    public int solution(int n, int[][] results) {
        
        boolean[][] match = new boolean[n+1][n+1];
        
        for(int i = 0; i < results.length; i++){
            int a = results[i][0];
            int b = results[i][1];
            
            match[a][b] = true;
        }
        
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(match[i][k] && match[k][j])
                        match[i][j] = true;
                }
            }
        }
        
        int answer = 0;
        
        for(int i = 1; i <= n; i++){
            boolean b = true;
            for(int j = 1; j <= n; j++){
                if(i == j) continue;
                if(!match[i][j] && !match[j][i]){
                    b = false;
                    break;
                }
            }
            if(b) answer++;
        }
        return answer;
    }
}