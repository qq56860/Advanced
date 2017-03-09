package Algorithm;

import Algorithm.util.RandomListNode;
	/*
	 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
	 * 返回结果为复制后复杂链表的head。
	 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
	 * 
	 * */
public class 复杂链表的复制 {
	public static void main(String[] args) {
		
		RandomListNode f0 = new RandomListNode(0);
		RandomListNode f1 = new RandomListNode(1);
		RandomListNode f2 = new RandomListNode(2);
		RandomListNode f3 = new RandomListNode(3);
		RandomListNode f4 = new RandomListNode(4);
		RandomListNode f5 = new RandomListNode(5);
		RandomListNode f6 = new RandomListNode(6);
		RandomListNode f7 = new RandomListNode(7);
		RandomListNode f8 = new RandomListNode(8);
		RandomListNode f9 = new RandomListNode(9);
		f0.next = f1;
		f1.next = f2;
		f2.next = f3;
		f3.next = f4;
		f4.next = f5;
		f5.next = f6;
		f6.next = f7;
		f7.next = f8;
		f8.next = f9;
		
		f0.random = f3;
		f2.random = f1;
		f4.random = f8;
		f8.random = f5;
		
		RandomListNode node = Clone(f0);
		
		System.out.println(node.random.label);
		
	}
	
	public static RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null){
            return null;
        }
        //复制链表。每个新节点放在原节点后面；
        RandomListNode currentNode = pHead;
        while(currentNode != null ){
            RandomListNode node = new RandomListNode(currentNode.label);
            node.next = currentNode.next;
            currentNode.next = node;
            currentNode = node.next;
        }
        //遍历链表，附random
        currentNode = pHead;
        while(currentNode != null){
            if(currentNode.random != null){
                currentNode.next.random = currentNode.random.next;
            }
            currentNode = currentNode.next.next;
        }
         
        //拆分
        currentNode = pHead;
        RandomListNode cloneHead = pHead.next;
        RandomListNode node = null;
        while(currentNode.next != null){
            node = currentNode.next;
            currentNode.next = node.next;
            currentNode = node;
        }
         
        return cloneHead;
    }
	
}
