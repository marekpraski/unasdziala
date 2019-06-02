package maven.unasdziala.parser;

import maven.unasdziala.model.Employee;
import maven.unasdziala.model.Project;

import java.time.LocalDate;

public class SingleRowData {
    private LocalDate date;
    private String workName;
    private float timeSpent;
    private String employeeName;
    private String projectName;
    private String fileName;

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public void setTimeSpent(float timeSpent) {
        this.timeSpent = timeSpent;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getWorkName() {
        return workName;
    }

    public float getTimeSpent() {
        return timeSpent;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getFileName() {
        return fileName;
    }
}
