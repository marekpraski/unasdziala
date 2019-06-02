package maven.unasdziala;
import java.util.Scanner;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import maven.unasdziala.model.Company;
import maven.unasdziala.model.Employee;
import maven.unasdziala.parser.Parser;
import maven.unasdziala.print.Raport1print;
import maven.unasdziala.report.report.ReportEmployee;

public class Console {
	public static void main(String[] args)throws ParseException {
		Options options = new Options();
		CommandLineParser parser = new DefaultParser();
	     CommandLine cmd = parser.parse( options, args);
	     System.out.println("Give me a year");
			Scanner y = new Scanner(System.in);
			int year=y.nextInt();

		boolean end = false;
		
		Parser excelParser = new Parser("Kowalski_Jan.xls");
		excelParser.runParser();
		
		Company comp = excelParser.getCompany();
		ReportEmployee reportEmployee = new ReportEmployee();
		Raport1print r1p = new Raport1print(reportEmployee);

		do {
			Scanner scan = new Scanner(System.in);
			System.out.println("Please choice your reports");
			System.out.println("1.Hoursbyperson");
			System.out.println("2.Hoursbyproject");
			System.out.println("3.exit");
			
			int choice = scan.nextInt();
			switch (choice) {
			case 1:{
				System.out.println("This is raport number 1");
//				for(Employee emp: comp.getEmployeesList()) {
//					System.out.println(emp.toString());
//				}
				r1p.printReport1(comp.getEmployeesList());
				break;}
			case 2:{
				System.out.println("This is raport number 2");
				break;}
			case 3:{
				end=true;
				break;}
			 default: {
			        System.out.println("This is a bad choice");
			    }
			}
			
			
		} while (!end);

	}
}
