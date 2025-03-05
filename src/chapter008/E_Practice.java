package chapter008;

// 추상 클래스
// : 모바일 어플리케이션
abstract class MobileApp {
	// 추상 메서드 : 실행(execute)에 대한 동작 정의
	// - 각 앱마다 '고유한 실행' 정의는 상속받은 클래스에서 구현
	abstract void execute();
	
	// 일반 메서드   ? 인터페이스와의 차이: 인터페이스에는 일반 메서드 구현이 안된다??
	void appInfo() {
		System.out.println("This is a mobile app");
	}
	
}

// == 게임 어플 == //
class GameApp extends MobileApp {

	@Override
	void execute() {
		System.out.println("Game app executes");
		
	}
}

// == social 어플 == //

class SocialApp extends MobileApp {
	
	String name;
	
	// 생성자
	SocialApp(String name){
		this.name = name;
	}

	// 재정의 메서드
	@Override
	void execute() {
		System.out.println(name + " app executes");
	}
	
	@Override
	void appInfo() {
		System.out.println(name + " app is most popular social app");
	}
		
	// 고유 메서드
	void shareContent(String content) {
		System.out.println(name + " shares: " + content);
	}
	
}

// ======= 실행 == //

public class E_Practice {
	public static void main(String[] args) {
		// == 다형성 적용 == //
		MobileApp gameApp = new GameApp();
		MobileApp socialApp = new SocialApp("Instagram");
		
		// 다형성 적용에 의해 공통된 메서드 호출 가능
		gameApp.execute(); // Game app executes (재정의한 메서드)
		gameApp.appInfo(); // This is a mobile app 
		
		socialApp.execute();  // Instagram app executes
		socialApp.appInfo();  // Instagram app is most popular social app

//		socialApp.shareContent("images"); => 업캐스팅했기 때문에 고유 메서드 접근 불가

		// == 형 변환 == //
		if (socialApp instanceof GameApp) { // false
			System.out.println("socialApp이 GameApp 타입의 객체");
			GameApp onlygameApp = (GameApp) socialApp;
		}else if(socialApp instanceof SocialApp) { // true  => 아래의 코드가 실행됨
			System.out.println("socialApp은 SocialApp타입의 객체");
			SocialApp onlySocialApp = (SocialApp) socialApp; // 다운 캐스팅
			
			onlySocialApp.shareContent("images");  // 고유메서드 실행
		}
		
		
		// == 객체 배열 & 다형성 활용 == //
		
		// 배열 생성 (정적 배열)
		MobileApp[] apps = { // 데이터 타입이 MobileApp
				// 생성과 동시에 업캐스팅 (묵시적 형변환)
				new GameApp(),
				new SocialApp("Facebook"),
				new SocialApp("KakaoTalk")	
		};
		
		for (MobileApp app: apps) {
			app.execute();
			app.appInfo();
			
			if(app instanceof SocialApp) {
				// 다운 캐스팅하기
				SocialApp specificSocialApp = (SocialApp) app;
				specificSocialApp.shareContent("Files"); // 고유 메서드 실행
			}
		}
		
		/*
		  결과 :
		  	Game app executes
			This is a mobile app
			Facebook app executes
			Facebook app is most popular social app
			Facebook shares: Files
			KakaoTalk app executes
			KakaoTalk app is most popular social app
			KakaoTalk shares: Files
		  
		 */

	}

}
