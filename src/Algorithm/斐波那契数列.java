package Algorithm;

import com.sun.xml.internal.ws.api.pipe.Fiber;
	/*
	 * 迭代（Iteration） VS 递归（Recursion）
	 * 
	 * 因此光是n=4时f(1)就重复计算了3次之多，递归不可行
	 * 
	 * 
	 * */
public class 斐波那契数列 {
	
	public static void main(String[] args) {
		System.out.println(Fibonacci(8));
	}
	
	public static int Fibonacci(int n) {
        if(n == 0 ){
                return 0;
            }if(n == 1){
                return 1;
            }
             
            int n1 = 0;
            int n2 = 1;
            int result = 0;
            for (int i = 2; i <= n; i++) {
                result = n1 + n2;
                n1 = n2;
                n2 = result;
                 
            }
            return result;
    }
}
