package test1;

//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
public class TheNTHFromTheBottom {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyhead = new ListNode(0);   //设置虚拟头结点
        dummyhead.next = head;
        ListNode fast = dummyhead, slow = dummyhead;
        for(int i=0;i<=n;i++){   //fast指针先走n+1步,为的是找到倒数第n个结点的前驱结点
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        //循环结束后slow指向的就是要删除结点的前驱
        slow.next = slow.next.next;
        return dummyhead.next;
    }
}
