//https://leetcode.cn/problems/sort-list/?envType=study-plan-v2&envId=top-100-liked
//排序链表
//时间复杂度：O(N log N),空间复杂度：O(log N)
import java.util.Comparator;

public class leetcode148 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode help = new ListNode(0);

    public static ListNode sortList(ListNode head) {
        //只有一个节点或者没有节点时返回
        if (head == null || head.next == null){
            return head;
        }
        ListNode f = head;
        ListNode s = head;

        //找到左链表最后一个节点
        while (f.next != null && f.next.next != null){
            f = f.next.next;
            s = s.next;
        }
        //找到中点
        ListNode m = s.next;
        //打断链表
        s.next = null;

        //递归左右链表
        ListNode left = sortList(head);
        ListNode right = sortList(m);

        //合并
        return merge(left,right);
    }

    public static ListNode merge(ListNode h1, ListNode h2){

        // 【关键】每次合并都新建虚拟头，绝对不用静态变量！
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        Comparator<ListNode> comparator = (n1, n2) -> n1.val - n2.val;

        //双指针合并
        while (h1 != null && h2 != null){
            if (comparator.compare(h1,h2) <= 0) {
                cur.next = h1;
                h1 = h1.next;
            }else {
                cur.next = h2;
                h2 = h2.next;
            }
            cur = cur.next;
        }

        // 拼接剩余节点
        cur.next = h1 != null ? h1 : h2;

        // 返回合并后的真实头节点
        return dummy.next;
    }
}
