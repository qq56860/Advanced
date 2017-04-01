package written_examination;


import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;



/*
 * 
 * 有一个单词列表，一个初始单词和一个最终单词，初始单词需要通过单词列表逐步变换到最终单词，求变换所需的最短变换路径长度。
 * 
 * trick: 类似于广度优先搜索，用 Set ，将遍历过的单词存入set中
 * 
 * 		有一个小伙子很厉害，先从开始的单词执行，然后把关联单词放到 结果集set中，然后再从end单词开始，每次都从set中个数小的执行搜索。。。
 * */
public class qunar_单词变换 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String start = sc.nextLine();
		String end = sc.nextLine();
		
		String str[] = sc.nextLine().split(" ");
		
		System.out.println(findShortPath(start, end, str));
		
	}
	
	private static int findShortPath(String start,String end,String str[]){
		
		int pathLength = 1;
		
		Set<String> startSet = new HashSet<String>();
		Set<String> endSet = new HashSet<String>();
		startSet.add(start);
		endSet.add(end);
		
		Set<String> wordSet = new HashSet<String>();
		Collections.addAll(wordSet, str);
		
		Set<String> visited = new HashSet<String>();
		while(!startSet.isEmpty() && !endSet.isEmpty()){
			//这个if循环很巧妙
			if(startSet.size() > endSet.size() ){
				Set<String> set = startSet;
				startSet = endSet;
				endSet = set;
//				System.out.println(1);
			}
			
			Set<String> temp = new HashSet<String>();
			for (String word : startSet) {
//				System.out.println(word);
				char []ch = word.toCharArray();
				for (int i = 0; i < ch.length; i++) {
					char old = ch[i];
					for (char c = 'a'; c <= 'z'; c++) {
						ch[i] = c;
						String strWord = String.valueOf(ch);
						if(endSet.contains(strWord)){
							return pathLength+1;
						}
						if(!visited.contains(strWord) && wordSet.contains(strWord)){
							temp.add(strWord);
							visited.add(strWord);
						}
					}
					ch[i] = old;
				}
				
			}//for
			pathLength++;
			startSet = temp;
			
		}//while
		
		return pathLength;
	}
	

	
	
}
