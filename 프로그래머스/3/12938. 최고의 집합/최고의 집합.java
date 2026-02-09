class Solution {
    public int[] solution(int n, int s) {
        
        // 불가능한 경우
        if (s < n) {
            return new int[]{-1};
        }
        
        int[] answer = new int[n];
        int base = s / n;
        int remain = s % n;

        // 앞쪽은 base
        for (int i = 0; i < n - remain; i++) {
            answer[i] = base;
        }

        // 뒤쪽은 base + 1
        for (int i = n - remain; i < n; i++) {
            answer[i] = base + 1;
        }

        return answer;
    }
}