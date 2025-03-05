package chapter14;

public class CopyofArray03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//deep copy 두번째 방법 : System.arraycopy
		/*
		 * 클래스 System 의 arrayCopy
		 * arrayCopy(복사할 배열, 복사할 시작 index, 대상배열, 대상배열 복사길이)
		 * ex) card = {1, 2, 3, 4, 5}
		 * arrayCopy(card, 1, newCard, length)
		 */
		
		int[] cards = {1,6,9,8,2,7};
		int[] newCards = new int[5];
		
		//복사 메서드 이용
		System.arraycopy(cards, 1, newCards, 0, newCards.length);
		
//		cards[3] = 11;
		
		System.out.println("card : ");
		for(int i = 0; i < cards.length; i++) {
			System.out.print(cards[i] + "\t");
		}
		
		System.out.println();
	
		System.out.println("newCards : ");
		for(int i = 0; i < newCards.length; i++) {
			System.out.print(newCards[i] + "\t");
		}
		
	

	}

}
