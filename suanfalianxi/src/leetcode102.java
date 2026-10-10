import java.util.*;

//https://leetcode.cn/problems/binary-tree-level-order-traversal/description/
//二叉树的层序遍历
public class leetcode102 {
    public static class TreeNode {
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

    //第一个方法
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root != null){
            HashMap<TreeNode,Integer> levels = new HashMap<>();
            Queue<TreeNode> queue = new PriorityQueue();
            queue.add(root);
            levels.put(root,0);
            while (!queue.isEmpty()){
                TreeNode cur = queue.poll();
                int level = levels.get(cur);
                if (ans.size() == level){
                    ans.add(new ArrayList<>());
                }
                ans.get(level).add(cur.val);
                if (cur.left != null){
                    queue.add(cur.left);
                    levels.put(cur.left, level+1);
                }
                if (cur.right != null){
                    queue.add(cur.right);
                    levels.put(cur.right, level+1);
                }
            }
        }
        return ans;
    }

    // 提交时把方法名改为levelOrder，此方法为每次处理一层的优化bfs，此题推荐
    public static int MAXN = 2001;

    public static TreeNode[] queue = new TreeNode[MAXN];

    public static int l, r;

    public static List<List<Integer>> levelOrder2(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();
        if (root != null){
            l = r = 0;
            queue[r++] = root;
            while (l < r){  // 队列里还有东西
                int size = r - l;
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue[l++];
                    list.add(cur.val);
                    if (cur.left != null){
                        queue[r++] = cur.left;
                    }
                    if (cur.right != null){
                        queue[r++] = cur.right;
                    }
                }
                ans.add(list);
            }
        }
        return ans;
    }
}
