
public class Hello {
	public static void main(String[] args) {
		System.out.print("Hello");
		for(int i=0 ; i<args.length ; i++) {
			System.out.print(",  "+args[i]);
		}
	}
}
