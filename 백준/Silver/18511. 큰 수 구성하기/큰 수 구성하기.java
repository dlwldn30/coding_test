
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[] num;
    static int max = 0;
    static int answer = 0;

    public static void dfs(int[] num, int max){
        if(max > N ){
            return ;
        }

        answer = Math.max(answer, max);

        for (int i = 0; i < K; i++) {
            dfs(num, max*10 + num[i]);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());




        //숫자들 입력1
        num = new int[K];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < K; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        dfs(num, 0);

        System.out.println(answer);

    }


}
