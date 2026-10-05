import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        

        Arrays.sort(routes, (a,b) -> a[1] - b[1]);
        
        int pres = routes[0][1];
        int answer = 1;
        
        for(int i = 1; i < routes.length; i++){
            int s = routes[i][0];
            int e = routes[i][1];
            if(pres < s || pres > e){
                answer++;
                pres = e;
            }
        }
        
        
        return answer;
    }
}