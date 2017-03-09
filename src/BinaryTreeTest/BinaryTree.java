package BinaryTreeTest;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;





public class BinaryTree {
	
	private int []arr = {1,2,3,4,5,6,7};
	
	private static List<Node> nodelist=null;
	
	private static class Node{
		Node leftchild;
		Node rightchild;
		int data;
		Node(int data){
			leftchild =null;
			rightchild=null;
			this.data=data;
		}
	}
	
	public  void createBinTree(){
		nodelist=new LinkedList<Node>();
		
		for(int i=0;i<arr.length;i++){
			nodelist.add(new Node(arr[i]));
		}
		for(int i=0;i<arr.length >> 1 - 1;i++){
			nodelist.get(i).leftchild=nodelist.get(i << 1 +1);
			nodelist.get(i).rightchild=nodelist.get(i << 1+2);
		}
		int lastParentNode=arr.length >> 1 - 1;
		nodelist.get(lastParentNode).leftchild=nodelist.get(lastParentNode << 1 + 1);
		if(arr.length%2==1){
			nodelist.get(lastParentNode).rightchild=nodelist.get(lastParentNode << 1 + 2);
		}
		
	}

	public static List<Node> getNodelist() {
		return nodelist;
	}

	public static void setNodelist(List<Node> nodelist) {
		BinaryTree.nodelist = nodelist;
	}
	
	public static void inOrderTraverse(Node node){
		if (node==null)
				return;
		//中序
		inOrderTraverse(node.leftchild);
		System.out.println(node.data);
		inOrderTraverse(node.rightchild);
	}
	//层序
	public static void levelTravel(Node node){
		if (node==null)
			return;
		int i = 0,j = 1;//层次感
		Queue<Node> q = new LinkedList<BinaryTree.Node>();
		q.add(node);
		while(!q.isEmpty()){
			Node temp = q.poll();
			System.out.print(temp.data+" ");
			if(temp.leftchild != null){
				q.add(temp.leftchild);
			}
			if(temp.rightchild != null){
				q.add(temp.rightchild);
			}
			i++;
			if(i >= j){
				System.out.println();
				j = 2*j+j;
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		BinaryTree bintree=new BinaryTree();
		bintree.createBinTree();
		
		Node root=nodelist.get(0);
		levelTravel(root);
	}
	
}

