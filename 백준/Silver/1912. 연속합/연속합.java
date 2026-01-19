import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int[] dp;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N]; // 처음 배열 수
        dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        max = arr[0];
        dp[0] = arr[0];

        int num = findMax(N);

        

        System.out.println(num);

    }

    static int findMax(int N){
        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(arr[i], arr[i] + dp[i - 1]);
            if(dp[i] > max){
                max = dp[i];
            }
        }

        return max;
    }
}
