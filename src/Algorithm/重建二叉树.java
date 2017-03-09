package Algorithm;

import java.util.LinkedList;
import java.util.Queue;

import Algorithm.util.TreeNode;
import BinaryTreeTest.BinaryTree;
	/*
	 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
	 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
	 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
	 * 
	 * */
public class 重建二叉树 {
	
	public static void main(String[] args) {
		int [] pre = {1,2,3,4};
		int [] in = {4,3,2,1};
		
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
				j = 2*j+j;
			}
		}
		
	}
	
}
