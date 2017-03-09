package Algorithm;

public class 跳台阶 {
	/*
	 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
	 * 
	 * 
	 * 对于第n个台阶来说，只能从n-1或者n-2的台阶跳上来，所以F(n) = F(n-1) + F(n-2)
	 * 使用斐波拉契
	 * 
	 * */
	public static void main(String[] args) {
		System.out.println(JumpFloor(100));
	}
	
	public static int JumpFloor(int target) {
        if(target == 0 || target == 1 || target ==2 ){
            return target;
        }
        int f1 = 1;
        int f2 = 2;
        int result = 0;
        for(int i = 3; i <= target ;i++){
            result = f1+f2;
            f1 = f2;
            f2 = result;
        }
        return result;
    }
	
}
