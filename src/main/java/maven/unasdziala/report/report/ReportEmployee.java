package maven.unasdziala.report.report;

import maven.unasdziala.model.Employee;
import maven.unasdziala.model.Project;
import maven.unasdziala.model.Work;

public class ReportEmployee {

	public float sumEmployeeHours(Employee empl) {
		float a = 0;
		for (Work work : empl.getWorksList()) {
			a += work.getTimeSpent();
		}
		return a;
	}

	public float sumEmployeeProjectHours(Employee empl, Project proj) {
		float a = 0;
		for (Work work : empl.getWorksList()) {
			if (work.getProject().equals(proj)) {
				a += work.getTimeSpent();
			}
		}
		return a;
	}

	public void createMode() {

	}
}
