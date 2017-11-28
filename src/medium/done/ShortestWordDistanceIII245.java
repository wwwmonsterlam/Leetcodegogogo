package medium.done;

public class ShortestWordDistanceIII245 {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        long distance = Integer.MAX_VALUE;
        if(word1.equals(word2)) {
            long lastIndex = Integer.MIN_VALUE;
            for(int i = 0; i < words.length; i++) {
                if(words[i].equals(word1)) {
                    distance = Math.min(distance, i - lastIndex);
                    lastIndex = i;
                }
            }
            
            return (int)distance;
        } else {
            long index1 = Integer.MIN_VALUE;
            long index2 = Integer.MIN_VALUE;
            for(int i = 0; i < words.length; i++) {
                if(words[i].equals(word1)) {
                    index1 = i;
                    distance = Math.min(distance, i - index2);
                }
                if(words[i].equals(word2)) {
                    index2 = i;
                    distance = Math.min(distance, i - index1);
                }
            }
            return (int)distance;
        }
    }
}
