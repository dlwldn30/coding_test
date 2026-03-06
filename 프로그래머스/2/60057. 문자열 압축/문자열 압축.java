class Solution {
    public int solution(String s) {
        int n = s.length();
        int answer = n;
        
        for(int size = 1; size <= n/2; size++){
            StringBuilder sb = new StringBuilder();
            String prev = s.substring(0, size);
            int count = 1;
            
            int i;
            for(i = size; i + size <= n; i += size){
                String cur = s.substring(i, i + size);
                
                if(prev.equals(cur)){
                    count++;
                } else {
                    if(count > 1) sb.append(count);
                    sb.append(prev);
                    prev = cur;
                    count = 1;
                }
            }
            
            if(count > 1) sb.append(count);
            sb.append(prev);
            
            if(i < n) sb.append(s.substring(i));
            
            answer = Math.min(answer, sb.length());
        }
        
        return answer;
    }
}