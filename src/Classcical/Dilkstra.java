package Classcical;

import java.util.Arrays;
 	/*
 	 * Dijkstra算法  单起点全路径算法  ： 贪心算法原理
 	 * 1、令G = （V，E）为一个带权无向图。G中若有两个相邻的节点,i和j。aij(在这及其后面都表示为下标，请注意)为节点i到节点j的距离。
 	 * 每个节点都有一个值di(节点标记)表示其从起点到它的某条路的距离。
 	 * 
 	 * 2、算法初始有一个数组V用于储存未访问节点的列表，我们暂称为候选列表。选定节点1为起始节点。
 	 * 开始时，节点1的d1=0, 其他节点di=无穷大，V为所有节点。
 	 * 初始化条件后，然后开始迭代算法，直到V为空集时停止。
 	 * 
 	 * 具体迭代步骤如下：
 	 * 将d值最小的节点di从候选列表中移除。对于以该节点为起点的每一条边，不包括移除V的节点, 
 	 * (i, j)属于A， 若dj > di + aij,则令dj = di + aij,如果j已经从V中移除过，说明其最小距离已经计算出，不参与此次计算
 	 * 节点的d值  单调不增
 	 * 
 	 * */
public class Dilkstra {
	
	private static char[] Vexs;
	private static int[][] Matrix;
	private static final int MAX = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Vexs = new char[]{'A','B','C','D','E','F','G'};
		Matrix = new int[][]{
				{0,12,MAX,MAX,MAX,16,14},
				{12,0,10,MAX,MAX,7,MAX},
				{MAX,10,0,3,5,6,MAX},
				{MAX,MAX,3,0,4,MAX,MAX},
				{MAX,MAX,5,4,0,2,8},
				{16,7,6,MAX,2,0,9},
				{14,MAX,MAX,MAX,8,9,0},
		};
		
		int start = 3;
		
		int [] dist = dilkstra(start);
		
		System.out.println("~~~~~");
		for (int i = 0; i < dist.length; i++) {
			System.out.println("从"+Vexs[start]+"到"+Vexs[i]+"的距离为"+dist[i]);
		}
	}
	
	public static int[] dilkstra(int start){
		boolean[] flag = new boolean[Vexs.length];
		int []dist = new int[Vexs.length];
		int []pre = new int[Vexs.length];
		
		//初始化
		for (int i = 0; i < Vexs.length; i++) {
			flag[i] = false;
			dist[i] = Matrix[start][i];
			pre[i] = start;
		}
		//开始顶点
		int k = start;
		
		flag[start] = true;
		dist[start] = 0;
		pre[start] = -1;
		for (int i = 0; i < Vexs.length; i++) {
			int min = MAX;
			//找到距离最近的点
			for (int j = 0; j < Vexs.length; j++) {
				if(flag[j] == false && dist[j] < min){
					min = dist[j];
					k = j;
				}
			}
			
			flag[k] = true;
			//更新所有顶点的距离
			for (int j = 0; j < Vexs.length; j++) {
				int len = Matrix[k][j] == MAX ? MAX: min+Matrix[k][j];
				if(flag[j] == false && len < dist[j]){
					pre[j] = k;
					dist[j] = len;
				}
			}	
			
			System.out.println("第"+(i+2)+"步,k="+Vexs[k]+"...falg="+flag[k]);
			
			
		}
		
		
		return dist;
	}
}
