//合并k个升序链表
//https://leetcode.cn/problems/merge-k-sorted-lists/description/
import java.util.PriorityQueue;

public class leetcode23 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b) -> a.val - b.val);
        for (ListNode h : lists){
            if(h != null){
                heap.add(h);
            }
        }
        if(heap.isEmpty()){
            return null;
        }
        ListNode h = heap.poll();
        ListNode pre = h;
        if(pre.next != null){
            heap.add(pre.next);
        }
        while (!heap.isEmpty()){
            ListNode cur = heap.poll();
            pre.next = cur;
            pre = cur;
            if (cur.next != null){
                heap.add(cur.next);
            }
        }
        return h;
    }
}
