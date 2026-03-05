import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        
        int n = 1;
        Map<Integer, int[]> map = new HashMap<>();
        
        int[] left = new int[]{3,0};
        int[] right = new int[]{3,2};
        
        //핸드포 설정
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                map.put(n, new int[]{i,j});
                n++;
            }
        }
        
        map.put(0, new int[]{3,1});
        
        for(int num : numbers){
            int[] cur = map.get(num);
            
            if(cur[1] == 0){
                sb.append("L");
                left[0] = cur[0];
                left[1] = cur[1];
            }
            else if (cur[1] == 2){
                sb.append("R");
                right[0] = cur[0];
                right[1] = cur[1];
            }else{
            
            int ld = Math.abs(left[0] - cur[0]) + Math.abs(left[1] - cur[1]);
            int rd = Math.abs(right[0] - cur[0]) + Math.abs(right[1] - cur[1]);
            
            //오른손이 가까움
            if(ld > rd || (ld == rd && hand.equals("right"))){
                sb.append("R");
                right[0] = cur[0];
                right[1] = cur[1];
            }else if(ld < rd || (ld == rd && hand.equals("left"))){
                sb.append("L");
                left[0] = cur[0];
                left[1] = cur[1];
            }
            }
        }
        
        
        
        
        
        
        
        
        return sb.toString();
    }
}