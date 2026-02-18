class Solution {
    public int solution(int[][] sizes) {
        
        int max = 0;
        int min = 0;
        
        int[] height = new int[sizes.length];
        int[] length1 = new int[sizes.length];
        
        for (int i = 0; i < sizes.length; i++){
            height[i] = Math.max(sizes[i][0], sizes[i][1]);
            length1[i] = Math.min(sizes[i][0], sizes[i][1]);
        }
        
        for (int i = 0; i < sizes.length; i++){
            max = Math.max(height[i], max);
            min = Math.max(length1[i], min);
        }
        
        return max * min;
        
        
        
        
    }
}