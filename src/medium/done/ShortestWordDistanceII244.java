package medium.done;

import java.util.ArrayList;
import java.util.HashMap;

//难点在于：1）使用了map的一个方法computeIfAbsent; 2) 使用类似于243的思想去找最小距离，这样的话只用O（n+m）时间不是O（n*m）时间
public class ShortestWordDistanceII244 {
    private HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
    
    public ShortestWordDistanceII244(String[] words) {
        
        for(int i = 0; i < words.length; i++) {
            map.computeIfAbsent(words[i], list -> new ArrayList<Integer>()).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        int distance = Integer.MAX_VALUE;
        ArrayList<Integer> list1 = map.get(word1);
        ArrayList<Integer> list2 = map.get(word2);
        
        for(int i = 0, j = 0; i < list1.size() && j < list2.size(); ) {
            int index1 = list1.get(i);
            int index2 = list2.get(j);
            if(index1 < index2) {
                distance = Math.min(distance, Math.abs(index2 - index1));
                i++;
            } else {
                distance = Math.min(distance, Math.abs(index1 - index2));
                j++;
            }
        }
        
        return distance;
    }
}
