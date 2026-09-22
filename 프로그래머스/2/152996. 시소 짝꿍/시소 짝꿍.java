import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;

        // 작은 몸무게부터 처리하기 위해 정렬
        Arrays.sort(weights);

        // 몸무게별 지금까지 등장한 사람 수
        Map<Integer, Integer> map = new HashMap<>();

        for (int w : weights) {

            // 1 : 1
            answer += map.getOrDefault(w, 0);

            // 2 : 1
            if (w % 2 == 0)
                answer += map.getOrDefault(w / 2, 0);

            // 3 : 2
            if (w * 2 % 3 == 0)
                answer += map.getOrDefault(w * 2 / 3, 0);

            // 4 : 3
            if (w * 3 % 4 == 0)
                answer += map.getOrDefault(w * 3 / 4, 0);

            // 현재 몸무게 저장
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        return answer;
    }
}