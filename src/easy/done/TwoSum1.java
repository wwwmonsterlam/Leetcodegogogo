package easy.done;

import java.util.HashMap;

public class TwoSum1 {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            if(nums == null || nums.length == 0) 
                return null;
            
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            
            for(int i = 0; i < nums.length; i++) {
                Integer temp = map.get(target - nums[i]);                
                if(temp != null) {
                    int[] result = {(int)temp, i};
                    return result;
                } else {
                    map.put(nums[i], i);
                }
            }
            return null;
        }
    }
}
