
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE;

        int s = 0;
        int e = 0;

        int sum = 0;

        while(e < n) {


            //합이 작아서 뒤에걸 증가시켜야 하는 경우
            if(sum < m ) {
                sum += arr[e];
                e++;
            }else{ // 큰경우
                int length = e-s;
                min = Math.min(min, length);
                sum -= arr[s];
                s++;
            }

            while(sum >= m){
                min = Math.min(min, e-s);
                sum -= arr[s];
                s++;
            }
        }
        
        if(min == Integer.MAX_VALUE) {
            System.out.println(0);
        }else{System.out.println(min);}
    }


}