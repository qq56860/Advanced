package written_examination;

import java.util.Scanner;
	/*
	 * param:n 数组长度
	 * param:Fn[]  那个元素的值
	 * 
	 * 结果是让求出：最大的一个   先递增-后增减  的区间 ，即 起始点和终止点 x 值相差最大
	 * 
	 * */
public class toutiao_先递增后递减最大区间 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.valueOf(sc.nextLine());
		String FN[] = sc.nextLine().split(" ");
		
		int Fn[] = new int[n];
		for (int i = 0; i < FN.length; i++) {
			Fn[i] = Integer.valueOf(FN[i]);
		}
		
		boolean flagUp = false;
		boolean flagDown = false;
		int start = -1;
		int end = -1;
		int retStart = -1;
		int retEnd = -1;
		for (int i = 1; i < Fn.length; i++) {
			
			if(Fn[i] > Fn[i-1]){
				
				if(flagUp == false){
					if(flagDown == true){
						flagDown =false;
						end = i-1;
						if( (end-start) > (retEnd-retStart) ){
							retStart = start;
							retEnd = end;
						}
					}
					start = i-1;
					flagUp = true;
				}
				continue;
			}else{
				if(flagUp = true){
					flagUp = false;
					flagDown = true;
				}
			}
			
		}
		
		System.out.print(retStart+" "+retEnd);
	}
}
