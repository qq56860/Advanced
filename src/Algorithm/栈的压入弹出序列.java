package Algorithm;

import java.util.ArrayList;
	/*
	 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
	 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
	 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
	 * 
	 * */
public class 栈的压入弹出序列 {
	public static void main(String[] args) {
		int []pushA = {1,2,3,4,5};
		int []popA = {4,5,3,2,1};
		System.out.println(IsPopOrder(pushA,popA));
	}
	
	public static boolean IsPopOrder(int [] pushA,int [] popA) {
	      if(pushA.length != popA.length || pushA.length == 0){
	            return false;
	        }
	        ArrayList<Integer> list = new ArrayList<Integer>();
	        for (int i = 0,j = 0; i < pushA.length; i++) {
	            list.add(pushA[i]);
	            for (; j < popA.length && list.get(list.size()-1) == popA[j]; j++) {
	                list.remove(list.size()-1);
	            }
	        }
	        return list.isEmpty();
	 }
}
