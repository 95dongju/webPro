package singleton1;
// �޸𸮿������� 		������ ����          |       heap����     �� ����
//				Ŭ���� & static			�Ϲݺ���

public class Single {
	private int i;
	private Single() {}
	
/*	private static Single INSTANCE1 = new Single(); // ó������ ��ü �����
	public static Single getInstance() {
	// ������ ��ü �ּҸ� return
		return INSTANCE;
	} // �� �� ���� �� ���
*/

	private static Single INSTANCE; //= null; �� �ᵵ null�� �ʱ�ȭ�� // ���� > ��ü ������ �ʾƵ� �̹� �޸𸮿� ����
	public static Single getInstance() { // �޼ҵ� > ��ü ������ �ʾƵ� �̹� �޸𸮿� ����
		// ��ü ���������� �� ��ü �ּҸ� ����,
		// ��ü ���� �� ������ ��ü�����ϰ� �� �ּҸ� ����
		if(INSTANCE==null) {
			INSTANCE= new Single(); // ��ü ����
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
