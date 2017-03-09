package Algorithm;

import java.util.ArrayList;
	 /*
	  * 输入一个链表，从尾到头打印链表每个节点的值。
	  * */

import Algorithm.util.ListNode;



public class 从尾到头打印链表 {
	
	
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        while(listNode!=null){
             
                arr.add(listNode.val);
                listNode = listNode.next;
             
        }
        for(int i = arr.size() ; i>0 ; i--){
            arr1.add(arr.get(i-1));
        }
        return arr1;
    }
}



