package singleton2;

public class MainSing {
	public static void main(String[] args) {
		SecondClass secondObj = new SecondClass();
		FirstClass firstObj = new FirstClass();
		SingletonClass singObj = SingletonClass.getInstance();
		System.out.println("main�Լ����� singleton ��ü�� i�� : " +singObj.getI());
	}
}