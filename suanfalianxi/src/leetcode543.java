//二叉树的直径
//https://leetcode.cn/problems/diameter-of-binary-tree/description/?envType=study-plan-v2&envId=top-100-liked
public class leetcode543 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int max = 0;
    private int getDepth(TreeNode root){
        if(root == null) return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);

        max = Math.max(max,left + right);
        return Math.max(left,right) + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        getDepth(root);
        return max;
    }
}
