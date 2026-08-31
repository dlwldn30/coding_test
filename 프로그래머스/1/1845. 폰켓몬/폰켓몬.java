import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        
        int size = set.size();
        
        return Math.min(nums.length/2, size);
    }
}