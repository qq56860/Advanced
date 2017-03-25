package Algorithm;


import java.util.Scanner;

/*
 * 刚才做的网易有道的一个题。
 * 题目不难，不过卡到这个Scanner的nextLine上了。。。
 * 现在发现next...不能和nextLine混用
 * 
 * 大概意思：一人忽然有急事儿要回办公司，怎么回去最快
 * n:附近有几个出租车
 * tX[i]:这几个出租车的横坐标
 * tY[i]:这几个出租车的纵坐标
 * gXgY:办公司地点 空格分割
 * time:步行和出租车到邻接接到单位时间 空格分割
 * 
 * */

public class NETEASE_最快时间回到办公司 {
	
	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
		
		int n = Integer.valueOf(sc.nextLine());
		//System.out.println("STRX");
		String STRX = sc.nextLine();
		//System.out.println("STRY");
		String STRY = sc.nextLine();
		
		String[] ttX = STRX.split(" ");
		String[] ttY = STRY.split(" ");
		int[] tX = new int[n];
		int[] tY = new int[n];
		for (int i = 0; i < n; i++) {
			tX[i] = Integer.valueOf(ttX[i]);
			tY[i] = Integer.valueOf(ttY[i]);
		}
        
        String gXgY = sc.nextLine();
        String time = sc.nextLine();
        
        
        
//        if(n < 0){
//			System.out.print(-1);
//		}
		
		int walkTime = Integer.valueOf(time.split(" ")[0]);
		int taxiTime = Integer.valueOf(time.split(" ")[1]);
		
		int gX = Integer.valueOf(gXgY.split(" ")[0]);
		int gY = Integer.valueOf(gXgY.split(" ")[1]);
		
		int realX = getReal(gX);
		int realY = getReal(gY);
		
//		if(walkTime*(realX + realY) <= taxiTime*(realX + realY)){
//			System.out.print(walkTime*(realX + realY));
//		}
		
		int nearlyXY = 0;
		int nearlyX = getReal(tX[0]);
		int nearlyY = getReal(tY[0]);
		for (int i = 2; i <= n; i++) {
			int X = getReal(tX[i-1]);
			int Y = getReal(tY[i-1]);
			if( (X + Y) < (nearlyX + nearlyY) ){
				nearlyX = X;
				nearlyY = Y;
				nearlyXY = i-1;
			}
		}
//		System.out.println(nearlyXY);
//		System.out.println(tX[nearlyXY]);
//		System.out.println(tY[nearlyXY]);
//		
		realX = getReal(gX - tX[nearlyXY]);
		realY = getReal(gY - tY[nearlyXY]);
		if( walkTime*(getReal(gX) + getReal(gY)) <= 
				(taxiTime*(realX + realY) + walkTime*(tX[nearlyXY] + getReal(tY[nearlyXY])) ) ){
			System.out.print(walkTime*(getReal(gX) + getReal(gY)));
		}else{
			System.out.print((taxiTime*(realX + realY) + walkTime*(getReal(tX[nearlyXY]) + getReal(tY[nearlyXY]))));
		}
		
	}
	
	
	
	public static int getReal(int a){
		if(a >= 0){
			return a;
		}else{
			return a*(-1);
		}
	}
	
}
