package maven.unasdziala.model;

import java.util.ArrayList;
import java.util.List;

public class Project {

	private String name;
	private List<Work> worksList;

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

	public Project(String name) {
		this.name = name;
		worksList = new ArrayList();
	}

}
