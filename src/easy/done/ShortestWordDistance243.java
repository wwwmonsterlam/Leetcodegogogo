package easy.done;

//难点在于如遍历一次就能找到答案
public class ShortestWordDistance243 {
    public int shortestDistance(String[] words, String word1, String word2) {
        long index1 = words.length * 2;
        long index2 = words.length * 3;
        long distance = words.length;
        boolean updateFlag = false;
        
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(word1)) {
                index1 = i;
                updateFlag = true;
            }
            if(words[i].equals(word2)) {
                index2 = i;
                updateFlag = true;
            }
            if(updateFlag) {
                updateFlag = false;
                distance = Math.min(distance, Math.abs(index1 - index2));               
            }
        }
        
        return (int)distance;
    }
}
