package Algorithm;
	/*
	 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
	 * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
	 * */
public class 调整数组顺序使奇数位于偶数前面 {
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,3,2,4,5,7,10,12,9};
		
		reOrderArray(arr);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void reOrderArray(int [] array) {
        int []array_left = new int[array.length];
        int left = 0,right = 0;
        int []array_right = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if(array[i] % 2 ==1){
                array_left[left++] = array[i];
            }
            if(array[i] % 2 !=1){
                array_right[right++] = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            if(i < left){
                array[i] = array_left[i];
            }else{
                array[i] = array_right[i-left];
            }
        }
    }
}
