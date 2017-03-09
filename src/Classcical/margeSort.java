package Classcical;
	/*
	 * 归并（Merge）排序法是将两个（或两个以上）有序表合并成一个新的有序表
	 * 把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列。
	 * 
	 * 时间复杂度为O(nlogn)
	 * */
public class margeSort {
	public static void main(String[] args) {
		int[] nums = {3,423,123,78,45};
		sort(nums, 0, nums.length-1);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}
	
	public static void sort(int[]nums,int low,int high){
		int mid = (high + low) >> 1;
		
		if(low < high){
			//左边
			sort(nums,low,mid);
			//右边
			
			sort(nums,mid+1,high);
			//合并
			marge(nums, low, high, mid);
		}
		//return nums;
	}
	public static void marge(int[]nums,int low,int high,int mid){
		System.out.println("mid=" + mid);
		int[]temp = new int[high - low + 1];
		int tmp1 = low;
		int tmp2 = mid+1;
		int k = 0;
		//分别从两组数中取小的放入tmep中
		for (;k < temp.length && tmp1 < mid + 1 && tmp2 < high + 1;) {
			if(nums[tmp1] < nums[tmp2]){
				temp[k++] = nums[tmp1++];
			}else if(nums[tmp1] > nums[tmp2]){
				temp[k++] = nums[tmp2++];
			}else{
				temp[k++] = nums[tmp1++];
				temp[k++] = nums[tmp2++];
			}
		}
		//若左侧还有剩余
		while(tmp1 < mid + 1){
			temp[k++] = nums[tmp1++];
		}
		//右侧剩余
		while(tmp2 < high + 1){
			temp[k++] = nums[tmp2++];
		}
		//tmep覆盖nums
		for (int i = 0; i < temp.length; i++) {
			nums[low+i] = temp[i];
		}
	}
}
