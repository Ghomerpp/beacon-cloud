//https://leetcode.cn/problems/add-two-numbers/description/?envType=study-plan-v2&envId=top-100-liked
//两数相加
public class leetcode02 {

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode addTwoNumbers(ListNode h1, ListNode h2) {

        ListNode ans = null;
        ListNode cur = null;
        int carry = 0;
        for (int sum, val; // 声明变量
             h1 != null || h2 != null; // 终止条件
             h1 = h1 == null ? null : h1.next, // 每一步h1的跳转
                     h2 = h2 == null ? null : h2.next // 每一步h2的跳转
        ) {
            sum = (h1 == null ? 0 : h1.val)
                    + (h2 == null ? 0 : h2.val)
                    + carry;

            val = sum % 10;
            carry = sum / 10;

            if (ans == null) {
                ans = new ListNode(val);
                cur = ans;
            }else {
                cur.next = new ListNode(val);
                cur = cur.next;
            }
        }
        if (carry == 1){
            cur.next = new ListNode(carry);
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode h1 = new ListNode(2);
        h1.next = new ListNode(4);
        h1.next.next = new ListNode(3);

        ListNode h2 = new ListNode(5);
        h2.next = new ListNode(6);
        h2.next.next = new ListNode(4);

        System.out.println(addTwoNumbers(h1, h2));
    }
}
