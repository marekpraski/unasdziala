package maven.unasdziala;

import java.time.LocalDate;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Reader {
	public static void main(String[] args) throws ParseException {

		Options options = new Options();

		options.addOption("r1", false, "View raport number 1")

				.addOption("r2", false, "View raport number 2").addOption("r", true, "Year")
				.addOption("a", true, "First date")
		        .addOption("b", true, "End date");

		CommandLineParser parser = new DefaultParser();

		CommandLine cmd = parser.parse(options, args);

		if (cmd.hasOption("r1")) {
			System.out.println("raport number 1");
		}
		if (cmd.hasOption("r2")) {
			System.out.println("raport number 2");
		}
		if (cmd.hasOption("r")) {

			System.out.println("Date" + cmd.getOptionValue("a"));
			Integer year = Integer.parseInt(cmd.getOptionValue("r"));
		}
		if (cmd.hasOption("a")) {

			System.out.println("First Date" + cmd.getOptionValue("a"));
			LocalDate begindate = LocalDate.parse(cmd.getOptionValue("a"));
		}
		if (cmd.hasOption("b")) {

			System.out.println("End Date" + cmd.getOptionValue("b"));
			LocalDate begindate = LocalDate.parse(cmd.getOptionValue("b"));
		}
		}
	
	}

