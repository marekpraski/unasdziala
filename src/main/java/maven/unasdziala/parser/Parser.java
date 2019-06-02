package maven.unasdziala.parser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    String path;
    List<File> excelFiles;

    public Parser(String path) {
        this.path = path;
        excelFiles=new ArrayList<>();
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
