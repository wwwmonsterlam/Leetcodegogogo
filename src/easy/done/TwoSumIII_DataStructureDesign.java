package easy.done;

import java.util.HashMap;

public class TwoSumIII_DataStructureDesign {

    private HashMap<Integer, Integer> hashMap; 
    
    /** Initialize your data structure here. */
    public TwoSumIII_DataStructureDesign() {
        hashMap = new HashMap<Integer, Integer>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        hashMap.put(number, hashMap.containsKey(number)? hashMap.get(number) + 1 : 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        return hashMap.entrySet().stream().anyMatch(entry -> {
            int pair = value - entry.getKey();
            if(pair == entry.getKey()) return entry.getValue() >= 2;
            else return hashMap.containsKey(pair);
        });
    }
    
    public static void main(String[] args) {
        TwoSumIII_DataStructureDesign twoSum = new TwoSumIII_DataStructureDesign();
        
        twoSum.add(0);
        twoSum.add(0);
        System.out.println(twoSum.find(0));
    }
    
}
