class Solution {
    public int solution(int[][] sizes) {
        
        int[] height = new int[sizes.length];
        int[] width = new int[sizes.length];
        
        for(int i = 0; i < sizes.length; i++){
            width[i] = Math.max(sizes[i][0], sizes[i][1]);
            height[i] = Math.min(sizes[i][0], sizes[i][1]);
        }
        
        int max = 0;
        int max1 = 0;
        
        for(int i = 0; i < sizes.length; i++){
            max = Math.max(width[i], max);
            max1 = Math.max(height[i], max1);
        }
        
        
        return max * max1;
        
        
    }
}