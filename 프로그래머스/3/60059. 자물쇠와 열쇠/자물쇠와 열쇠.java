class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int n = lock.length;
        int m = key.length;
        int[][] map = new int[n*3][n*3];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                map[i+n][j+n] = lock[i][j];
            }
        }
        
        for(int k = 0; k < 4; k++){
            for(int i = 0; i < 2 * n; i++){
                for(int j = 0; j < 2*n; j++){
                    for(int x = 0; x < m; x++){
                        for(int y = 0; y < m; y++){
                            map[i+x][j+y] += key[x][y];
                        }
                    }
                    
                    if(check(map, n))
                        return true;
                    
                    for(int x = 0; x < m; x++){
                        for(int y = 0; y < m; y++){
                            map[i+x][j+y] -= key[x][y];
                        }
                    }
                }
            }
            key = rotate(key, m);
            
        }
        
        return false;
    }
    
    private boolean check(int[][] map, int n){
        for(int i = n; i < 2*n; i++){
            for(int j = n; j < 2*n; j++){
                if(map[i][j] != 1)
                    return false;
            }
        }
        
        return true;
    }
    
    private int[][] rotate(int[][] key, int m){
        int[][] r = new int[m][m];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < m; j++){
                r[i][j] = key[j][m-1-i];
            }
        }
        
        return r;
    }
}