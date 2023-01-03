package singleton1;

public class SingleMain {
	public static void main(String[] args) {
		Single obj1 = Single.getInstance();
		Single obj2 = Single.getInstance();
		obj1.setI(200);
		System.out.println(obj1.getI());
		System.out.println(obj2.getI());
		if(obj1.equals(obj2)) { //equals 는 주소를 비교함
			System.out.println("obj1과 obj2는 하나");
		}
	}
}
