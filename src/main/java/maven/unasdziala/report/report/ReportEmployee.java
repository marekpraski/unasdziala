package maven.unasdziala.report.report;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import maven.unasdziala.model.Employee;
import maven.unasdziala.model.Project;
import maven.unasdziala.model.Work;
import maven.unasdziala.report.model.ModelReportEmployee;

public class ReportEmployee {

	public float sumEmployeeHours(Employee empl, LocalDate beg, LocalDate end) {
		float a = 0;
			for (Work work : empl.getWorksList()) {
			if (work.getDate().isAfter(beg) && work.getDate().isBefore(end)) {
				a += work.getTimeSpent();
			}
		}
		return a;
	}

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

	public float sumEmployeeProjectHours(Employee empl, Project proj, LocalDate beg, LocalDate end) {
		float a = 0;
		for (Work work : empl.getWorksList()) {
			if (work.getDate().isAfter(beg) && work.getDate().isBefore(end)) {
				if (work.getProject().equals(proj)) {
					a += work.getTimeSpent();
				}
			}
		}
		return a;
	}

	private Set<Project> listOfProjects;

	public String nameAndSurnameCreator(Employee empl) {
		String[] nameParticles = empl.getName().split("_");
		return nameParticles[1] + " " + nameParticles[0];
	}

	public Set<Project> createEmployeeProjectList(Employee empl) {
		Set<Project> listOfProjects = new HashSet<>();
		for (Work work : empl.getWorksList()) {
			if (work.getProject() != null)
				listOfProjects.add(work.getProject());
		}
		return listOfProjects;
	}

	public Set<Project> createEmployeeProjectList(Employee empl, LocalDate beg, LocalDate end) {
		Set<Project> listOfProjects = new HashSet<>();
		for (Work work : empl.getWorksList()) {
			if (work.getDate().isAfter(beg) && work.getDate().isBefore(end)) {
				listOfProjects.add(work.getProject());
			}
		}
		return listOfProjects;
	}

	private List<String> listOfFilesWithTimeLimit;

	public List<String> createFilesListWithTimeLimit(Employee empl, LocalDate beg, LocalDate end) {
		listOfFilesWithTimeLimit = new ArrayList<>();
		for (String str : empl.getFilesList()) {
			String[] fileNameSplitted = str.split(File.separator);
			LocalDate dateOfFile = LocalDate.of(Integer.parseInt(fileNameSplitted[fileNameSplitted.length - 3]),
					Integer.parseInt(fileNameSplitted[fileNameSplitted.length - 2]), 15);
			if (dateOfFile.isAfter(beg) && dateOfFile.isBefore(end)) {
				listOfFilesWithTimeLimit.add(str);
			}
		}
		return listOfFilesWithTimeLimit;
	}

	ModelReportEmployee mre;

	public List<String> createReportEmployee(Employee empl) {
		// mre = new ModelReportEmployee();
		List<String> mre = new ArrayList<>();
		mre.add("Name and surname: " + this.nameAndSurnameCreator(empl));
		mre.add("Amount of hours worked: " + this.sumEmployeeHours(empl));
		mre.add("Projects participated: ");
		this.createEmployeeProjectList(empl);
		this.listOfProjects = this.createEmployeeProjectList(empl);
		for (Project proj : listOfProjects) {
			mre.add("Project name: " + proj.getName() + " hours: " + this.sumEmployeeProjectHours(empl, proj)
					+ " percent of all time spent: "
					+ 100 * (this.sumEmployeeProjectHours(empl, proj) / this.sumEmployeeHours(empl)) + "%");
		}
		mre.add("List of files: ");
		for (String str : empl.getFilesList()) {
			mre.add(str);
		}
		return mre;

	}

	public List<String> createReportEmployee(Employee empl, int year) {
		LocalDate beg = LocalDate.of(year, 01, 01);
		LocalDate end = LocalDate.of(year, 12, 31);
		List<String> mre = new ArrayList<>();
		mre.add("Name and surname: " + this.nameAndSurnameCreator(empl));
		mre.add("Amount of hours worked: " + this.sumEmployeeHours(empl));
		mre.add("Projects participated: ");
		this.createEmployeeProjectList(empl, beg, end);
		this.listOfProjects = this.createEmployeeProjectList(empl);
		for (Project proj : listOfProjects) {
			mre.add("Project name: " + proj.getName() + " hours: " + this.sumEmployeeProjectHours(empl, proj)
					+ " percent of all time spent: "
					+ 100 * (this.sumEmployeeProjectHours(empl, proj) / this.sumEmployeeHours(empl)) + "%");
		}
		mre.add("List of files: ");
		for (String str : this.createFilesListWithTimeLimit(empl, beg, end)) {
			mre.add(str);
		}
		mre.add("Period: " + beg + " - " + end);
		return mre;
	}

	public List<String> createReportEmployee(Employee empl, LocalDate beg, LocalDate end) {
		List<String> mre = new ArrayList<>();
		mre.add("Name and surname: " + this.nameAndSurnameCreator(empl));
		mre.add("Amount of hours worked: " + this.sumEmployeeHours(empl, beg, end));
		mre.add("Projects participated: ");
		this.createEmployeeProjectList(empl, beg, end);
		this.listOfProjects = this.createEmployeeProjectList(empl, beg, end);
		for (Project proj : listOfProjects) {
			mre.add("Project name: " + proj.getName() + " hours: " + this.sumEmployeeProjectHours(empl, proj, beg, end)
					+ " percent of all time spent: "
					+ 100 * (this.sumEmployeeProjectHours(empl, proj) / this.sumEmployeeHours(empl, beg, end)) + "%");
		}
		mre.add("List of files: ");
		for (String str : this.createFilesListWithTimeLimit(empl, beg, end)) {
			mre.add(str);
		}
		mre.add("Period: " + beg + " - " + end);

		return mre;
	}

}
