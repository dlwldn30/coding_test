import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();

        boolean inTag = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 태그 시작
            if (c == '<') {
                result.append(word.reverse());
                word.setLength(0);
                inTag = true;
                result.append(c);
            }
            // 태그 끝
            else if (c == '>') {
                inTag = false;
                result.append(c);
            }
            // 태그 안
            else if (inTag) {
                result.append(c);
            }
            // 공백
            else if (c == ' ') {
                result.append(word.reverse()).append(' ');
                word.setLength(0);
            }
            // 일반 문자
            else {
                word.append(c);
            }
        }

        // 마지막 단어 처리
        result.append(word.reverse());

        System.out.print(result);
    }
}