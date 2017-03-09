package Algorithm;

import java.util.ArrayList;
	/*
	 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
	 * 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
	 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
	 * 
	 * 
	 * */
public class 顺时针打印矩阵 {
	
	public static void main(String[] args) {
		int [][] matrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};
		
		ArrayList<Integer> print = printMatrix(matrix);
		
		for (int i = 0; i < print.size(); i++) {
			System.out.println(print.get(i));
		}
	}
	
	public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> print = new ArrayList<Integer>();
        int row = 0;
        int col = 0;
        if(matrix.length > 0){
            for (int i = 0; i < matrix.length/2.0 && i < matrix[i].length/2.0; i++) {
                //System.out.println(i+"~~~~~~~");
                for(;row < matrix[col].length-i;row++){
                    print.add(matrix[col][row]);
                }
                row--;
                for(col = i+1;col < matrix.length-i;col++){
                    print.add(matrix[col][row]);
                }
                col--;
                for(row = row-1;row >= i && matrix.length > 2*i+1;row--){
                    print.add(matrix[col][row]);
                }
                row++;
                for(col = col-1;col >= i+1 && matrix[col].length > 2*i+1;col--){
                    print.add(matrix[col][row]);
                }
                col++;
                row++;
            }
        }
        return print;
    }
	
}
