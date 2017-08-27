package easy.attention;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths257 {
//      Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
     
    public class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            ArrayList<String> result = new ArrayList<>();
            StringBuilder sBuilder = new StringBuilder();
            helper(root, result, sBuilder);
            return result;
        }
        private void helper(TreeNode root, ArrayList<String> result, StringBuilder sb) {
            if (root == null) {
                return;
            }
            
            int len = sb.length();
            sb.append(root.val);
            
            if (root.left != null || root.right != null) {
                sb.append("->");
                helper(root.left, result, sb);
                helper(root.right, result, sb);
            } else {
                result.add(sb.toString());
            }
            
            //This step is very important, it helps delete the String added in this depth
            //Before going back to a sallower level, every Stirng added in deeper level should be deleted
            sb.setLength(len);
        }
    }
}
