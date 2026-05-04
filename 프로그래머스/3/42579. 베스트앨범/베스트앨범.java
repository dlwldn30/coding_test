import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, Integer> genre = new HashMap<>();
        Map<String, List<int[]>> list = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++){
            genre.put(genres[i], genre.getOrDefault(genres[i], 0) + plays[i]);
            
            list.putIfAbsent(genres[i], new ArrayList<>());
            list.get(genres[i]).add(new int[]{i, plays[i]});
        }
        
        List<String> genreList = new ArrayList<>(genre.keySet());
        genreList.sort((a,b) -> genre.get(b) - genre.get(a));
        
        List<Integer> result = new ArrayList<>();
        
        for(String s : genreList){
            List<int[]> ls = list.get(s);
            ls.sort((a,b) -> {
                if(b[1] == a[1]) return a[0]-b[0];
                return b[1] - a[1];
             });
            
            result.add(ls.get(0)[0]);
            if(ls.size() > 1){
                result.add(ls.get(1)[0]);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
        
    }
}