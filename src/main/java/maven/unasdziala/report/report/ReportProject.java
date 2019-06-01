package maven.unasdziala.report.report;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import maven.unasdziala.model.Company;
import maven.unasdziala.model.Project;
import maven.unasdziala.model.Work;
import maven.unasdziala.report.model.ModelReportProject;

public class ReportProject {

	private int tempDate = 2012;
	
	private Map<Project,Float> projectMap = new HashMap<>();

	public float getProjectTimeSpent(Project project) {
		return 0;
	}
	
	public void reportNewProject(Project project) {
		if (!projectMap.containsKey(project)) {
			projectMap.put(project, getProjectTimeSpent(project));
		}
	}
	

	public ModelReportProject generateModel(Company company, LocalDate begining, LocalDate ending) {
		begining = LocalDate.of(tempDate, 1, 1);
		ending = LocalDate.of(tempDate, 12, 31);
		
		for (Project project : company.getProjectsList()) {
			for (Work work : project.getWorksList()) {
				if (work.getDate().isAfter(begining) && (work.getDate().isBefore(ending))) {
					reportNewProject(project);
				}
			}
			
			
		}
		return null;
	}

}
