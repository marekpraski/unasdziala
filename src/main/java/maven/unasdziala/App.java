package maven.unasdziala;

import maven.unasdziala.parser.ExcelReader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        ExcelReader reader = new ExcelReader();
reader.getYear("2012/01/Kowalski_Jan.xls");
        System.out.println( "Hello World!" );
    }
}
