
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        question[] baseball = new question[N];
        int answer = 0;


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String num = st.nextToken();
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            baseball[i] = new question(num, strike, ball);
        }

        for (int i = 123; i<= 987; i++){
            String cand = String.valueOf(i);


            if (cand.charAt(0) == '0' ||
                    cand.charAt(1) == '0' ||
                    cand.charAt(2) == '0') continue;

            if (cand.charAt(0) == cand.charAt(1) ||
                    cand.charAt(1) == cand.charAt(2) ||
                    cand.charAt(0) == cand.charAt(2)) continue;

            boolean possible = true;

            for (int j = 0; j < N; j++){
                int s = 0;
                int b = 0;
                String num = baseball[j].num;
                int strike = baseball[j].strike;
                int ball = baseball[j].ball;
                for (int k = 0; k < 3; k++){
                    if (cand.charAt(k) == num.charAt(k)) {
                        s++;
                    }
                    for (int l = 0; l < 3; l++){
                        if(l == k)
                            continue;
                        if(cand.charAt(k) == num.charAt(l)){
                            b++;
                        }
                    }

                }
                if(strike != s || ball != b){
                    possible = false;
                    break;
                }
            }
            if(possible) answer++;
        }


        System.out.println(answer);
    }

    static class question {
        String num;
        int strike, ball;

        public question(String num, int strike, int ball){
            this.num = num;
            this.strike = strike;
            this.ball = ball;
        }
    }
}
