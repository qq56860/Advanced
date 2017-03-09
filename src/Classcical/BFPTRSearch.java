package Classcical;

	/*
	 * BFPTR算法，又称为中位数的中位数算法
	 * 最坏时间复杂度为O(n)
	 * 求前K大的或者前K小的元素  
	 * 求第K大就是求第n-K+1小，这两者等价
	 * 
	 * 1、将输入数组的n个元素划分为n/5组，每组5个元素，且至多只有一个组由剩下的n%5个元素组成
	 * 2、寻找n/5个组中每一个组的中位数，首先对每组的元素进行插入排序，然后从排序过的序列中选出中位数
	 * 3、对于（2）中找出的n/5个中位数，递归进行步骤（1）和（2），直到只剩下一个数即为这n/5个元素的中位数，找到中位数后并找到对应的下标index
	 * 4、进行Partion划分过程，Partion划分中的pivot元素下标为index
	 * 5、进行高低区判断即可
	 * 
	 **/



public class BFPTRSearch {
	public static void main(String[] args) {
		int []nums = {123,45,43,215,67,234,456,65,48,3,41,54};
//		insertSort(nums,0,1);
//		print(nums);
		
		System.out.println(BFPTRSearch(nums, 0, nums.length-1, 11));//最后一个参数 为  K-1
		
		
	}
	
	public static int BFPTRSearch(int[]nums,int left,int right,int k){
		if(k >= nums.length){
			return -1;
		}
		if(nums.length < 5){
			insertSort(nums,0,nums.length-1);
			return nums[k-1];
		}
		
		int num = FindMid(nums, left, right);
		int index = FindId(nums, num);
		
		index = partion(nums, left, right, index);
		
		if(num > nums[k]){
			return BFPTRSearch(nums, left, index-1, k);
		}else if(num < nums[k]){
			return BFPTRSearch(nums, index+1, right, k);
		}else{
			return num;
		}
		
	}
	
	//划分
	public static int partion(int[]nums,int left,int right,int index){
		
		swap(nums[index], nums[left]);
		
		int i = left;
		int j = right;
		int temp = nums[left];
		
		while(i < j){
			//System.out.println(i+"--"+j);
			while(nums[j] >= temp && i < j){
				j--;
			}
			nums[i] = nums[j];
			//System.out.println(i+"---"+j);
			while(nums[i] <= temp && i < j){
				i++;
			}
			nums[j] = nums[i];
			//System.out.println(i+"----"+j);
		}
		nums[i] = temp;
		//System.out.println(i);
		return i;
	}
	
	//找中位数
	public static int FindMid(int[]nums,int left,int right){
		if(left == right){
			return nums[left];
		}
		
		int n = 0;
		int i = left;
		for (; i < right - 5; i += 5) {
			insertSort(nums,i,i + 4);  //+4 与判断条件当中 -5
			n = i - left;
			swap(nums[left + n/5], nums[i+2]);
		}
		
		if(i <= right){
			insertSort(nums, i, right);
			n = i - left;
			swap(nums[left + n/5], nums[i+(right-i)/2]);
			
		}
		n /= 5;
		
		//System.out.println("!!!!");
		
		return FindMid(nums, left, left+n);
	}
	
	//找中位数对应坐标
	public static int FindId(int[]nums,int num){
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] == num){
				return i;
			}
		}
		return -1;
	}
	
	//插入排序
	public static void insertSort(int []nums,int l,int h){
		if(nums.length == 0){
			return;
		}
		
		for (int i = l; i <= h; i++) {
			
			int temp = nums[i];
			int j = i;
			for (;j > l && temp < nums[j-1] ;) {
				nums[j] = nums[j-1];
				j--;
				
			}
			nums[j] = temp;
		}		
	}
	
	public static void swap(int a,int b){
		int temp = a;
		a = b;
		b = temp;
		
	}
	public static void print(int []nums){
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]+" ");
		}
		System.out.println();
	}
}
