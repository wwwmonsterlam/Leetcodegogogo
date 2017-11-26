package medium.working;

import utils.TreeNode;

public class BinaryTreeUpsideDown156 {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        if (root.left == null) {
            return root;
        }
        
        TreeNode newRoot = null;
        reverse(root, newRoot);
        return newRoot;
        
    }
    
    public void reverse(TreeNode node, TreeNode r) {
        if(node.left == null) {
            r = node;
            return;
        }
        
        reverse(node.left, r);
        
        node.left.left = node.right;
        node.left.right = node;
        
        return;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        BinaryTreeUpsideDown156 solution = new BinaryTreeUpsideDown156();
        
        TreeNode newRoot = solution.upsideDownBinaryTree(root);
        
        while(newRoot != null) {
            System.out.println(newRoot.val);
            newRoot = newRoot.left;
        }
    }
}
