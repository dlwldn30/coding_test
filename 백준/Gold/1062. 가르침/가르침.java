
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited = new boolean[26];
    static int k;
    static int max = 0;
    static List<String> list = new ArrayList<>();
    static int n, m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        if(m < 5){
            System.out.println(0);
            return;
        }

        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['c' - 'a'] = true;
        visited['i' - 'a'] = true;

        k = m-5;



        for(int i = 0; i < n; i++){
            String input = br.readLine();
            String word = input.substring(4, input.length()-4);
            list.add(word);
        }


        dfs(0, 0);

        System.out.println(max);

    }

    static void dfs(int idx, int count){

        if(count == k){
            int cnt = 0;

            for(String word : list){
                boolean ok = true;
                for(int i = 0; i < word.length(); i++){
                    if(!visited[word.charAt(i)-'a']){
                        ok = false;
                        break;
                    }
                }
                if(ok) cnt++;
            }
            max = Math.max(max, cnt);
            return;
        }

        for(int i = idx; i < 26; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i+1,count+1);
                visited[i] = false;
            }
        }
    }



}