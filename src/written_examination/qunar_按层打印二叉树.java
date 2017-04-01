package written_examination;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 给定一棵二叉树的前序（根、左、右）和中序（左、根、右）的打印结果，输出此二叉树按层（从左往右）打印结果。
 * 
 * */

public class qunar_按层打印二叉树 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.valueOf(sc.nextLine());
		
		String preStr[] = sc.nextLine().split(" ");
		String inStr[] = sc.nextLine().split(" ");
		int[] pre = new int[n];
		int[] in = new int[n];
		for (int i = 0; i < n; i++) {
			pre[i] = Integer.valueOf(preStr[i]);
			in[i] = Integer.valueOf(inStr[i]);
		}
		
		TreeNode node = reConstructBinaryTree(pre, in);
		
		levelTravel(node);
	}
	
	public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        
        TreeNode nodeLeft = null;
        TreeNode nodeRight = null;
        TreeNode node = null;
        //递归条件
        if(pre.length > 2){
            for(int i = 0 ; i < pre.length ;i++){
                if(in[i] == pre[0]){
                    if(i>0){
                        int []pre1 = new int[i];
                        int []in1 = new int[i];
                        System.arraycopy(pre, 1 , pre1, 0, i);
                        System.arraycopy(in, 0 , in1, 0, i);
                        nodeLeft = reConstructBinaryTree(pre1,in1);
                    }
                     
                    if(pre.length-i-1>0){
                        int []pre2 = new int[pre.length-i-1];
                        int []in2 = new int[pre.length-i-1];
                        System.arraycopy(pre, i+1 , pre2, 0, pre.length-i-1);
                        System.arraycopy(in, i+1 , in2, 0, pre.length-i-1);
                        nodeRight = reConstructBinaryTree(pre2,in2);   
                    }
                }
                 
            }
        }else if(pre.length == 2){
            if(pre[0] == in[1]){
                nodeLeft = reConstructBinaryTree(new int[]{pre[1]},new int[]{pre[1]});
            }else{
                nodeRight = reConstructBinaryTree(new int[]{pre[1]},new int[]{pre[1]});
            }
             
        }
         
        node = new TreeNode(pre[0]);
        node.left = nodeLeft;
        node.right = nodeRight;
         
        return node;
    }
	
	//层序
	public static void levelTravel(TreeNode node){
		if (node==null)
			return;
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
		}
		
	}
}
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val){
		this.val = val;
	}
}
