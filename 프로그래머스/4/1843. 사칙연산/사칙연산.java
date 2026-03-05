class Solution {
    public int solution(String arr[]) {
        int numLength = arr.length/2+1;
        int sLength = arr.length/2;
        
        int[] num = new int[numLength];
        char[] op = new char[sLength];
        
        int idx1 = 0;
        int idx2 = 0;
        
        for(int i = 0; i < arr.length; i++){
            if(i%2 == 0) 
                num[idx1++] = Integer.parseInt(arr[i]);
            else 
                op[idx2++] = arr[i].charAt(0);
        }
        
        int[][] max = new int[numLength][numLength];
        int[][] min = new int[numLength][numLength];
        
        for(int i = 0; i < numLength; i++){
            max[i][i] = num[i];
            min[i][i] = num[i];
        }
        
        for(int len = 2; len <= numLength; len++){
            
            for(int i = 0; i+len-1 < numLength; i++){
                int j = i+len-1;
                max[i][j] = Integer.MIN_VALUE;
                min[i][j] = Integer.MAX_VALUE;
                
                for(int k = i; k < j; k++){
                    
                    if(op[k] == '+'){
                        max[i][j] = Math.max(max[i][j], max[i][k] + max[k+1][j]);
                        min[i][j] = Math.min(min[i][j], min[i][k] + min[k+1][j]);
                    }else{
                        max[i][j] = Math.max(max[i][k] - min[k+1][j], max[i][j]);
                        min[i][j] = Math.min(min[i][j], min[i][k]-max[k+1][j]);
                    }
                }
            }
        }
        return max[0][numLength-1];
    }  
        
}