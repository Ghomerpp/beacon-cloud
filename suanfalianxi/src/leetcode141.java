//https://leetcode.cn/problems/linked-list-cycle/?envType=study-plan-v2&envId=top-100-liked
//环形链表

import java.util.List;
import java.util.Scanner;

public class leetcode141 {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static boolean hasCycle(ListNode head) {
        ListNode s = head;
        ListNode f = head;

        while (f != null && f.next != null){
            f = f.next.next;
            s = s.next;
            if (s == f){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next;

        System.out.println(hasCycle(head));
    }
}
