
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());
        int rcs = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        int[] rc = new int[rcs];
        int[] count = new int[101];
        int[] time = new int[101];
        int t = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < rcs; i++) {
            rc[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < rcs; i++) {

            // 같은 숫자가 있을 경우
            if (list.contains(rc[i])) {
                count[rc[i]]++;
            } else {
                if (list.size() < N) {
                    list.add(rc[i]);
                    count[rc[i]]++;
                    time[rc[i]] = t++;
                } else {
                    int remove = -1;
                    int minCount = Integer.MAX_VALUE;
                    int oldTime = Integer.MAX_VALUE;
                    for (int y : list){
                        if(count[y] < minCount || (count[y] == minCount && time[y] < oldTime)){
                            minCount = count[y];
                            oldTime = time[y];
                            remove = y;
                        }
                    }
                    list.remove(Integer.valueOf(remove));
                    count[remove] = 0;

                    list.add(rc[i]);
                    count[rc[i]] = 1;
                    time[rc[i]] = t++;
                }
            }
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
