
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<int[]> deque = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            int move = Integer.parseInt(st.nextToken());
            deque.addLast(new int[]{i, move});
        }

        while(!deque.isEmpty()) {
            int[] cur = deque.pollFirst();
            int idx = cur[0];
            int move = cur[1];
            sb.append(idx).append(" ");

            if(deque.isEmpty()) break;

            if (move > 0){
                for (int i = 0; i < move-1; i++) {
                    deque.addLast(deque.pollFirst());
                }
            }else{
                for (int i = 0; i < -move; i++) {
                    deque.addFirst(deque.pollLast());
                }
            }

        }

        System.out.println(sb);
    }
}
