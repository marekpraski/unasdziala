package maven.unasdziala.parser;

import maven.unasdziala.model.Work;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ExcelReader {
    private Workbook wb;
    private String path;
    private List<File> excelFiles;

    public ExcelReader() {

    }

    /**
     * path to the Excel file to be read
     *
     * @param path
     */
    public void setPath(String path) {
        this.path = path;

    }

    public void createWorkBook() {
        try {
            wb = WorkbookFactory.create(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getAllProjectNames() {
        List<String> sheetNames = new ArrayList();
        int n = wb.getNumberOfSheets();
        String name;
        for (int i = 0; i < n; i++) {
            name = wb.getSheetName(i);
            sheetNames.add(name);
        }
        return sheetNames;
    }

    public String getEmployeeName() {
        int slashPosition = path.lastIndexOf('/');
        int dotPosition = path.lastIndexOf('.');
        String name = path.substring(slashPosition + 1, dotPosition);
        return name;
    }

    public int getYear() {
        int slashPosition = path.indexOf('/');
        int year = Integer.parseInt(path.substring(0, slashPosition));
        return year;
    }

    public List<Date> getAllDates() {
        List<Date> dates = new ArrayList<>();
        Integer column = ColumnHeaders.DATA.getColumnIndex();
        for (Sheet sheet : wb) {
            for (Row row : sheet) {
                if (row != null && row.getRowNum() > 0) { //do not read the header row
                    Cell cell = row.getCell(column);
                    if (cell != null) {
                        cell.setCellType(CellType.NUMERIC);
                        Date date = cell.getDateCellValue();
                        dates.add(date);
                    } else {
                        //handle error, to be implemented
                    }
                }
            }
        }
        return dates;
    }

    public List<String> getAllWorks() {
        List<String> works = new ArrayList();
        Integer column = ColumnHeaders.ZADANIE.getColumnIndex();
        for (Sheet sheet : wb) {
            for (Row row : sheet) {
                if (row != null && row.getRowNum() > 0) {
                    Cell cell = row.getCell(column);

                    if (cell != null) {
                        cell.setCellType(CellType.STRING);
                        String work = cell.getStringCellValue();
                        works.add(work);
                    } else {
                        //handle error, to be implemented
                    }
                }
            }
        }
        return works;
    }

    public List<Double> getAllWorkTime() {
        List<Double> workTimes = new ArrayList();
        Integer column = ColumnHeaders.CZAS.getColumnIndex();
        for (Sheet sheet : wb) {
            for (Row row : sheet) {
                if (row != null && row.getRowNum() > 0) {
                    Cell cell = row.getCell(column);
                    if (cell != null) {
                        cell.setCellType(CellType.NUMERIC);
                        Double workTime = cell.getNumericCellValue();
                        workTimes.add(workTime);
                    } else {
                        //handle error, to be implemented
                    }
                }
            }
        }
        return workTimes;
    }

    public float getWorkTime(Row row) {
        Double workTime=0.0;
        Integer column = ColumnHeaders.CZAS.getColumnIndex();
        Cell cell = row.getCell(column);
        if (cell != null) {
            cell.setCellType(CellType.NUMERIC);
            workTime = cell.getNumericCellValue();
        } else {
            //handle error, to be implemented
        }
        return workTime.floatValue();
    }

    public List<Work> getWorkList() {
        List<Work> worksInFile = new ArrayList();
        for (Sheet sheet : wb) {
            for (Row row : sheet) {
                if (row != null && row.getRowNum() > 0) {
                    Work work= new Work();
                    work.setTimeSpent(getWorkTime(row));
                    //to be completed
                    worksInFile.add(work);
                    } else {
                        //handle error, to be implemented
                    }
                }
            }
        return worksInFile;
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

}
