import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int n = cards.length;
        boolean[] visited = new boolean[n];
        List<Integer> cycles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int count = 0;
                int cur = i;

                while (!visited[cur]) {
                    visited[cur] = true;
                    cur = cards[cur] - 1; // 카드 번호는 1-based
                    count++;
                }

                cycles.add(count);
            }
        }

        if (cycles.size() < 2) return 0;

        Collections.sort(cycles, Collections.reverseOrder());
        return cycles.get(0) * cycles.get(1);
    }
}