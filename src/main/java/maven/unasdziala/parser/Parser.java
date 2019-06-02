package maven.unasdziala.parser;

import maven.unasdziala.model.Employee;
import maven.unasdziala.model.Project;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Parser {
    private String path;
    private List<File> excelFiles;
    private Map<String,Employee> employeeMap;
    private Map<String, Project> projectMap;
    private ExcelReader reader;

    public Parser(String path) {
        this.path = path;
        excelFiles=new ArrayList<>();
        reader = new ExcelReader();
        reader.setPath(path);
        reader.createWorkBook();
    }

    public List<File> getExcelFiles() {
        return excelFiles;
    }

    public void listFiles() {
        try {
            List<File> allFiles = Files.walk(Paths.get(path))
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .collect(Collectors.toList());
            for (File file : allFiles) {
                String fileName = file.getName();
                if (fileName.substring(fileName.lastIndexOf('.') + 1).equals("xls")) {
                    excelFiles.add(file);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void createEmployeeMap() {
        List<SingleRowData> rowData = reader.getRowDataList();
        for(SingleRowData item : rowData) {
            String name = item.getEmployeeName();
        }
        reader.getEmployeeName();
}
    /**
     * parse a complete list of Works from SingleRowData objects from ExcelReader
     * by running ExcelReader through all Excel files
     */
    public void paseWorks() {

    }

    /**
     * parse a list of Project objects from Works
     */
    public void parseProjects() {

    }

    /**
     * parse a list of Employee objects from Works
     */
    public void parseEmployees() {

    }
}
