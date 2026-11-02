class Solution {
    public int solution(int n, int w, int num) {
        // 1. w개수 만큼 바닥에 둠
        // 2. 총 N개의 박스를 둠
    
        int d1 = (num-1)/w + 1; // 2
        
        int t1 = (n-1) / w + 1;
        
        int answer = t1 - d1;
        
        int d2 = num - (d1 - 1) * w ;
        int t2 = n - (t1 - 1) * w ;
        
        if(t1%2 != d1%2){
            if(t2 + d2 > w) answer++;
        }else{
            if(t2 >= d2) answer++;
        }
        
        return answer;
    }
}