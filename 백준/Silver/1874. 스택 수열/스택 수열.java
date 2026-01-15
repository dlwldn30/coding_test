
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new ArrayDeque<>();

        int start = 0;

        while (n --> 0) {
            int num = Integer.parseInt(br.readLine());

            if (start < num){ // 더하는 경우
                for (int j = start+1; j <= num; j++){
                    stack.push(j);
                    sb.append('+').append('\n');
                }
                start = num;
            } else if (stack.peek() != num){
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append('-').append('\n');

        }
        System.out.println(sb);
    }
}
