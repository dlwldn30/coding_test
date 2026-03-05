import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        
        int len = board.length;
        int count = 0;
        
        Stack<Integer> q = new Stack<>();
        
        for(int m : moves){
            for(int i = 0; i < len; i++){
                if(board[i][m-1] == 0)
                    continue;
                if(!q.isEmpty() && q.peek() == board[i][m-1]){
                        count+=2;
                        q.pop();
                    }else{
                        q.push(board[i][m-1]);
                    }
                    board[i][m-1] = 0;
                    break;
                }
                
            }
        return count;
        }
        
        
    }
