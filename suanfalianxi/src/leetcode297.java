//https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/description/
//二叉树的序列化与反序列化
public class leetcode297 {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int v) {
            val = v;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        f(root,builder);
        return builder.toString();
    }

    void f(TreeNode root, StringBuilder builder){
        if (root == null){
            builder.append("#,");
        }else {
            builder.append(root.val + ",");
            f(root.left,builder);
            f(root.right,builder);
        }
    }

    // Decodes your encoded data to tree.

    public int cnt;

    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        cnt = 0;
        return g(vals);
    }

    TreeNode g(String[] vals){
        String cur = vals[cnt++];
        if (cur.equals("#")){
            return null;
        }else {
            TreeNode head = new TreeNode(Integer.valueOf(cur));
            head.left = g(vals);
            head.right = g(vals);
            return head;
        }
    }
}
