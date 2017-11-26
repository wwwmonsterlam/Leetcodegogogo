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
        
        return reverse(root);
        
    }
    
    public TreeNode reverse(TreeNode node) {
        if(node.left == null) {
            return node;
        }
        
        TreeNode r = reverse(node.left);
        
        node.left.left = node.right;
        node.left.right = node;
        
        return r;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        BinaryTreeUpsideDown156 solution = new BinaryTreeUpsideDown156();
        
        TreeNode newRoot = solution.upsideDownBinaryTree(root);
        
        System.out.println("The result is: ");
        System.out.println(newRoot.val);
        System.out.println(newRoot.right.val);
    }
}
