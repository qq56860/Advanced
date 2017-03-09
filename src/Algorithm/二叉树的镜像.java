package Algorithm;

import java.util.LinkedList;
import java.util.Queue;

import Algorithm.util.TreeNode;
	/*
	 * 操作给定的二叉树，将其变换为源二叉树的镜像。
	 * 
	 * */
public class 二叉树的镜像 {
	
	
	
	public static void Mirror(TreeNode root) {
        if(root != null){
            TreeNode temp = null;
            temp = root.left;
            root.left = root.right;
            root.right = temp;
            if(root.left != null){
                Mirror(root.left);
            }
            if(root.right != null){
                Mirror(root.right);
            }
        }
    }
	
	//层序
	public static void levelTravel(TreeNode node){
		if (node==null)
			return;
		int i = 0,j = 1;//层次感
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(node);
		while(!q.isEmpty()){
			TreeNode temp = q.poll();
			System.out.print(temp.val+" ");
			if(temp.left != null){
				q.add(temp.left);
			}
			if(temp.right != null){
				q.add(temp.right);
			}
			i++;
			if(i >= j){
				System.out.println();
				j = j + (j << 1) ;
			}
		}
		
	}
	
	public static void main(String[] args) {
		TreeNode head = new TreeNode(1);
		TreeNode h2 = new TreeNode(2);
		TreeNode h3 = new TreeNode(3);
		TreeNode h4 = new TreeNode(4);
		TreeNode h5 = new TreeNode(5);
		head.left = h2;
		head.right = h3;
		h2.left = h4;
		h2.right = h5;
		
		levelTravel(head);
		
		Mirror(head);
		
		levelTravel(head);
		
	}
	
}
