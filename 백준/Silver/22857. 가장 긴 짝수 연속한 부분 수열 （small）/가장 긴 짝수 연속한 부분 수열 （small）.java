

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int s = 0;
        int e = 0;
        int max = 0;
        int count = 0;

        while (e < n) {

            if (arr[e] % 2 == 1) count++;
            e++;

            while (count > m) {
                if (arr[s] % 2 == 1) count--;
                s++;
            }

            int len = (e - s) - count;
            max = Math.max(max, len);
        }

        System.out.println(max);


    }
}