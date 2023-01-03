package singleton1;
// 메모리영역에는 		데이터 영역          |       heap영역     이 있음
//				클래스 & static			일반변수

public class Single {
	private int i;
	private Single() {}
	
/*	private static Single INSTANCE1 = new Single(); // 처음부터 객체 만들기
	public static Single getInstance() {
	// 생성된 객체 주소를 return
		return INSTANCE;
	} // 둘 중 편한 것 사용
*/

	private static Single INSTANCE; //= null; 안 써도 null로 초기화됨 // 변수 > 객체 만들지 않아도 이미 메모리에 있음
	public static Single getInstance() { // 메소드 > 객체 만들지 않아도 이미 메모리에 있음
		// 객체 생성했으면 그 객체 주소를 리턴,
		// 객체 생성 안 했으면 객체생성하고 그 주소를 리턴
		if(INSTANCE==null) {
			INSTANCE= new Single(); // 객체 생성
		} 
		return INSTANCE;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
}
