package DataStructure.leetcode;
//https://leetcode.com/problems/remove-linked-list-elements/
public class Problem203 {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null) return null;
        if(head.val==val){
            head=removeElements(head.next,val);
        }
        ListNode cur=head;
        while(cur!=null&&cur.next!=null && cur.val!=val){
            if (cur.next.val==val){
                cur.next=cur.next.next;
            }else{
                cur=cur.next;
            }
        }
            return head;
    }
}
