package print;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;


public class Raport2print {
	//Delimiter used in CSV file
    private static final String NEW_LINE_SEPARATOR = "\n";

    //CSV file header
    private static final Object [] FILE_HEADER = {"Project","Hours"};

    public static void writeCsvFile(String fileName) {
    	 FileWriter fileWriter = null;

         CSVPrinter csvFilePrinter = null;

         CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);

         try {


             fileWriter = new FileWriter(fileName);

             //initialize CSVPrinter object
             csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);

             //Create CSV file header
             csvFilePrinter.printRecord(FILE_HEADER);

             //Write a new student object list to the CSV file
             for (Student student : students) {
                 List studentDataRecord = new ArrayList();
                 studentDataRecord.add(String.valueOf(student.getId()));
                 studentDataRecord.add(student.getFirstName());
                 studentDataRecord.add(student.getLastName());
                 studentDataRecord.add(student.getGender());
                 studentDataRecord.add(String.valueOf(student.getAge()));
                 csvFilePrinter.printRecord(studentDataRecord);
             }

             System.out.println("CSV file was created successfully !!!");

         } catch (Exception e) {
             System.out.println("Error in CsvFileWriter !!!");
             e.printStackTrace();
         } finally {
             try {
                 fileWriter.flush();
                 fileWriter.close();
                 csvFilePrinter.close();
             } catch (IOException e) {
                 System.out.println("Error while flushing/closing fileWriter/csvPrinter !!!");
                 e.printStackTrace();
             }
         }
     }
 }
}}
