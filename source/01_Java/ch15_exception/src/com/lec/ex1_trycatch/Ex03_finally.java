package com.lec.ex1_trycatch;

public class Ex03_finally {
	public static void main(String[] args) {
		int[] aArr = {0,1,2};
		for(int i=0 ; i<=aArr.length ; i++) {
			try {
				System.out.println("arr[" +i+"] = " +aArr[i]);
			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("���ܸ޽���: " +e.getMessage());
			}finally { // ���ܰ� �߻��ǵ� �ȵǵ� �׻� ������ ==> try�� catch������ ������ ���� ���� �� ������ �۾��� finally������ ��
				System.out.println("try�� ���� �Ŀ���, catch�� �����Ŀ��� ����Ǵ� ��");
			}
		}//for
	}//main
}
