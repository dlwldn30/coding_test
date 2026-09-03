import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        
        // 구명보트를 최대한 적게 사용해서 모든 사람 구출
        // 한번에 최대 2명, 무게 제한 초과면 안됨
        
        int count = 0;
        
        Arrays.sort(people);
        
        int i = 0;
        int j = people.length - 1;
        
        while(i <= j){
            if(people[i] + people[j] <= limit){
                i++;
            }
            j--;
            count++;
        }
        
        return count;
    }
}