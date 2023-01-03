package singleton2;

public class FirstClass {
	public FirstClass() {
		System.out.println("FirstClass 생성자 실행중");
		SingletonClass singletonObject = SingletonClass.getInstance(); //new를 할 수 없음
		System.out.println("싱글톤 객체의 i값 : " +singletonObject.getI());
		singletonObject.setI(999);
		System.out.println("싱글톤 객체의 i값 수정 후 : " +singletonObject.getI());
	}
}
