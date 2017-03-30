package written_examination;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
	/*
	 * n: 源数据条数
	 * m：查询数据条数
	 * data[]：源数据数组   每个元素都是一个英文单词，组成一个英文句子
	 * query[]：查询数据数组
	 * 
	 * 要求：看作是 ---输入查询一个 查询句子query，去匹配data[]中，找出相同单词最多的一句data返回
	 * 
	 * */
public class toutiao_返回相同单词最多data {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String N_M[] = sc.nextLine().split(" ");
		int n = Integer.valueOf(N_M[0]);
		int m = Integer.valueOf(N_M[1]);
		
		String data[] = new String[n];
		String query[] = new String[m];
		
		for (int i = 0; i < n; i++) {
			data[i] = sc.nextLine();
		}
		for (int i = 0; i < m; i++) {
			query[i] = sc.nextLine();
		}
		
		List<HashMap<String, Integer>> list = new ArrayList<HashMap<String,Integer>>();
		for (int i = 0; i < n; i++) {
			HashMap<String, Integer> dataMap = new HashMap<String, Integer>();
			String dataSplit[] = data[i].split(" ");
			for (int j = 0; j < dataSplit.length; j++) {
				dataMap.put(dataSplit[j], i);
			}
			list.add(dataMap);
		}
		
		int[] same_count = new int[n];
		for (int i = 0; i < query.length; i++) {
			String querySplit[] = query[i].split(" ");
			for (int j = 0; j < querySplit.length; j++) {
				for (int j2 = 0; j2 < n; j2++) {
					if(list.get(j2).containsKey(querySplit[j])){
						
						same_count[j2] += 1 ;
					}
				}
			}
			
			int out = 0;
			for (int j = 0; j < same_count.length; j++) {
				if(same_count[j] > same_count[out]){
//					System.out.println("di"+j+"句多");
					out = j;
				}
			}
//			System.out.println("输出第"+out);
			System.out.println(data[out].toString());
		}
		
	}
}
