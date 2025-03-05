package sjs01;

import java.util.Scanner;

public class Chapter13_array_lotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 로또 번호 생성기
		 * 1 ~ 45 사이의 숫자 : 6개 랜덤 추출 + 1개 보너스
		 * 1등 : 6개 번호 다 맞음
		 * 2등 : 5개 번호 맞음, 나머지 한개는 보너스와 같은 번호
		 * 3등 : 5개 번호 맞고, 나머지 한개가 보너스와 다름
		 * 4등 : 4개 번호 맞음
		 * 5등 : 3개 번호 맞음
		 */
		
		/*
		 * 구현하기 전 구상
		 * System : 1 ~ 45번
		 * (1) 6 + 1 = 7개 추출, (2) 각 번호 중복 안됨, (3) 랜덤 추출
		 */
		
		//1단계
		
		int[] lottoMachine = new int[45];
		
		int[] lottoBalls = new int[6]; //선택된 로또번호 저장
		
		int bonusNumber = 0; //보너스 번호 저장
		
		//1번부터 45번까지의 공을 생성
		for(int i = 0; i < lottoMachine.length; i++) {
			lottoMachine[i] = i + 1;
		}
		
		int count = 0; //공을 몇개 꺼냈나
		
		while(count < 7) {
			//공을 선택하는 위치(배열의 index : 0 ~ 44(1번~45번))를 랜덤함수로 고름
			//공을 하나씩 뽑을 수록 채워야할 index 값이 줄어듦
			int index = (int)(Math.random() * 45);
			
			
			//선택된 index의 값이 0이 아니면 아직 미사용..0이면 사용된 위치
			if (lottoMachine[index] != 0) {
				if (count < 6) {
					lottoBalls[count++] = lottoMachine[index];
				}else {
					bonusNumber = lottoMachine[index];
					count++;
				}
				lottoMachine[index] = 0; //사용했다는 증명
				
			}
		} 
		
		//system 로또 생성 검증
		for(int i = 0; i < lottoBalls.length; i++) {
			System.out.print(lottoBalls[i] + " ");
		}
		System.out.println("보너스번호 : " + bonusNumber);
		
		//사용자가 선택
		count = 0;
		Scanner scan = new Scanner(System.in);
		
		//사용자 로또 저장 배열
		int[] userLotto = new int[6];
		
		while(count < 6) { //번호 6개 고르기
			System.out.println((count + 1) + "번째 로또 번호 : ");
			int balls = scan.nextInt();	
			
			//중복 체크
			for(int i = 0; i < count; i++) {
				if(userLotto[i] == balls) {
					System.out.println(balls + "는 이미 존재하는 번호입니다.");
					balls = 0; //중복되었다는 의미
					break;
				}
			}
			//0은 중복의 의미
			if (balls != 0) {
				userLotto[count++] = balls;
			}
		
		}
		scan.close();
		
		System.out.println("사용자 로또 : ");
		for(int i = 0; i < userLotto.length; i++) {
			System.out.print(userLotto[i] + " ");
		}
		
		System.out.println();
		
		
		int matchCount = 0;
		boolean isBonus = false; 
		
		//비교
		for(int i = 0; i < userLotto.length; i++) {
			for(int j = 0; j < lottoBalls.length; j++) {
				
				if(userLotto[i] == lottoBalls[j]) {
					matchCount++;
					break;
				}
			}
			
			//보너스 번호 찾기
			if(!isBonus) { //isBonus == false와 같음
				if(userLotto[i] == bonusNumber) {
					isBonus = true;
				}
			}
		}
		
		//등수 출력
		if(matchCount == 6) {
			System.out.println("대박! 1동!");
		}else if(matchCount == 5 && isBonus) {
			System.out.println("2등입니다!");
		}else if(matchCount == 5) {
			System.out.println("3등입니다!");
		}else if(matchCount == 4) {
			System.out.println("4등입니다!");
		}else if(matchCount == 3) {
			System.out.println("5등입니다!");
		}else {
			System.out.println("낙첨...");
		}
	}

}
