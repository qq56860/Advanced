package Algorithm;

import java.util.Stack;

	/*
	 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
	 * */
public class 用两个栈实现队列 {
	
	public static void main(String[] args) {
		push(1);
		push(2);
		push(3);
		push(4);
		push(5);
		
		System.out.println(pop());
		System.out.println("~~~~~~~");
		System.out.println(pop());
		System.out.println("~~~~~~~");
		System.out.println(pop());
		System.out.println("~~~~~~~");
		System.out.println(pop());
		System.out.println("~~~~~~~");
		System.out.println(pop());
		System.out.println("~~~~~~~");
		System.out.println(pop());
		System.out.println("~~~~~~~");
	}
	
	
	static Stack<Integer> stack1 = new Stack<Integer>();
	static Stack<Integer> stack2 = new Stack<Integer>();
     
    public static void push(int node) {
       stack1.push(node);
    }
     
    public static int pop() {
        Integer p = null;
        if(!stack1.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            p = stack2.pop();
            while(!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
        }
         
        return p;
    }
	
}
