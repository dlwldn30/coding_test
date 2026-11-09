class Solution {
    public int solution(int n, int[][] results) {
        
        int[][] rank = new int[n+1][n+1];
        
        for(int[] r : results){
            int a = r[0];
            int b = r[1];
            rank[a][b] = 1;
        }
        
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(rank[i][k] == 1 && rank[k][j] == 1)
                        rank[i][j] = 1;
                }
            }
        }
        
        int answer = 0;
        
        for(int i = 1; i <= n; i++){
            int sum = 0;
            for(int j = 1; j <= n; j++){
                if(rank[i][j] == 1 || rank[j][i] == 1) sum++;
            }
            if(sum == n-1) answer++;
        }
        
        return answer;
    }
}