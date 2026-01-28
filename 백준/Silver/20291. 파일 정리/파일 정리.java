
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Map<String, Integer> folder = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String fileName = br.readLine();
            int idx = fileName.lastIndexOf('.');
            String ext = fileName.substring(idx + 1);
            folder.put(ext, folder.getOrDefault(ext, 0) + 1);
        }

        List<String> keys = new ArrayList<>(folder.keySet());
        Collections.sort(keys);

        StringBuilder sb = new StringBuilder();
        for (String key : keys) {
            sb.append(key).append(" ").append(folder.get(key)).append("\n");
        }

        System.out.println(sb);
    }
}
