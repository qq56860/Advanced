package Algorithm;
	/*
	 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
	 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
	 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
	 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
	 * */
public class 旋转数组的最小数字 {
	public static void main(String[] args) {
		int[]array = {3,4,5,1,2};
		int result = minNumberInRotateArray(array);
		System.out.println(result);
	}
	
	
    public static int minNumberInRotateArray(int [] array) {
        int result = 0;
        if(array.length > 0 ){
            //Arrays.sort(array);
            result = array[0];
            for (int i = 1; i < array.length; i++) {
                if(array[i] < array[i-1]){
                    result = array[i];
                }
            }
             
        }else{
            return 0;
        }
             
        return result;
    }
	
	
}
