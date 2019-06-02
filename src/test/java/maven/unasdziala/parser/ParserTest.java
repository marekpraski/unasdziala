package maven.unasdziala.parser;

import maven.unasdziala.model.Company;
import org.junit.jupiter.api.Test;
//import org.junit.Test;

import java.io.File;
import java.util.List;

public class ParserTest {

    @Test
    public void listFiles() {
        Parser parser = new Parser("2012/01/Kowalski_Jan.xls");
        parser.runParser();
        Company comp = parser.getCompany();
        System.out.println("hello");
//        List<File> fileList=parser.getExcelFiles();
//        for(File file : fileList) {
//            System.out.println(file.getName());
//        }
    }

    @Test
    public void testLister() {
        FileLister lister = new FileLister("C:\\Users\\student14\\IdeaProjects\\unasdziala\\");
        List<String> resList = lister.getResultList();

        for (String file : resList) {
            System.out.println(file);
        }
    }

    @Test
    public void testParser() {
        Parser parser = new Parser("C:\\Users\\student14\\IdeaProjects\\unasdziala\\");
        parser.runParser();
        Company com = parser.getCompany();
        System.out.println("hello");

    }
}