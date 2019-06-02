package maven.unasdziala;


import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Reader {
	public static void main(String[] args) throws ParseException {

	      
	      Options options = new Options();

	     
	      options.addOption("r1", false, "View raport number 1")

	       .addOption("r2", false, "View raport number 2")
	      .addOption("r", true, "Year");
	      
	      CommandLineParser parser = new DefaultParser();

	      CommandLine cmd = parser.parse( options, args);

	  
	      if(cmd.hasOption("r1")) { 
	         System.out.println("raport number 1");
	      }
	      if(cmd.hasOption("r2")) {
	         System.out.println("raport number 2");
	      }
	      if(cmd.hasOption("r")) {
	          
	       
	          System.out.println("Year"+cmd.getOptionValue("r"));
	          Integer year=Integer.parseInt(cmd.getOptionValue("r"));
	      }
	   }} 

