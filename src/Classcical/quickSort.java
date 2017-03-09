package Classcical;
	
	/*
	 * 快速排序
	 * 基于分治的思想，是冒泡排序的改进型
	 * 
	 * 首先在数组中选择一个基准点：三数取中切分
	 * 将选取的基准点放在数组最左侧
	 * 
	 * 首先从后半部分开始，如果发现有元素比该基准点的值小，就交换lo和hi位置的值，
	 * 然后从前半部分开始扫秒，发现有元素大于基准点的值，就交换lo和hi位置的值，
	 * 如此往复循环，直到lo>=hi,然后把基准点的值放到hi这个位置
	 * 
	 * 采用递归的方式分别对前半部分和后半部分排序，当前半部分和后半部分均有序时该数组就自然有序了。
	 * */


public class quickSort {
	public static void main(String[] args) {
		
		int []arr = {125,4,65,32,1,48,5,69};
		quickSort(arr,0,arr.length-1);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println("~~~~~~~~~~~~~~~~");
		
		
		
		
	}
	//快速排序，升序
	public static void quickSort(int []arr,int left,int right){
		if(left > right){
			return ;
		}
		
		int index = partition(arr,left,right);
		quickSort(arr,left,index-1);
		quickSort(arr,index+1,right);
		
	}
	//三数取中
	public static int partition(int[]arr,int left,int right){
		int mid = (left + right) >> 1;
		//System.out.println(mid);
		if(arr[left] > arr[right]){
			swap(arr[left], arr[right]);
		}
		if(arr[mid] > arr[right]){
			swap(arr[mid], arr[right]);
		}
		if(arr[mid] > arr[left]){
			swap(arr[left], arr[mid]);
		}
		//基准一开始放在left上
		int key = arr[left];
		while(left < right){
			System.out.println("left:"+left+"~~right:"+right);
			while(left < right && arr[right] >= key){
				right--;
			}
			arr[left] = arr[right];
			while(left < right && arr[left] <= key){
				left++;
			}
			arr[right] = arr[left];
		}
		arr[right] = key;
		//System.out.println(right);
		return right;
	}
	public static void swap(int a,int b){
		int temp = a;
		a = b;
		b = temp;
	}
	
	
	//插入排序，升序
	public static int[] insertSort(int [] arr){
		for(int out = 1 ; out < arr.length ;out++){
			int temp = arr[out];
			int in = out;
			while(in > 0 && temp < arr[in-1]){
				arr[in] = arr[in-1];
				in--;
			}
			arr[in] = temp;
		}
		return arr;
	}
	
}	
