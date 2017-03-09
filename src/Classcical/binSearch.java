package Classcical;
     /*
      * 二分查找 又叫折半查找
      * 每次取中间位置的值与待查关键字比较，
      * 如果中间位置的值比待查关键字大，则在前半部分循环这个查找的过程
      * 如果中间位置的值比待查关键字小，则在后半部分循环这个查找的过程
      * 
      * 直到查找到了为止，否则序列中没有待查的关键字  返回-1
      **/
public class binSearch {
	public static void main(String[] args) {
		int []arr = {1,2,3,4,5};
		System.out.println(binSearch(arr, 1, 0, arr.length-1));
		System.out.println(binSearch2(arr, 5));
	}
	
	//递归查找
	public static int binSearch(int []arr,int data,int left,int right){
		int mid = (left + right) >> 1;
		if(data < arr[mid]){
			return binSearch(arr, data, left, mid-1);
		}else if(data > arr[mid]){
			return binSearch(arr, data, mid+1, right);
		}else
			return mid;
	}
	
	//迭代查找
	public static int binSearch2(int []arr,int data){
		int left = 0,right = arr.length-1;
		int mid = (left + right) >> 1;
		while(data != arr[mid]){
			if(data < arr[mid]){
				right = mid-1;
				mid = (left + right) >> 1;
			}else if(data > arr[mid]){
				left = mid+1;
				mid = (left + right) >> 1;
			}
		}
		return mid;
	}
}
