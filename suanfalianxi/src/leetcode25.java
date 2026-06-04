//https://leetcode.cn/problems/reverse-nodes-in-k-group/description/?envType=study-plan-v2&envId=top-100-liked
//K个一组反转链表
public class leetcode25 {
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


    // 当前组的开始节点是s，往下数k个找到当前组的结束节点返回
    public static ListNode teamEnd(ListNode s, int k) {
        while (--k != 0 && s != null) {
            s = s.next;
        }
        return s;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode h = head;
        ListNode A = head;
        ListNode B = head;
        ListNode pre = null;
        ListNode next = null;

        while (teamEnd(h, k) != null){

            int step = k;
            while (step != 0){
                next = h.next;
                h.next = pre;
                pre = h;
                h = next;
                step--;
            }
            A.next = h;
            if(A == head){
                head = pre;
                pre = null;
                B = A;
                A = h;
            }else {
                B.next = pre;
                pre = null;
                A.next = h;
                B = A;
                A = h;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        A.next = new ListNode(2);
        A.next.next = new ListNode(3);
        A.next.next.next = new ListNode(4);
        A.next.next.next.next = new ListNode(5);
        A.next.next.next.next.next = new ListNode(6);
        A.next.next.next.next.next.next = new ListNode(7);
        A.next.next.next.next.next.next.next = null;
        ListNode ans = reverseKGroup(A,3);
        while (ans != null){
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
