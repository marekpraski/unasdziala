package maven.unasdziala.model;

import java.util.ArrayList;
import java.util.List;

public class Employee {

	private String name;
	private List<Work> worksList;
	private List<String> filesList;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Work> getWorksList() {
		return worksList;
	}

	public void setWorksList(List<Work> worksList) {
		this.worksList = worksList;
	}

	public List<String> getFilesList() {
		return filesList;
	}

	public void setFilesList(List<String> filesList) {
		this.filesList = filesList;
	}

	public Employee(String name) {
		this.name = name;
		worksList = new ArrayList();
		filesList = new ArrayList();
	}

}
