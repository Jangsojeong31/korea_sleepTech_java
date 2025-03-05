package chapter005;

class BaseballPlayer {
	
	String name;
	double battingAverage;
	int homeRuns;
	
	static int playerCount; // 모든 인스턴스에서 공유
	
	// 생성자
	BaseballPlayer(String name, double battingAverage, int homeRuns) {
		this.name = name;
		this.battingAverage = battingAverage;
		this.homeRuns = homeRuns;
		
		playerCount++;
		
	}
	
	
	// 메서드
	// 1) 인스턴스 메서드
	void updateStatus(double newBattingAverage, int newHomeRuns) {
		battingAverage = newBattingAverage;
		homeRuns = newHomeRuns;
	}
	
	// 2) 정적 메서드
	// : 특정 홈런 수 이상인 선수를 평가
	static String evaluateHomeRun (int homeRunCount) {
		if (homeRunCount > 20) {
			return "홈런상 후보에 등록됩니다.";
		} else {
			return "홈런상 후보에 등록될 수 없습니다.";
		}
	}
	
	
}

public class E_Practice {
	public static void main(String[] args) {
		
		// 인스턴스 생성
		BaseballPlayer player1 = new BaseballPlayer("윤영서", 0.325, 16);
		BaseballPlayer player2 = new BaseballPlayer("문창배", 0.293, 20);
		BaseballPlayer player3 = new BaseballPlayer("전창현", 0.301, 11);
		BaseballPlayer player4 = new BaseballPlayer("고혁재", 0.292, 21);
		
		System.out.println("총 생성된 선수의 수: " + BaseballPlayer.playerCount);
		// 총 생성된 선수의 수: 4
		
		// 메서드 사용
		player2.updateStatus(0.312, 22);
		System.out.println(player2.battingAverage);
		System.out.println(player2.homeRuns);
		
		// 정적 메서드 사용
		System.out.println(BaseballPlayer.evaluateHomeRun(player3.homeRuns));  // player3.homeRuns는 인자로 사용됨
		System.out.println(BaseballPlayer.evaluateHomeRun(player4.homeRuns));
		
	}

}
