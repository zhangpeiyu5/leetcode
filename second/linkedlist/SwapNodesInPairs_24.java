package second.linkedlist;
//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//
//
// 示例:
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.   1 2 3 4 5

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
     * 方法一：递归
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;

        return next;
    }


    /**
     * 方法二：迭代法
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        ListNode curr = new ListNode(-1);
        curr.next = head;
        ListNode res = curr;

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


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
