package com.lec.ex12_account;

public class CheckingAccount extends Account {
	
	private String cardNo;

	public CheckingAccount(String accountNo, String ownerName, String cardNo) {
		super(accountNo, ownerName);
		this.cardNo = cardNo;
	}
	public CheckingAccount(String accountNo, String ownerName, long balance, String cardNo) {
		super(accountNo, ownerName, balance);
		this.cardNo = cardNo;
	}
	public void pay(String cardNo, int amount) { // string�� ==�� �ϸ� �ȵ�, equals ����ؾ� ��
		if(this.cardNo.equals(cardNo)) { // �ùٸ� ī�� ��ȣ �Է�
			if(getBalance() >= amount) { // �ߺ� if�� > �ܾ��� ���Ƽ� ������ ��������
				//balance = balance - amount;
				setBalance(getBalance() - amount); // �ܾ� amount��ŭ ����
				System.out.printf("%s��, %d�� �����Ͽ� ����(%s)�� �ܾ� %d��\n",getOwnerName(), amount, getAccountNo(), getBalance());
			}else { // �ܾ� �������� ���� �Ұ�
				System.out.printf("%s�� ����(%s)�� �ܾ��� �����Ͽ� ���� �Ұ��մϴ�. �ܾ�: %d��\n", getOwnerName(), getAccountNo(), getBalance());
			}
		}else { // Ʋ�� ī�� ��ȣ �Է�
			System.out.println("��ȿ�� ī�� ��ȣ�� �ƴմϴ�.");
		}
	}//if��
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
}
