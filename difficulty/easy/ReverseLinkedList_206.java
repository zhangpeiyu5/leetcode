package difficulty.easy;

//反转一个单链表。
//
// 示例:
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL
//
// 进阶:
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
public class ReverseLinkedList_206 {
    public static void main(String[] args) {
        ReverseLinkedList_206 test = new ReverseLinkedList_206();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);


        ListNode res = test.reverseList1(head);
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
     * 方法二：递归法 todo
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        return null;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

