//https://leetcode.cn/problems/swap-nodes-in-pairs/description/?envType=study-plan-v2&envId=top-100-liked
//两两交换链表中的节点
public class leetcode24 {

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

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = head;
        ListNode cur = temp.next;

        while (pre.next != null && pre.next.next != null){
            if (head == temp){
                head = cur;
            }
            temp = pre.next;
            cur = temp.next;
            temp.next = cur.next;
            cur.next = temp;
            pre.next = cur;
            pre = temp;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = null;
//        head.next.next.next.next = null;
        head = swapPairs(head);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
