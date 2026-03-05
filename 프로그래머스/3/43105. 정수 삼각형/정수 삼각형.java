class Solution {
    public int solution(int[][] triangle) {
        int length = triangle.length;
        
        int[] result = new int[length];
        
        for(int i = 0; i < length; i++) result[i] = triangle[length-1][i];
        
        for(int i = length-2; i >=0; i--){
            for(int j = 0; j < i+1; j++){
                result[j] = triangle[i][j]+Math.max(result[j], result[j+1]);
            }
        }
        
        return result[0];
    }
}