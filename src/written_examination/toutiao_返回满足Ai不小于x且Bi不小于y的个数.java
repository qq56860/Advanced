package written_examination;

import java.util.Scanner;
/*
 * n：   源数据个数；
 * q:查询数据个数；
 * A[]：
 * B[]：
 * X_Y：x 和 y的值
 * 
 * 要求：  返回满足 A[i] >= x  && B[i] >= y  的个数
 * 
 * 
 * 暴力的 O(n * q) 的做法  效率太低。。。。。
 * 
 * 把原先所有 (A[i], B[i]) 整数对按照 A 排序，所有查询按照 x 排序。
 * 随后从小到大扫描所有查询 (x[i], y[i])，维护一个指针 k 指向 AB 对中满足 A[k] >= x[i] 的位置。
 * 对于当前的这次查询，要求的就是所有大于 k 的位置中，满足 B[k] >= y[i] 的数量
 * 这种做法时间复杂度O(n + qlogn)
 * 
 * */
public class toutiao_返回满足Ai不小于x且Bi不小于y的个数 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String N_M[] = sc.nextLine().split(" ");
		int n = Integer.valueOf(N_M[0]);
		int q = Integer.valueOf(N_M[1]);
		
		String strA[] = sc.nextLine().split(" ");
		String strB[] = sc.nextLine().split(" ");
		
		int A[] = new int[n];
		int B[] = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = Integer.valueOf(strA[i]);
			B[i] = Integer.valueOf(strA[i]);
		}
		
		String []query = new String[q];
		for (int i = 0; i < q; i++) {
			query[i] = sc.nextLine();
		}
		
		
		for (int i = 0; i < q; i++) {
//			System.out.println(query[i]);
			String X_Y[] = query[i].split(" ");
			int x = Integer.valueOf(X_Y[0]);
			int y = Integer.valueOf(X_Y[1]);
			
			int out = 0;
			for (int j = 0; j < n; j++) {
				if( A[j] >= x && B[j] >= y){
					
					out += 1;
				}
			}
			System.out.println(out);
		}
		
		
	}
}
