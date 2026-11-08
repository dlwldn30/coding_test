import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        // 속한 노래가 많은 장르 먼저 수록
        // 장르 내에서 많이 재생된 노래 수록
        // 장르 내에서 재생 횟수가 같은 노래중에서는 고유 번호가 낮은 노래를 먼저 수록함.
        
        int n = genres.length;
        
        // 장르 별 노래 속한 수
        Map<String, Integer> map = new HashMap<>();
        //장르 내에 있는 노래들
        Map<String, List<int[]>> list = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
            
            list.putIfAbsent(genres[i], new ArrayList<>());
            list.get(genres[i]).add(new int[]{i, plays[i]});
        }
        
        List<String> genreList = new ArrayList<>(map.keySet());
        genreList.sort((a,b) -> map.get(b) - map.get(a));
        
        List<Integer> answer = new ArrayList<>();
        
        for(String s : genreList){
            List<int[]> ls = list.get(s);
            
            ls.sort((a,b) -> {
                if(a[1] == b[1]) return a[0] - b[0];
                return b[1] - a[1];
            });
            
            answer.add(ls.get(0)[0]);
            if(ls.size() > 1){
                answer.add(ls.get(1)[0]);
            }
        }
        
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}