class Solution {
    public int solution(String word) {
        int length = word.length();
        
        String vowle = "AEIOU";
        int[] weight = {781, 156, 31, 6, 1};
        
        int answer = 0;
        
        for (int i = 0; i < length; i++){
            int index = vowle.indexOf(word.charAt(i));
            answer += index * weight[i] + 1;
        }
        
        return answer;
    }
}