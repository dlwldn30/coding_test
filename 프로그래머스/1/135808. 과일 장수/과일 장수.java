import java.util.Arrays;


class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        Arrays.sort(score);
        
        for (int i = score.length-1; i>=m-1; i -= m){
            int minscore = score[i-m+1];
            answer += minscore * m;
        }https://school.programmers.co.kr/learn/courses/30/lessons/135808#
        
        return answer;
    }
    
}