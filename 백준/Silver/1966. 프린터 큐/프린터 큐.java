
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int findMax(Deque<int[]> arr){
        int max = 0;
        for (int[] arr1 : arr) {
            max = Math.max(max, arr1[1]);
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {

            Deque<int[]> deque = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int priority = Integer.parseInt(st.nextToken());
                deque.addLast(new int[]{j, priority});
            }

            int count = 0;

            while (!deque.isEmpty()) {
                int max = findMax(deque);
                int[] cur = deque.pollFirst();
                if(cur[1] == max){
                    count++;
                    if(m == cur[0]) {
                        break;
                    }
                }else{
                    deque.addLast(cur);
                }
            }

            System.out.println(count);
        }
    }
}
