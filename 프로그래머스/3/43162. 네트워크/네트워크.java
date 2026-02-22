class Solution {
    
    int[] parent;
    
    public int solution(int n, int[][] computers) {
        
        parent = new int[n];
        
        int count = 0;
        
        for (int i = 0; i < n; i++){
            parent[i] = i;
        }
        
        for (int i = 0; i < n; i++){
            for (int j = i+1; j < n; j++){
                if(computers[i][j] == 1){
                    union(i, j);
                }
            }
        }
        
        for (int i = 0; i < n; i++){
            if(parent[i] == i)
                count++;
        }
        
        return count;
    }
    
    public int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    public void union(int x, int y){
        x = find(x);
        y = find(y);
        
        if(x == y) 
            return;
        
        parent[y] = x;
        return ;
    }
}