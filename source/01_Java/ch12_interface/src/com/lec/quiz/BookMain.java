package com.lec.quiz;

import java.util.Scanner;

public class BookMain {
	public static void main(String[] args) {
		BookLib[] books = {new BookLib("890��-01-11","java","ȫ�浿"),
						new BookLib("890��-01-12","oracle","���浿"),
						new BookLib("890��-02-11","mysql","���浿"),
						new BookLib("890��-01-01","jbdc","���̵�"),
						new BookLib("890��-01-01","html","�̿���"),};
		Scanner scanner = new Scanner(System.in);
		int fn; // ��ɹ�ȣ (1:���� / 2:�ݳ� /3:å����Ʈ / 0:����)
		int idx; // �����ϰų� �ݳ��� ��, ��ȸ�� å�� index
		String bTitle, borrower, checkOutDate;
		do {
			System.out.print("1: ���� / 2: �ݳ� / 3: å ����Ʈ / 0: ����");
			fn = scanner.nextInt();
			switch(fn) {
			case 1: // ������� : 1.å �̸� �Է� �ޱ� > 2.å ��ȸ > 3.å����Ȯ�� > 4.������ �Է� > 5.������ �Է� > 6.����޼ҵ� ȣ��
				// 1.å�̸� �Է�
				System.out.print("�����ϰ��� �ϴ� å �̸��� �Է��ϼ���: ");
				bTitle = scanner.next(); // white-space �ձ����� ��Ʈ���� ����					
				// 2.å ��ȸ
//				for (int idx=0 ; idx<books.length ; idx++) // idx�� ���⿡ �����ϸ� ������ ������ �� idx�� ��, �׷��� ������ �����ؾ� ��
				for(idx=0 ; idx<books.length ; idx++) {
					if(bTitle.equals(books[idx].getBookTitle())) { // String���� ���� ���� .equals �����
						break; // if�� true�� ����������, false�� �ٽ� for���� ��
					}
				}// for --> idx��° å���� ����
				if(idx == books.length) {
					System.out.print("���� �������� ���� �����Դϴ�.");
				}else { // book[idx] ������ �����ϰڴ�
					// 3.å ���� Ȯ��
					if (books[idx].getState() == BookLib.STATE_BORROWED) {
						System.out.println("���� ���� �����Դϴ�");
					}else {
					// 4.������ �Է�
						System.out.print("�������� �Է��ϼ���: ");
						borrower = scanner.next(); // space ������ �ȵ�
					// 5.������ �Է�
						System.out.print("�������� �Է��ϼ���: ");
						checkOutDate = scanner.next(); // space ������ �ȵ�
					// 6.���� �޼ҵ� ȣ��
						books[idx].checkOut(borrower, checkOutDate);
					} // if - ����Ȯ��
				} // if - ���� ��ȸ
				break;
			case 2: // �ݳ����� : 1.å �̸� �Է� > 2.å ��ȸ > 3.�ݳ��޼ҵ� ȣ��
				System.out.println("�ݳ��ϰ��� �ϴ� å �̸��� �Է��ϼ���: ");
				bTitle = scanner.next();
				for(idx=0 ; idx<books.length ; idx++) {
					if(bTitle.equals(books[idx].getBookTitle())) { // String���� ���� ���� .equals �����
						break; // if�� true�� ����������, false�� �ٽ� for���� ��
					}
				}
				if(idx == books.length) {
					System.out.println("�ش� ������ �� �������� å�� �ƴմϴ�");
				}else {
					// �ݳ� �޼ҵ� ȣ��
					books[idx].checkIn();
				}
				break;
			case 3: // å ����Ʈ ��� : for���� �̿��ؼ� ���
				for(BookLib book : books) {
					book.printState();
				}
			}
		}while(fn!=0);
		System.out.println("�����մϴ�");
	}
}