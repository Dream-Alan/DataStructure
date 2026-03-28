package DataStructure.leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

// https://leetcode.cn/problems/reverse-linked-list/
public class Problem206 {
/**
 * 反转单链表的方法
 * @param head 链表的头节点
 * @return 反转后的链表头节点
 */
    public static ListNode reverseList(ListNode head) {
    // 如果链表为空，直接返回null
        if (head == null){
            return null;
        }
    // 如果链表只有一个节点，直接返回该节点
        if (head.next == null){
            return head;
        }
    // 递归调用，反转当前节点后面的链表
        ListNode newhead =reverseList(head.next);
    // 将当前节点的下一个节点的next指针指向当前节点，实现反转
        head.next.next=head;
    // 将当前节点的next指针置为null，断开原来的指向
        head.next=null;
    // 返回新的头节点
        return newhead;
    }
    public ListNode reverseList2(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode newhead=null;
        while (head!=null&&head.next!=null){
            ListNode temp =head.next;
            head.next=newhead;
            newhead=head;
            head=temp;
        }
        return newhead;
    }
}
