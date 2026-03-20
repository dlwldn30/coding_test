
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

        List<Integer> tabs = new ArrayList<>();
        int[] plugs = new int[m];


        st = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < m; i++) plugs[i] = Integer.parseInt(st.nextToken());

        int count = 0;

        for(int i = 0; i < m; i++) {

            // 빈자리인 경우
            int cur = plugs[i];

            if(tabs.contains(cur)) continue;

            if(tabs.size() < n){
                tabs.add(cur);
                continue;
            }


            int idx = -1;
            int farthest = -1;

            for(int j = 0; j < n; j++){
                int next = Integer.MAX_VALUE;

                for(int t = i+1; t < m; t++){
                    if(tabs.get(j) == plugs[t]){
                        next = t;
                        break;
                    }
                }

                if(next == Integer.MAX_VALUE){
                    idx = j;
                    break;
                }

                if(farthest < next){
                    farthest = next;
                    idx = j;
                }
            }

            tabs.remove(idx);
            tabs.add(cur);
            count++;

        }

        System.out.println(count);
    }


}