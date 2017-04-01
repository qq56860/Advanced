package written_examination;

import java.util.Scanner;

/*
 * 用英文字母a-z来分别表示数值0-25, 形成一个26进制的数值表示法
 * 
 * trick:  结果要用long表示。。。
 * 
 * */
public class qunar_进制转换 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		

		while(sc.hasNextLine()){
			change(sc.nextLine());
		}
		
			
	}
	
	private static void change(String str){
		Long result = 0L;
		char b[] = str.toCharArray();
		for (int i = b.length -1 ; i >= 0; i--) {
			int num = oneOnOne.inStrOutInt(b[i]);
//			System.out.println('返回'+num);
			result = (long) (num * Math.pow(26, b.length - 1 - i) + result);
		}
		System.out.println(result);
	}
	
	
}

class oneOnOne{
	static int inStrOutInt(char key){
		switch (key) {
		case 'a':
			return 0;
		case 'b':
			return 1;
		case 'c':
			return 2;
		case 'd':
			return 3;
		case 'e':
			return 4;
		case 'f':
			return 5;
		case 'g':
			return 6;
		case 'h':
			return 7;
		case 'i':
			return 8;	
		case 'j':
			return 9;
		case 'k':
			return 10;
		case 'l':
			return 11;
		case 'm':
			return 12;
		case 'n':
			return 13;
		case 'o':
			return 14;
		case 'p':
			return 15;
		case 'q':
			return 16;
		case 'r':
			return 17;
		case 's':
			return 18;
		case 't':
			return 19;
		case 'u':
			return 20;
		case 'v':
			return 21;
		case 'w':
			return 22;
		case 'x':
			return 23;
		case 'y':
			return 24;
		case 'z':
			return 25;
		default:
			return -1;
		}
	}
}
