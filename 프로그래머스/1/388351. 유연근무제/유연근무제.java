class Solution {
    
    int result = 0;
    
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        
        
        
        for(int i = 0; i < schedules.length; i++){
            findResult(schedules[i], timelogs[i], startday);
        }
        
        
        return result;
    }
    
    private void findResult(int sch, int[] time, int day){
        
        
        boolean good = true;
            
        sch += 10;
        
        if(sch%100 >= 60){
            sch += 40;
        }
        
        
        
        for(int i = 0; i < time.length; i++){
            if(day%7 == 0 || day % 7 == 6){
                day++;
                continue;
            }
            
            if(time[i] > sch){
                good = false;
                break;
            }
            
            
            day++;
        }
        
        if(good) result++;
        
  
        
    }
    
}