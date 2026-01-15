import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int M = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> left =
                    new PriorityQueue<>(Collections.reverseOrder()); // MaxHeap
            PriorityQueue<Integer> right =
                    new PriorityQueue<>(); // MinHeap

            int count = 0;
            out.append((M + 1) / 2).append('\n');

            StringTokenizer st = null;

            for (int i = 0; i < M; i++) {
                if (i % 10 == 0) {
                    st = new StringTokenizer(br.readLine());
                }

                int x = Integer.parseInt(st.nextToken());

                if (left.isEmpty() || x <= left.peek()) {
                    left.offer(x);
                } else {
                    right.offer(x);
                }

                if (left.size() > right.size() + 1) {
                    right.offer(left.poll());
                } else if (right.size() > left.size()) {
                    left.offer(right.poll());
                }

                if (i % 2 == 0) { // 홀수 번째 입력
                    out.append(left.peek()).append(' ');
                    count++;
                    if (count % 10 == 0) out.append('\n');
                }
            }
            out.append('\n');
        }

        System.out.print(out);
    }
}