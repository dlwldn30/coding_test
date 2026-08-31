import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        
        Map<String, Integer> map = new HashMap<>(); 
        Map<String, List<int[]>> list = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
            
            list.putIfAbsent(genres[i], new ArrayList<>());
            list.get(genres[i]).add(new int[]{i, plays[i]});
        }
        
        List<String> genreList = new ArrayList<>(map.keySet());
        genreList.sort((a,b) -> map.get(b) - map.get(a));
        
        List<Integer> answer = new ArrayList<>();
        
        for (String s : genreList){
            List<int[]> ls = list.get(s);
            
            ls.sort( (a,b) ->{
                if(a[1] == b[1]) return a[0]-b[0];
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