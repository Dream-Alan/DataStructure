package DataStructure.leetcode;
// https://leetcode.cn/problems/reverse-linked-list/
public class Problem141 {
/**
 * 判断链表是否有环
 * 使用快慢指针法（龟兔赛跑算法）
 * @param head 链表的头节点
 * @return 如果链表有环返回true，否则返回false
 */
    public boolean hasCycle(ListNode head) {
    // 处理边界情况：空链表或只有一个节点的链表不可能有环
    if(head==null||head.next==null) return false;
    // 初始化慢指针（每次走一步）和快指针（每次走两步）
    ListNode slow=head;
    ListNode fast=head.next;
    // 遍历链表，直到快指针或快指针的下一个节点为null
    while (fast!=null&&fast.next!=null){
        // 如果快慢指针相遇，说明链表有环
        if (slow==fast) return true;
        // 慢指针移动一步
        slow=slow.next;
        // 快指针移动两步
        fast=fast.next.next;
    }return false;
    }
}
