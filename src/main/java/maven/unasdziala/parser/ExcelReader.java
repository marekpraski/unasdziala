package maven.unasdziala.parser;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExcelReader {
    private Workbook wb;
    private String path;

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

    private float getWorkTime(Row row) {
        Double workTime = 0.0;
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

    private String getWork(Row row) {
        String work = "";
        Integer column = ColumnHeaders.ZADANIE.getColumnIndex();
        Cell cell = row.getCell(column);
        if (cell != null) {
            cell.setCellType(CellType.STRING);
            work = cell.getStringCellValue();
        } else {
            //handle error, to be implemented
        }
        return work;
    }

    private LocalDate getDate(Row row) {
        Date date = null;
        Integer column = ColumnHeaders.DATA.getColumnIndex();
        Cell cell = row.getCell(column);
        if (cell != null) {
            cell.setCellType(CellType.NUMERIC);
            date = cell.getDateCellValue();
        } else {
            //handle error, to be implemented
        }
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public List<SingleRowData> getRowDataList() {
        List<SingleRowData> worksInFile = new ArrayList();
        for (Sheet sheet : wb) {
            for (Row row : sheet) {
                if (row != null && row.getRowNum() > 0) {
                    SingleRowData rowData = new SingleRowData();
                    rowData.setTimeSpent(getWorkTime(row));
                    rowData.setWorkName(getWork(row));
                    rowData.setDate(getDate(row));
                    rowData.setEmployeeName(getEmployeeName());
                    rowData.setProjectName(sheet.getSheetName());
                    rowData.setFileName(path);
                    //to be completed
                    worksInFile.add(rowData);
                }
            }
        }
        return worksInFile;
    }

}
