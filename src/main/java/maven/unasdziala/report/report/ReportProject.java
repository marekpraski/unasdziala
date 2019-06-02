//package maven.unasdziala.report.report;
//
//import java.io.File;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//import maven.unasdziala.model.Company;
//import maven.unasdziala.model.Employee;
//import maven.unasdziala.model.Project;
//import maven.unasdziala.model.Work;
//import maven.unasdziala.report.model.ModelReportEmployee;
//import maven.unasdziala.report.model.ModelReportProject;
//
//public class ReportProject {
//
//	public float sumProjectHours(Employee empl) {
//		float a = 0;
//		for (Work work : empl.getWorksList()) {
//			a += work.getTimeSpent();
//		}
//		return a;
//	}
//	
//	public float sumProjectHours(Project project) {
//		float a = 0;
//		for (Work work : project.getWorksList()) {
//			a += work.getTimeSpent();
//		}
//		return a;
//	}
//
//	public float sumEmployeeProjectHours(Employee empl, Project proj) {
//		float a = 0;
//		for (Work work : empl.getWorksList()) {
//			if (work.getProject().equals(proj)) {
//				a += work.getTimeSpent();
//			}
//		}
//		return a;
//	}
//
//	private Set<Project> listOfProjects;
//
//	public String nameAndSurnameCreator(Employee empl) {
//		String[] nameParticles = empl.getName().split("_");
//		return nameParticles[1] + " " + nameParticles[0];
//	}
//
//	public Set<Project> createEmployeeProjectList(Employee empl) {
//		Set<Project> listOfProjects = new HashSet<>();
//		for (Work work : empl.getWorksList()) {
//			listOfProjects.add(work.getProject());
//		}
//		return listOfProjects;
//	}
//
//	public Set<Project> createEmployeeProjectList(Employee empl, LocalDate beg, LocalDate end) {
//		Set<Project> listOfProjects = new HashSet<>();
//		for (Work work : empl.getWorksList()) {
//			if (work.getDate().isAfter(beg) && work.getDate().isBefore(end)) {
//				listOfProjects.add(work.getProject());
//			}
//		}
//		return listOfProjects;
//	}
//	private void createProjectEmployeeList(Project project) {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//	private List<String> listOfFilesWithTimeLimit;
//
//	public List<String> createFilesListWithTimeLimit(Employee empl, LocalDate beg, LocalDate end) {
//		listOfFilesWithTimeLimit = new ArrayList<>();
//		for (String str : empl.getFilesList()) {
//			String[] fileNameSplitted = str.split(File.separator);
//			LocalDate dateOfFile = LocalDate.of(Integer.parseInt(fileNameSplitted[fileNameSplitted.length - 3]),
//					Integer.parseInt(fileNameSplitted[fileNameSplitted.length - 2]), 15);
//			if (dateOfFile.isAfter(beg) && dateOfFile.isBefore(end)) {
//				listOfFilesWithTimeLimit.add(str);
//			}
//		}
//		return listOfFilesWithTimeLimit;
//	}
//
//	ModelReportProject mrp = new ModelReportProject();
//
//	public void createReportEmployee(Employee empl) {
//
//		mre.appendList("Name and surname: " + this.nameAndSurnameCreator(empl));
//		mre.appendList("Amount of hours worked: " + this.sumProjectHours(empl) + " 100%");
//		mre.appendList("Projects participated: ");
//		this.createEmployeeProjectList(empl);
//		this.listOfProjects = this.createEmployeeProjectList(empl);
//		for (Project proj : listOfProjects) {
//			mre.appendList("Project name: " + proj.getName() + " hours: " + this.sumEmployeeProjectHours(empl, proj)
//					+ " percent of all time spent: "
//					+ 100 * (this.sumEmployeeProjectHours(empl, proj) / this.sumProjectHours(empl)) + "%");
//		}
//		mre.appendList("List of files: ");
//		for (String str : empl.getFilesList()) {
//			mre.appendList(str);
//		}
//
//	}
//
//	public void createReportProject(Project project, int year) {
//		LocalDate beg = LocalDate.of(year, 01, 01);
//		LocalDate end = LocalDate.of(year, 12, 31);
//		mrp.appendList("Name: " + project.getName());
//		mrp.appendList("Amount of hours worked: " + this.sumProjectHours(project) + " 100%");
//		mrp.appendList("Employees participated: ");
//		this.createProjectEmployeeList(project);
//		this.listOfProjects = this.createEmployeeProjectList(empl);
//		for (Project proj : listOfProjects) {
//			mre.appendList("Project name: " + proj.getName() + " hours: " + this.sumEmployeeProjectHours(empl, proj)
//					+ " percent of all time spent: "
//					+ 100 * (this.sumEmployeeProjectHours(empl, proj) / this.sumProjectHours(empl)) + "%");
//		}
//		mre.appendList("List of files: ");
//		for (String str : this.createFilesListWithTimeLimit(empl, beg, end)) {
//			mre.appendList(str);
//		}
//
//	}
//
//	
//	public void createReportEmployee(Employee empl, LocalDate beg, LocalDate end) {
//
//		mre.appendList("Name and surname: " + this.nameAndSurnameCreator(empl));
//		mre.appendList("Amount of hours worked: " + this.sumProjectHours(empl) + " 100%");
//		mre.appendList("Projects participated: ");
//		this.createEmployeeProjectList(empl, beg, end);
//		this.listOfProjects = this.createEmployeeProjectList(empl);
//		for (Project proj : listOfProjects) {
//			mre.appendList("Project name: " + proj.getName() + " hours: " + this.sumEmployeeProjectHours(empl, proj)
//					+ " percent of all time spent: "
//					+ 100 * (this.sumEmployeeProjectHours(empl, proj) / this.sumProjectHours(empl)) + "%");
//		}
//		mre.appendList("List of files: ");
//		for (String str : this.createFilesListWithTimeLimit(empl, beg, end)) {
//			mre.appendList(str);
//		}
//
//	}
//
////	private int tempDate = 2012;
////
//////	private Set<Project> projectSet = new HashSet<>();
////
////	private Map<Project, Float> projectMap = new HashMap<>();
////	private Map<Employee, Float> employeeMap = new HashMap<>();
////
////	public float getProjectTimeSpent(Project project) {
////		return 0;
////	}
////
////	public float getProjectEmployeeTimeSpent(Project project, Employee employee) {
////		return 0;
////	}
////
////	public void reportNewProject(Project project) {
////		if (!projectMap.containsKey(project)) {
////			projectMap.put(project, getProjectTimeSpent(project));
////		}
////	}
////
////	public void reportNewProjectEmployee(Employee employee, Project project) {
////		if (!employeeMap.containsKey(employee)) {
////			employeeMap.put(employee, getProjectEmployeeTimeSpent(project, employee));
////		}
////	}
////
////	public ModelReportProject generateModel(Company company, LocalDate begining, LocalDate ending) {
////		begining = LocalDate.of(tempDate, 1, 1);
////		ending = LocalDate.of(tempDate, 12, 31);
////
////		for (Project project : company.getProjectsList()) {
////			for (Work work : project.getWorksList()) {
////				if (work.getDate().isAfter(begining) && (work.getDate().isBefore(ending))) {
////					reportNewProject(project);
////					reportNewProjectEmployee(work.getEmployee(), project);
////				}
////			}
////
////		}
////		return null;
////	}
//
//}
