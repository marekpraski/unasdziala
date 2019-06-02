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

		options.addOption("r1", false, "View raport number 1").addOption("r2", false, "View raport number 2")
				.addOption("r11", false, "View raport number 1/Year")
				.addOption("r22", false, "View raport number 2/Year")
				.addOption("r111", false, "View raport number 1/From Date to Date")
				.addOption("r222", false, "View raport number 2/From Date to Date").addOption("y", true, "Year")
				.addOption("from", true, "First date")
				.addOption("to", true, "End date");

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
		else if (cmd.hasOption("r2")) {
			System.out.println("raport number 2");
		}

		else if (cmd.hasOption("r11") & cmd.hasOption("y")) {
			Integer year = Integer.parseInt(cmd.getOptionValue("y"));
			System.out.println("Report 1 by Date" + cmd.getOptionValue("y"));
			
		}
		
		else if (cmd.hasOption("r22") & cmd.hasOption("y")) {
			Integer year = Integer.parseInt(cmd.getOptionValue("y"));
			System.out.println("Report 2 and Date" + cmd.getOptionValue("y"));

		}

		else if (cmd.hasOption("r111") & cmd.hasOption("from") & cmd.hasOption("to")) {
			LocalDate begindate = LocalDate.parse(cmd.getOptionValue("from"));
			LocalDate enddate = LocalDate.parse(cmd.getOptionValue("to"));
			
			Parser excelParser = new Parser("Kowalski_Jan.xls");
			excelParser.runParser();
			
			Company comp = excelParser.getCompany();
			ReportEmployee reportEmployee = new ReportEmployee();
			Raport1print r1p = new Raport1print(reportEmployee);
			r1p.printReport1(comp.getEmployeesList(), begindate, enddate);
		}
		
		
		else if (cmd.hasOption("r222")&cmd.hasOption("a") & cmd.hasOption("b")) {

			System.out.println("First Date2" + cmd.getOptionValue("from"));
			System.out.println("End Date2" + cmd.getOptionValue("to"));
			LocalDate begindate = LocalDate.parse(cmd.getOptionValue("from"));
			LocalDate enddate = LocalDate.parse(cmd.getOptionValue("to"));
		}
		else 
			System.out.println("Welcome Raports");
	}

}
