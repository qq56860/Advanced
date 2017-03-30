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
