package Algorithm;

import Algorithm.util.ListNode;
	/*
	 * 输入一个链表，反转链表后，输出链表的所有元素。
	 * 
	 * 这里需要注意，对于数组，链表之类的，复制只是把地址指过去
	 * 
	 * */
public class 反转链表 {
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
		
		
		
		ListNode node = ReverseList(head);
		
		
		
		while(node != null){
			System.out.println(node.val);
			node = node.next;
		}
	}
	
	public static ListNode ReverseList(ListNode head) {
        ListNode nextNode = null;
         
        ListNode node = null;
         
        //ListNode newNode = new ListNode(0);
         
        nextNode = head;
        while (nextNode != null) {
            ListNode newNode = new ListNode(nextNode.val);
            //newNode.val = nextNode.val; //这一行。。。地址指到head后给后面附null
            newNode.next = node;       //又指到本身。。。
            node = newNode;
            System.out.println(node.val);
            nextNode = nextNode.next;
        }
        return node;
    }
}
