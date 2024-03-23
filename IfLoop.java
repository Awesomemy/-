package test1;

/**
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 不允许修改 链表。
 */
public class IfLoop {
    /**
     *  本题难点在于如果有环的话该如何找到环入口
     *  设fast从head到入口走的距离是x(注意x里面可能绕了n圈),环入口到相遇点距离为y,相遇点到环入口距离为z
     *  则fast走的距离是x+y+n*(z+y),slow走的距离是x+y
     *  由于fast速度是slow两倍
     *  x+y+n*(z+y) = 2*(x+y)
     *  x = n*(y+z)-y
     *  x = (n-1)(y+z)+z
     *  可以看到(n-1)(y+z)就是fast在环内不断循环的距离
     *  故实际距离就是 x=z
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {   //说明有环
                ListNode index1 = fast;
                ListNode index2 = head;
                // 两个指针，从头结点和相遇结点，各走一步，直到相遇，相遇点即为环入口
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}
