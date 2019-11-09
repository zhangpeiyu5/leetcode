package difficulty.medium;

//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//
//
// 示例:
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
public class SwapNodesInPairs_24 {
    public static void main(String[] args) {
        SwapNodesInPairs_24 test = new SwapNodesInPairs_24();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode res = test.swapPairs2(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    /**
     * 方法二：迭代法
     *
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        ListNode curr = new ListNode(0);
        ListNode res = curr;
        curr.next = head;
        while (curr.next != null && curr.next.next != null) {
            ListNode start = curr.next;
            ListNode end = curr.next.next;

            curr.next = end;
            start.next = end.next;
            end.next = start;
            curr = start;
        }
        return res.next;
    }

    /**
     * 方法一：递归法
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        //终止条件：head为空或只剩一个节点（head.next==null）
        if (head == null || head.next == null) {
            return head;
        }

        //调用单元：设需要交换的两个点为 head 和 next，head 连接后面交换完成的子链表，next 连接 head，完成交换
        ListNode next = head.next;
        head.next = swapPairs(head.next.next);
        next.next = head;

        //返回值
        return next;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
