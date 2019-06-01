package maven.unasdziala.parser;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExcelReader {
    private Workbook wb;

    public ExcelReader() {

    }

    public List<String[]> getAllProjectNames(String filename) {
        Workbook wb = null;
        try {
            wb = WorkbookFactory.create(new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String[]> sheetNames = new ArrayList();
        int n = wb.getNumberOfSheets();
        String[] name = new String[n];
        for (int i = 0; i < n; i++) {
            name[i] = wb.getSheetName(i);
        }
        sheetNames.add(name);
        return sheetNames;
    }

    public String getEmployeeName(String filename) {

        int slashPosition = filename.lastIndexOf('/');
        int dotPosition = filename.lastIndexOf('.');
        String name = filename.substring(slashPosition + 1, dotPosition - 1);
        return name;
    }

    public int getYear(String filename) {
        int slashPosition = filename.indexOf('/');
        int year = Integer.parseInt(filename.substring(0, slashPosition - 1));
        return year;
    }

    private Set<String> getDates(String option) {
        Set<String> dates = new HashSet();
        Integer column = ColumnHeaders.DATA.getColumnIndex();
        for (Sheet sheet : wb) {

            for (Row row : sheet) {
                if (row != null) {
                    Cell cell = row.getCell(column);
                    if (cell != null) {
                        String date = cell.getStringCellValue();
                        if (date != "")
                            dates.add(date);
                    }
                }
            }

        }
        return dates;
    }

    private Set<String> getWork(String option) {
        Set<String> works = new HashSet();
        Integer column = ColumnHeaders.DATA.getColumnIndex();
        for (Sheet sheet : wb) {

            for (Row row : sheet) {
                if (row != null) {
                    Cell cell = row.getCell(column);
                    if (cell != null) {
                        String work = cell.getStringCellValue();
                        if (work != "")
                            works.add(work);
                    }
                }
            }

        }
        return works;
    }

    private Set<String> getTime(String option) {
        Set<String> works = new HashSet();
        Integer column = ColumnHeaders.DATA.getColumnIndex();
        for (Sheet sheet : wb) {

            for (Row row : sheet) {
                if (row != null) {
                    Cell cell = row.getCell(column);
                    if (cell != null) {
                        String work = cell.getStringCellValue();
                        if (work != "")
                            works.add(work);
                    }
                }
            }

        }
        return works;
    }
}
