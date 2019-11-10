package second.easy;

//链表反转
public class ReverseLinkedList_206 {
    public static void main(String[] args) {
        ReverseLinkedList_206 test = new ReverseLinkedList_206();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

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
    public ListNode reverseList1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
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
