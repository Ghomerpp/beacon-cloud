public class leetcode114_and_111 {

    // 不提交这个类
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    // 测试链接 : https://leetcode.cn/problems/maximum-depth-of-binary-tree/
    // 二叉树的最大深度
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }

    //https://leetcode.cn/problems/minimum-depth-of-binary-tree/
    //二叉树的最小深度
    public int minDepth(TreeNode root) {
        //若二叉树为空则返回0
        if (root == null){
            return 0;
        }
        //当前root为叶节点
        if(root.left == null && root.right == null){
            return 1;
        }

        int ldeep = Integer.MAX_VALUE;
        int rdeep = Integer.MAX_VALUE;
        if (root.left != null){
            ldeep = minDepth(root.left);
        }
        if (root.right != null){
            rdeep = minDepth(root.right);
        }
        return Math.min(ldeep,rdeep) + 1;
    }
}
