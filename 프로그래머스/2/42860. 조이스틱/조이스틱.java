class Solution {
    public int solution(String name) {
    
        int length = name.length();
        int count = 0;
        
        
        for(int i = 0; i < name.length(); i++){
            char c = name.charAt(i);
            count += Math.min(c-'A', 'Z'-c+1);
            
        }
        
        int min = length-1;
        
        for (int i = 0; i < name.length(); i++){
            int n = i+1 ;
            while(n < length && name.charAt(n) == 'A')
                n++;
            
            int min1 = Math.min((2*i+(length-n)), (2*(length-n) + i));
            min = Math.min(min, min1);
        }
        
        return min + count;
    }
}