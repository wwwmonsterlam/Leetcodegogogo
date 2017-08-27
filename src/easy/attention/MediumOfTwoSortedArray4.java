package easy.attention;

public class MediumOfTwoSortedArray4 {
    public class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if(nums1 == null && nums2 == null) {
                return 0;
            }
            
            int length1 = nums1 == null? 0 : nums1.length;
            int length2 = nums2 == null? 0 : nums2.length;
            int a = (length1 + length2) / 2;
            int b = (length1 + length2 - 1) / 2;
            int[] temp = {0, 0};
            
            if (length1 == 0) {
                return (nums2[a] + nums2[b]) / 2.0;
            }
            
            if (length2 == 0) {
                return (nums1[a] + nums1[b]) / 2.0;
            }
            
            int k = 0;
            int i = 0;
            int j = 0;
            while(k <= a) {
                if(i >= length1) {
                    temp[k & 1] = nums2[j++];
                } else if(j >= length2) {
                    temp[k & 1] = nums1[i++];
                } else {
                    temp[k & 1] = nums1[i] <= nums2[j]? nums1[i++] : nums2[j++];
                }
                
                k++;
            }
            
            return a == b? Math.max(temp[0], temp[1]) : (temp[0] + temp[1]) / 2.0;
        }
    }
}
