package Algorithm;

import java.util.Stack;
	/*
	 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数
	 * 
	 * */
public class 包含min函数的栈 {
	
	public static void main(String[] args) {
		push(3);
		System.out.println(min());
		push(4);
		System.out.println(min());
		push(2);
		System.out.println(min());
		push(3);
		System.out.println(min());
		pop();
		System.out.println(min());
		pop();
		System.out.println(min());
		pop();
		System.out.println(min());
		push(0);
		System.out.println(min());
	}
	
	static Stack<Integer> stack1 = new Stack<Integer>();
    static Stack<Integer> stack2 = new Stack<Integer>();
    //int size;
    //static Integer min; //不可用
     
    public static void push(int node) {
        if(stack1.isEmpty()){
            stack2.push(node);
            stack1.push(node);
        }else{
            if(node < stack2.peek()){
                stack2.push(node);
            }
            stack1.push(node);
        }
    }
     
    public static void pop() {
        if(stack1.peek() == stack2.peek()){
            stack2.pop();
        }
        stack1.pop();
    }
     
    public static int top() {
        return stack1.peek();
    }
     
    public  static int min() {
        return stack2.peek();
    }
    
    
}
