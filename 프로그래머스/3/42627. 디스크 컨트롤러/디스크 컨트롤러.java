import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
         // 번호, 요청 시각, 소요 시간을 저장하는 대기 큐가 있음, 처음에는 비어 있음
        // 작업의 소요시간이 짧은 것 -> 작업의 요청 시각이 빠른 것 -> 작업의 번호가 작은 것
        
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        
        int n = 0;
        int time = 0;
        int sum = 0;
        int idx = 0;
        
        
        while(idx < jobs.length){
            
            while(n < jobs.length && jobs[n][0] <= time){
                pq.offer(jobs[n++]);
            }
            
            if(pq.isEmpty()){
                time = jobs[n][0];
                continue;
            }
            
            // 큐에 넣을걸 하니씩 뺌
            idx++;
            int[] q = pq.poll();
            int t1 = time - q[0] + q[1];
            sum += t1;
            time += q[1];
        }
        
        
        return sum / jobs.length;
    }
}