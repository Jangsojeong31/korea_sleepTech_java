package chapter16;

import java.util.Arrays;

/*
 * 마방진 : 가로 줄의 합과, 세로 줄의 합과, 대각선의 합이 동일
 * 5 * 5 2차배열 : 행 index 0~4 / 열 index 0~4
 * (0,2)에서 1부터 시작 ~ 25까지
 * 1) 대각선 위(행 -1), 오른쪽(열 +1) 이동
 * 1-1) row가 벗어난 경우 -> 해당 열의 제일 마지막 행으로 이동 : (0,2)=1 -> (-1,3);벗어남 -> (4,3)=2
 * 1-2) 열이 벗어난 경우 -> 헤당 행의 제일 첫번째 열로 이동
 * 1-3) 위치에 이미 값이 있는 경우 -> 바로 아래 칸으로 이동(행 + 2, 열 -1)
 * 1-4) 행과 열이 모두 벗어난 경우 -> 1-3)과 동일
 */

public class MultiDimensionalArray03 {
	public static void main(String[] args) {
		
		int[][] mabagjin = new int[5][5];
		int row = 0; //행의 위치
		int col = 2; //열의 위치
		
		//마방진 시작위치 설정
		mabagjin[row][col] = 1;  //mabagjin[0][2] = 1에서 시작
		
		for(int i = 2; i <= 25; i++ ) {  //들어갈 값
			//위치 이동 - 오른쪽 대각선 위
			row--;
			col++;
			
			//1. row가 벗어난 경우
			if(row < 0 && col < 5) {
				//해당 열의 마지막 행
				row = 4;
			}
			//2. 열이 벗어난 경우
			if(row >= 0 && col > 4) {
				//해당 열의 마지막 행
				col = 0;
			}
			//3. 둘다 벗어난 경우
			if(row < 0 && col > 4) {
				row += 2;
				col --;
			}
			//4. 이미 다른 값이 있을 떄
			if(mabagjin[row][col] != 0) { //기본값은 0
				row +=2 ;
				col --;
			}
			
			mabagjin[row][col] = i;
		}
		
		for(int i = 0; i < mabagjin.length; i++) {
			System.out.println(Arrays.toString(mabagjin[i]));
		}
		
	}

}
