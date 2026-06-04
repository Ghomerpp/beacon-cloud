//https://leetcode.cn/problems/remove-nth-node-from-end-of-list/?envType=study-plan-v2&envId=top-100-liked
//删除链表的倒数第N个节点
public class leetcode19 {

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

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        System.out.println("921");
        ListNode head1 = head;
        ListNode f = head;
        ListNode s = head;
        int step = 0;
        int len = 0;

        while (f != null && f.next != null){
            f = f.next.next;
            s = s.next;
            step++;
        }
        len = f == null ? (step * 2) : (step * 2 + 1);
        step++;
        step = len - n - step;

        if (step >= 0){
            while (step != 0){
                s = s.next;
                step--;
            }
            s.next = s.next.next;
        }else {
            step = len - n;
            if (step == 0){
                head1 = head1.next;
                return head1;
            }
            while (step != 1){
                head1 = head1.next;
                step--;
            }
            head1.next = head1.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = null;
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = null;
        ListNode h1 = removeNthFromEnd(head, 1);
        while (h1 != null){
            System.out.println(h1.val);
            h1 = h1.next;
        }
    }
}
