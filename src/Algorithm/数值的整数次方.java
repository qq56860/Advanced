package Algorithm;
	/*
	 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
	 * 
	 * */
public class 数值的整数次方 {
	
	public static void main(String[] args) {
		System.out.println(Power(2.0,-3));
	}
	
	public static double Power(double base, int exponent) {
	       double result = base;
	        if(exponent == 0){
	            result = 1;
	        }
	        if(exponent > 0){
	            for(;exponent>1;exponent--){
	                result = result*base;
	            }
	        }
	        if(exponent < 0){
	            for(;exponent<-1;exponent++){
	                result = result*base;
	            }
	            result = 1/result;
	        }
	         
	        return result;
	  }
}
