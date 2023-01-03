package quiz.modularization;

import quiz.interfaces.GetStudentPay;
import quiz.interfaces.JobStudy;

public class Student extends Person {
	private String ban;

	public Student(String id, String name, String ban) {
		super(id, name);
		this.ban = ban;
		setJob(new JobStudy());
		setGet(new GetStudentPay());
	}
	public void print() {
		super.print();
		System.out.println("\t[¹Ý]: "+ban);
	}

}

