class Solution {
    public int solution(int[][] triangle) {
        
        int length = triangle.length;
        
        int[] sum = new int[length];
        
        for (int i = 0; i < length; i++)
            sum[i] = triangle[length-1][i];
        
        
        //맨 끝
        for (int i = length-2; i >= 0; i--){
            
            // sum 배열
            for (int j = 0; j <= i; j++){
                sum[j] = triangle[i][j] + Math.max(sum[j], sum[j+1]);
            }
        }
        
        
        return sum[0];
    }
}