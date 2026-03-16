
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int N;
    static int[] num;
    static int[] op = new int[4];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        // 입력 받을 숫자
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 숫자 배열
        num = new int[N];


        //숫자 저장
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        // 연산자 저장
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < 4; i++){
            op[i] = Integer.parseInt(st.nextToken());
        }

        dfs(num[0], 1);



        System.out.println(max);
        System.out.println(min);

    }

    public static void dfs(int number, int count){

        if(count == N){
            if(number > max) max = number;
            if(number < min) min = number;
            return;
        }



        for(int i = 0; i < 4; i++){
            if(op[i] == 0) continue;

            int next = number;

            if(i == 0)
                next += num[count];
            else if(i == 1)
                next -= num[count];
            else if(i == 2)
                next *= num[count];
            else
                next /= num[count];

            op[i]--;
            dfs(next, count + 1);
            op[i]++;

        }







    }
}