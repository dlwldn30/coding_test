import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        
        List<int[]> list = new ArrayList<>();
        int answer = 0;
        
        int[][] time = new int[book_time.length][2];
        
        for(int i = 0; i < book_time.length; i++){
            time[i][0] = toTime(book_time[i][0]);
            time[i][1] = toTime(book_time[i][1]) + 10;
        }
        
        Arrays.sort(time, (a,b) -> a[0] - b[0]);
        
        list.add(new int[]{time[0][0], time[0][1]});
        answer++;
    
    
    for(int i = 1; i < book_time.length; i++){
        
        int t1 = time[i][0];
        int t2 = time[i][1];
                                                                                       
        
        boolean b = false;
        
        for(int[] l : list){
            if(l[1] <= t1){
                l[1] = t2;
                b = true;
                break;
            }
        }
        
        if(!b){
            list.add(new int[]{t1, t2});
            answer++;
        }
        
        
        
        
        
    }
        
        
        return answer;
    }
    
    
    
    
    private int toTime(String s){
        String[] t = s.split(":");
        
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
}