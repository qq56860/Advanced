package Algorithm;

import Algorithm.util.ListNode;
	/*
	 * 输入一个链表，输出该链表中倒数第k个结点。
	 * 
	 * 巧妙之处在于，只用一次遍历就可以找出K
	 * 
	 * */
public class 链表中倒数第k个结点 {
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode h2 = new ListNode(2);
		ListNode h3 = new ListNode(3);
		ListNode h4 = new ListNode(4);
		ListNode h5 = new ListNode(5);
		head.next = h2;
		h2.next = h3;
		h3.next = h4;
		h4.next = h5;
		h5.next = null;
		
		
		ListNode node = FindKthToTail(head,3);
		
		System.out.println(node.val);
	}
	
	public static ListNode FindKthToTail(ListNode head,int k) {
        if(head ==null || k<=0){
            return null;
        }
         
        ListNode preNode = head;
        ListNode lastNode = head;
        for (int i = 1; i <= k; i++) {
            if(preNode != null)
                preNode = preNode.next;
            else
                return null;
        }
         
        while(preNode != null){
            preNode = preNode.next;
            lastNode = lastNode.next;
        }
        return lastNode;
    }
}
