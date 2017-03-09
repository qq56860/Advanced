package Classcical;
	/*
	 * 堆排序   利用完全二叉树
	 * 每一个结点值都要大于或等于它的孩子结点值
	 * 
	 * 初始时调整排序的数的存储序，使之成为一个 堆，这时堆的根节点的数最大
	 * 然后将根节点与堆的最后一个节点交换。然后对前面(n-1)个数重新调整使之成为堆
	 * 依此类推，直到只有两个节点的堆，并对 它们作交换，最后得到有n个节点的有序序列
	 * 
	 * 需要两个过程，一是建立堆，二是堆顶与堆的最后一个元素交换位置。
	 * */
public class heapSort {
	public static void main(String[] args) {
		int[] data5 = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
		
		heapSort(data5);
		
		System.out.println("排序后");
		
		print(data5);
		
	}
	//堆排序，升序
	public static void heapSort(int []nums){
		for (int i = 0; i < nums.length; i++) {
			createHeap(nums, 0, nums.length-1-i);
			//交换根节点上最大数到最后
			swap(nums, 0, nums.length-1-i);
			print(nums);
		}
	}
	//重建堆
	public static void createHeap(int[]nums,int low,int high){
		//从低层向上的找出最大数
		for (int i = (high-1) >> 1; i >= 0; i--) {
			int k = i;
			if ((k << 1) + 1 <= high) {
				int biggerindex = (k << 1) +1;
				//找出左右节点较大值
				if(biggerindex < high){
					//有右子节点
					if(nums[biggerindex] < nums[biggerindex + 1]){
						biggerindex++;
					}
				}
		
				//使父节点为最大值
				if(nums[k] < nums[biggerindex]){
					swap(nums, k, biggerindex);
//					k=biggerindex;
				}
//				else {  
//                    break;  
//                } 
				
			}
		}
	}
	
	public static void swap(int[]nums,int a,int b){
		if(a == b){
			return;
		}
		nums[a] = nums[a] + nums[b];
		nums[b] = nums[a] - nums[b];
		nums[a] = nums[a] - nums[b];
	}
	public static void print(int [] nums){
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]+" ");
		}
		System.out.println();
	}
}
