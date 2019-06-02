package maven.unasdziala;

import java.time.LocalDate;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import maven.unasdziala.model.Company;
import maven.unasdziala.parser.Parser;
import maven.unasdziala.print.Raport1print;
import maven.unasdziala.report.report.ReportEmployee;



public class Reader {
	public static void main(String[] args) throws ParseException {
		
		Options options = new Options();

		options.addOption("r1", false, "View raport number 1")
				.addOption("r2", false, "View raport number 2")
				.addOption("r11", true, "View raport number 1/Year")
				.addOption("r22", true, "View raport number 2/Year")
				.addOption("r111", true, "View raport number 1/Z")
				.addOption("r222", true, "View raport number 2/Z")
				.addOption("r", true, "Year")
				.addOption("a", true, "First date")
		        .addOption("b", true, "End date");

		CommandLineParser parser = new DefaultParser();

		CommandLine cmd = parser.parse(options, args);

		if (cmd.hasOption("r1")) {
			System.out.println("Raport number 1");

			Parser excelParser = new Parser("Kowalski_Jan.xls");
			excelParser.runParser();
			
			Company comp = excelParser.getCompany();
			ReportEmployee reportEmployee = new ReportEmployee();
			Raport1print r1p = new Raport1print(reportEmployee);
			r1p.printReport1(comp.getEmployeesList());
	
			
		}
		if (cmd.hasOption("r2")) {
			System.out.println("raport number 2");
		}
	
		if(cmd.hasOption("r11")&cmd.hasOption("r")){
			Integer year = Integer.parseInt(cmd.getOptionValue("r"));
			System.out.println("Report 1 by Date" + cmd.getOptionValue("r"));
			
		}	if(cmd.hasOption("r22")&cmd.hasOption("r")){
			Integer year = Integer.parseInt(cmd.getOptionValue("r"));
			System.out.println("Report 2 and Date" + cmd.getOptionValue("r"));
			
		}
			
		if (cmd.hasOption("r111")&cmd.hasOption("a")&cmd.hasOption("b")) {

			System.out.println("First Date1" + cmd.getOptionValue("a"));
			System.out.println("End Date1" + cmd.getOptionValue("b"));
			LocalDate begindate = LocalDate.parse(cmd.getOptionValue("a"));
			LocalDate enddate = LocalDate.parse(cmd.getOptionValue("b"));
		}
		if (cmd.hasOption("a")&cmd.hasOption("b")&cmd.hasOption("r222")) {

			System.out.println("First Date2" + cmd.getOptionValue("a"));
			System.out.println("End Date2" + cmd.getOptionValue("b"));
			LocalDate begindate = LocalDate.parse(cmd.getOptionValue("a"));
			LocalDate enddate = LocalDate.parse(cmd.getOptionValue("b"));
		}
		
		
		}
	
	}

