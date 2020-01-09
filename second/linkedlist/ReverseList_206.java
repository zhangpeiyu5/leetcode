package second.linkedlist;
//反转一个单链表。
//
// 示例:
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL
//
// 进阶:
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？


public class ReverseList_206 {
    public static void main(String[] args) {
        ReverseList_206 test = new ReverseList_206();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode res = test.reverseList2(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }


    /**
     * 方法一：迭代法
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


    /**
     * 方法二：递归法
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        return recursive(head, null);
    }

    public ListNode recursive(ListNode head, ListNode newNode) {
        if (head == null) {
            return newNode;
        }

        ListNode next = head.next;
        head.next = newNode;
        return recursive(next, head);
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}


