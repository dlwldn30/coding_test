
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = 0;
        int n = Integer.parseInt(br.readLine());

        int[] cows = new int[11];

        for (int i = 1; i <= 10; i++) {
            cows[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cow = Integer.parseInt(st.nextToken());
            int road = Integer.parseInt(st.nextToken());
            if(cows[cow] == -1)
                cows[cow] = road;
            else if(cows[cow] != road){
                num++;
                cows[cow] = road;
            }
        }

        System.out.println(num);


    }
}
