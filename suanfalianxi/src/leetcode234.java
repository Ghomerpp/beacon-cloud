import java.util.Scanner;

//https://leetcode.cn/problems/palindrome-linked-list/solutions/2952645/o1-kong-jian-zuo-fa-xun-zhao-zhong-jian-rv0f3/?envType=study-plan-v2&envId=top-100-liked
//回文链表
public class leetcode234 {

    public static class ListNode {
        int val;
        ListNode next;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode head2 = findMiddle(head);
        head2 = reverseList(head2);

        while (head2 != null){
            if(head.val != head2.val){
                return false;
            }
            head2 = head2.next;
            head = head.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode next = null;

        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 1. 读取所有输入的整数（空格/回车分隔）
        ListNode dummy = new ListNode(); // 适配你的ListNode无参构造
        ListNode cur = dummy;

        // 2. 逐个读取数字，构建链表（适配无参构造，手动赋值val）
        while (sc.hasNextInt()) {
            int val = sc.nextInt();
            ListNode node = new ListNode();
            node.val = val; // 手动给节点赋值
            cur.next = node;
            cur = cur.next;
        }


        // 构建完成后，dummy.next 就是链表的头节点
        ListNode head = dummy.next;

        sc.close();

        // ========== 新增的测试逻辑（仅这几行，不修改其他代码） ==========
        // 1. 创建类实例（因为isPalindrome是实例方法）
        leetcode234 solution = new leetcode234();
        // 2. 调用回文判断方法
        boolean result = solution.isPalindrome(head);
        // 3. 输出结果（极简输出，无多余提示）
        System.out.println(result);
        // =============================================================
    }
}
