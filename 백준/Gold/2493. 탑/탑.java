
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
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        Deque<int[]> stack = new ArrayDeque<>();


        for (int i = 1; i <= N; i++) {
            int top = Integer.parseInt(st.nextToken());

            // 송신이 가능할 경우
            while(!stack.isEmpty() && stack.peek()[1] < top) {
                stack.pop();
            }

            if(stack.isEmpty()){
                sb.append("0 ");
            } else{
              sb.append(stack.peek()[0]).append(" ");
            }

            stack.push(new int[]{i, top});

        }

        System.out.println(sb.toString());
    }
}
