
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[] light;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

         light = new boolean[N];
         st = new StringTokenizer(br.readLine());
         for (int i = 0; i < N; i++) {
             int n = Integer.parseInt(st.nextToken());
             light[i] = (n==1) ? true : false;
         }

         for (int i = 0; i < M; i++) {
             st = new StringTokenizer(br.readLine());
             for (int j = 0; j < 3; j++) {}
                int o = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                if (o == 1){
                    light[l-1] = (r == 1);
                }else if (o == 2){
                    for (int k = l-1; k <= r-1; k++) {
                        light[k] = !light[k];
                    }
                }else if (o == 3){
                    for (int k = l-1; k <= r-1; k++) {
                        light[k] = false;
                    }
                }else {
                    for (int k = l-1; k <= r-1; k++) {
                        light[k] = true;
                    }
                }
         }


         StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(light[i] ? 1 : 0).append(" ");
        }

        System.out.println(sb);
    }
}
