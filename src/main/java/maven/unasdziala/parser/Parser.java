package maven.unasdziala.parser;

import maven.unasdziala.model.Company;
import maven.unasdziala.model.Employee;
import maven.unasdziala.model.Project;
import maven.unasdziala.model.Work;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Parser {
    private String path;
    private List<File> excelFiles;
    private Map<String,Employee> employeeMap;
    private Map<String, Project> projectMap;
    private ExcelReader reader;
    private List<Work> workList;
    private Company company;

    public List<Work> getWorkList() {
        return workList;
    }

    public Parser(String path) {
        this.path = path;
        excelFiles=new ArrayList<>();
        reader = new ExcelReader();
        reader.setPath(path);
        reader.createWorkBook();
        employeeMap = new HashMap<>();
        projectMap = new HashMap();
        workList = new ArrayList<>();
        company = new Company();

    }

    public Company getCompany() {
        return company;
    }

    public List<File> getExcelFiles() {
        return excelFiles;
    }

    private void createEmployeeMap() {
        List<SingleRowData> rowData = reader.getRowDataList();
        for(SingleRowData item : rowData) {
            String name = item.getEmployeeName();
            if (!employeeMap.containsKey(name)) {
                Employee employee = new Employee(name);
                employeeMap.put(name,employee);
            }

        }
}

    private void createProjectMap() {
        List<SingleRowData> rowData = reader.getRowDataList();
        for(SingleRowData item : rowData) {
            String name = item.getProjectName();
            if (!projectMap.containsKey(name)) {
                Project project = new Project(name);
                projectMap.put(name,project);
            }

        }
    }
    /**
     * parse a complete list of Works from SingleRowData objects from ExcelReader
     * by running ExcelReader through all Excel files
     */
    private void parseWorks() {
        Work work=null;
        List<SingleRowData> rowData = reader.getRowDataList();
        for(SingleRowData item : rowData) {
            work = new Work();
            work.setDate(item.getDate());
            work.setName(item.getWorkName());
            work.setTimeSpent(item.getTimeSpent());
            Employee employee = employeeMap.get(item.getEmployeeName());
            work.setEmployee(employee);
            employee.addWork(work);
            Project project = projectMap.get(item.getProjectName());
            work.setProject(project);
            project.addWork(work);
            workList.add(work);
        }
        List<Employee> employeeList = new ArrayList<Employee>(employeeMap.values());
        List<Project> projectList = new ArrayList<Project>(projectMap.values());
        company.setEmployeesList(employeeList);
        company.setProjectsList(projectList);
           }

        public void runParser(){
        createEmployeeMap();
        createProjectMap();
        parseWorks();
        }
}
