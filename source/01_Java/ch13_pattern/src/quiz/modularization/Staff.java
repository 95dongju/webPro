package quiz.modularization;

import quiz.interfaces.GetSalary;
import quiz.interfaces.JobMng;

public class Staff extends Person {
	private String part;
	

	public Staff(String id, String name, String part) {
		super(id, name);
		this.part = part;
		setJob(new JobMng());
		setGet(new GetSalary());

	}
	
	public void print() {
		super.print();
		System.out.println("\t[�μ�]: "+part);
	}

}
