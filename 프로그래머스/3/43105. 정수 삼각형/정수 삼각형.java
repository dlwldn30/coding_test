class Solution {
    public int solution(int[][] triangle) {
        int[] result = new int[triangle.length];
        
        int n = triangle.length;
        
        for(int i = 0; i < n; i++){
            result[i] = triangle[n-1][i];
        }
        
        for(int i = n-2; i >= 0; i--){
            for(int j = 0; j < i+1; j++){
                result[j] = Math.max(result[j], result[j+1]) + triangle[i][j];
            }
        }
        
        return result[0];
    }
}