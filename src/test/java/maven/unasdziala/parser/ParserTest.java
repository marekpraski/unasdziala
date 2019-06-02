package maven.unasdziala.parser;

import org.junit.jupiter.api.Test;
//import org.junit.Test;

import java.io.File;
import java.util.List;

public class ParserTest {

    @Test
    public void listFiles() {
        Parser parser = new Parser("2012/");
        parser.listFiles();
        List<File> fileList=parser.getExcelFiles();
        for(File file : fileList) {
            System.out.println(file.getName());
        }
    }
}
