package com.lec.ex;
// �迭 ��� ���
public class Ex01 {
	public static void main(String[] args) {
		int i = 10; // (���� ����, int ����) ���� ����� �ʱ�ȭ ���ÿ�
		// �迭�� ġ������ ����: Ȯ���� ���������� ��� ������. �ѹ� �迭���� ������ ���õǸ� ������ �� ����. ��, ��Ȯ�� ���� ������ �Ϳ����� �����. �׷��� �÷����� �ַ� ���. �÷����� �迭�� ��� ��� ����.
		// 1. �迭 ���� ����� �ʱ�ȭ ([]���谡 �迭�� �ǹ���)
		int[] iArr = {10, 20, 30, 40, 50}; // <{} �ȿ� �� ���� �ε���, ������ 0���� �����ϱ� ������ �ε����� 4���� ���ٴ� ���� ���� 5�� �����ٴ� ���� �ǹ�.
		iArr[2] = 300; // �迭�� index�� ���� (0~4) > �ε��� 2 == 30 ���� 300���� ����
		for(int idx =0 ; idx<iArr.length ; idx++) { //length �迭 ���� ���� = ���ڰ� �ٲ�� ������ �ִٸ� length ���� ��
			System.out.println(iArr[idx]);
		 }
		// 2. �迭 ������ ����� �迭 �޸� ���� Ȯ��
		int[] iArr2 = new int[5]; // new�� �޸� ������ �Ҵ��Ű�� ������ >> int 5�� ������ �Ҵ���
		iArr2[0] = 999;
		for(int idx=0 ; idx<iArr2.length ; idx++) {
			System.out.printf("iArr2[%d] = %d\n", idx, iArr2[idx]);
		}
		// 3. �迭 ���� ����
		int[] iArr3;
		iArr3 = new int[3]; // {0, 0, 0} 0���� �ʱ�ȭ�� >> �迭 ���� Ȯ����
		// Ȯ�� for�� ���� ��! >> �Ϲ� ����ó�� ���° ~, ��� �� �� ����
		for(int temp : iArr3) {
			System.out.println(temp);
		}
		// �Ϲ� for���� �̿��� �迭 ���� ���� �����ϴ� ���!
		for(int idx=0 ; idx<iArr3.length ; idx++) {
			iArr3[idx] = 999;
		}
		for(int idx=0 ; idx<iArr3.length ; idx++) {
			System.out.println(idx+"��°: " + iArr3[idx]);
		}
		// Ȯ�� for���� �̿��� �迭 ���� ���� �����ϴ� ��� >> �Ұ���
		for(int ia : iArr3) {
			ia = 111;
			System.out.println(ia);
		}
		for(int ia : iArr3) {
			System.out.println(ia);
		}
	}
}
