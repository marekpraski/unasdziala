package maven.unasdziala.parser;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        int year = reader.getYear();
        System.out.println(year);
    }

    @Test
    public void getDatesTest() {
        ExcelReader reader = new ExcelReader();
        reader.setPath("2012/01/Kowalski_Jan.xls");
        List<Date> dates = reader.getAllDates();
        for (Date item : dates) {
            System.out.println(item);
        }
    }

    @Test
    public void getWorksTest() {
        ExcelReader reader = new ExcelReader();
        reader.setPath("2012/01/Kowalski_Jan.xls");
        List<String> works = reader.getAllWorks();
        printStringList(works);
    }

    @Test
    public void getWorkTimessTest() {
        ExcelReader reader = new ExcelReader();
        reader.setPath("2012/01/Kowalski_Jan.xls");
        List<Double> works = reader.getAllWorkTime();
        for (Double item : works) {
            System.out.println(item);
        }
    }

    @Test

    public void listFiles() {
        ExcelReader reader = new ExcelReader();
        reader.setPath("2012/");
        reader.listFiles();



    }
}
