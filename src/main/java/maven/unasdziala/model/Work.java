package maven.unasdziala.model;

import java.time.LocalDate;

public class Work {

	private LocalDate date;
	private String name;
	private float timeSpent;
	private Employee employee;
	private Project project;

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getTimeSpent() {
		return timeSpent;
	}

	public void setTimeSpent(float timeSpent) {
		this.timeSpent = timeSpent;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Work(LocalDate date, String name, float timeSpent, Employee employee, Project project) {
		this.date = date;
		this.name = name;
		this.timeSpent = timeSpent;
		this.employee = employee;
		this.project = project;
	}

}
