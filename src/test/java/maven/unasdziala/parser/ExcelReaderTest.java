package maven.unasdziala.parser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ExcelReaderTest {


    public void printStringList(List<String> list) {
        for (String item : list) {
            System.out.println(item);
        }
    }

    @Test
    public void readProjectsTest() {
        List<String> names = new ArrayList<>();
        ExcelReader reader = new ExcelReader();
        reader.setPath("2012/01/Kowalski_Jan.xls");
        names = reader.getAllProjectNames();
        printStringList(names);
    }

    @Test
    public void getEmployeeNameTest() {
        ExcelReader reader = new ExcelReader();
        reader.setPath("2012/01/Kowalski_Jan.xls");
        String name = reader.getEmployeeName();
        System.out.println(name);
    }

    @Test
    public void getYearTest() {
        ExcelReader reader = new ExcelReader();
        reader.setPath("2012/01/Kowalski_Jan.xls");
        reader.createWorkBook();
        int year = reader.getYear();
        System.out.println(year);
    }

    @Test
    public void getDatesTest() {
        ExcelReader reader = new ExcelReader();
        reader.setPath("2012/01/Kowalski_Jan.xls");
        reader.createWorkBook();
        List<Date> dates = reader.getAllDates();
        for (Date item : dates) {
            System.out.println(item);
        }
    }

    @Test
    public void getWorksTest() {
        ExcelReader reader = new ExcelReader();
        reader.setPath("2012/01/Kowalski_Jan.xls");
        reader.createWorkBook();
        List<String> works = reader.getAllWorks();
        printStringList(works);
    }

    @Test
    public void getWorkTimessTest() {
        ExcelReader reader = new ExcelReader();
        reader.setPath("2012/01/Kowalski_Jan.xls");
        reader.createWorkBook();
        List<Double> works = reader.getAllWorkTime();
        for (Double item : works) {
            System.out.println(item);
        }
    }
    @Test
    public void getsingleRowDataTest() {
        ExcelReader reader = new ExcelReader();
        reader.setPath("2012/01/Kowalski_Jan.xls");
        reader.createWorkBook();
        List<SingleRowData> works = reader.getRowDataList();
        System.out.println("it works!");
    }
}
