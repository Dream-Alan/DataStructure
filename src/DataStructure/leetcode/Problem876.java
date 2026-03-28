package DataStructure.leetcode;
//https://leetcode.com/problems/middle-of-the-linked-list/
public class Problem876 {
    public ListNode middleNode(ListNode head) {
        ListNode middle=head;
        ListNode middle2=head.next;
        ListNode temp=head;
        if(temp==null){
            return null;
        }
        if(temp.next==null){
            return head;
        }
        int i=0;
        while(temp!=null){
            i++;
            temp=temp.next;

        }
        if(i%2==0){
            i=i/2;
            for(int t=1;t<i;t++){
                middle=middle.next;
                middle2=middle2.next;
            }
            return middle2;
        }else if(i%2!=0){
            i=i/2;
            for(int t=1;t<=i;t++){
                middle=middle.next;
            }
            return middle;
        }
        return null;
    }
}
