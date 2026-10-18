import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        
        int n = sequence.length;
        
        long[] arr1 = new long[n];
        long[] arr2 = new long[n];
        
        for(int i = 0; i < n; i++){
            if(i%2 == 0){
                arr1[i] = sequence[i];
                arr2[i] = -sequence[i];
            }else{
                arr1[i] = -sequence[i];
                arr2[i] = sequence[i];
            }
        }
        
        return Math.max(findMax(arr1, n), findMax(arr2, n));
    }
    
    private long findMax(long[] arr, int n){
        
        long max = 0;
        long result = 0;
        
        for(int i = 0; i < n; i++){
            max = Math.max(max+arr[i], arr[i]);
            result = Math.max(result, max);
        }
        
        return result;
    }
}