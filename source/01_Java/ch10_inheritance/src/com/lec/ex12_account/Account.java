package com.lec.ex12_account;
/* ������(�Ӽ�): accountNo(String), ownerName(String), balance(long) ���¹�ȣ�� �ٲٸ� �ȵǱ� ������ setter �� ����
 * ��� (�޼ҵ�): deposit(����), withdraw(����), infoPrint(�������) */ 
public class Account {
	// ������ �����ϸ� �����̺�
	private String accountNo;
	private String ownerName;
	private long balance;
	// ������
	public Account() {	
	}
	public Account(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		// balance �˾Ƽ� 0���� �ʱ�ȭ�ؼ� ��  balance = 0; �� �ĵ� ��
		System.out.println(ownerName+"�� ���� ���� �����մϴ�. �ܾ� : "+balance+" ��");
	}
	public Account(String accountNo, String ownerName, long balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
		System.out.println(ownerName+"�� ���� ���� �����մϴ�. �ܾ� : "+balance+" ��");
	}
	//�޼ҵ� ������ �ۺ�, ���� Ÿ�� ������ void
	public void deposit(long money) {//���� (������ ����)
		balance += money; 
		//balance = balance + money;
		System.out.println(money+" �� �����Ͽ� �ܾ� :"+balance+" ��");
	}
	//����� ���� ���� �Ǵ��� Ȯ�� �ʿ��� (2�����ε� 3���� ���� �Ұ���)
	public void withdraw(long money) {//�ܾ��� ���� ��츸, �ܾ� ������ �����ϴٰ� ���
		if(balance>=money) {
			balance -= money;
			System.out.println(money+" �� �����Ͽ� �ܾ� :"+balance+" ��");
		}else {
			//���� ���� �߻� ���Ѿ� �� (ch15����) - ��ũ�� ������ ���
			System.out.println("�ܾ��� �����Ͽ� ���� �Ұ��մϴ�.");
		}
	}
	public void infoPrint() {
		// "110-302-4928" ȫ�浿�� �ܾ� : 10�� ���
		System.out.println("\""+accountNo+"\" "+ownerName+"�� �ܾ� : "+balance+"��");
		System.out.printf("\"%s\" %s �� �ܾ�: %d��\n", accountNo, ownerName, balance);
	}
	public String infoString() {
		//	return "\""+accountNo+"\" "+ownerName+"�� �ܾ� : "+balance+"��";
	return String.format("\"%s\" %s �� �ܾ�: %d��\n", accountNo, ownerName, balance);
		}
		
	// setter : ���� name���� ���� (���¹�ȣ �ٲ� �� ����. �ܾ׵� �ܺο��� �ٲٸ� �ȵǱ� ����)
	// getter : accountNo, ownerName, balance
	public String getAccountNo() {
		return accountNo;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public long getBalance() {
		return balance;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	
}
