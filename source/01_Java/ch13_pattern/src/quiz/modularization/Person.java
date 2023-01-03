package quiz.modularization;

import quiz.interfaces.GetImpl;
import quiz.interfaces.JobImpl;

public class Person {
	private JobImpl job;
	private GetImpl get;
	private String id;
	private String name;
	
	
	public Person(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public void job() {
		job.job();
	}
	
	public void get() {
		get.get();
	}

	public void setJob(JobImpl job) {
		this.job = job;
	}

	public void setGet(GetImpl get) {
		this.get = get;
	}
	
	public void print() {
		System.out.print("[ID]: "+id+"\t[¿Ã∏ß]: "+name);
	}
}
