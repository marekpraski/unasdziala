package maven.unasdziala.model;

import java.util.ArrayList;
import java.util.List;

public class Company {

	private List<Employee> employeesList = new ArrayList<Employee>();
	private List<Project> projectsList = new ArrayList<Project>();

	public List<Employee> getEmployeesList() {
		return employeesList;
	}

	public void setEmployeesList(List<Employee> employeesList) {
		this.employeesList = employeesList;
	}

	public List<Project> getProjectsList() {
		return projectsList;
	}

	public void setProjectsList(List<Project> projectsList) {
		this.projectsList = projectsList;
	}


}
