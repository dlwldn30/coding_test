class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        int c = Math.max(wallet[0], wallet[1]);
        int d = Math.min(wallet[0], wallet[1]);
        
        while(true){
            int a = Math.max(bill[0], bill[1]);
            int b = Math.min(bill[0], bill[1]);
            
            
            if(a <= c && b <= d)
                break;
            
            bill[0] = a/2;
            bill[1] = b;
            answer++;
            
        }
        
        
        
        
        return answer;
    }
}