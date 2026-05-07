class Solution {
    public int solution(int[][] sizes) {
        
        int max = 0;
        int min = 0;
        
        for(int[] size : sizes){
            int n1 = Math.max(size[0], size[1]);
            int n2 = Math.min(size[0], size[1]);
            
            max = Math.max(max, n1);
            min = Math.max(min, n2);
        }
        
        return max * min;
        
        
    }
}