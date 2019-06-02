package maven.unasdziala.print;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import maven.unasdziala.model.Employee;
import maven.unasdziala.report.report.ReportEmployee;

public class Raport1print {

	private ReportEmployee re;
	
	public Raport1print(ReportEmployee re) {
		this.re = re;
	}

	public void printReport1(List<Employee> employeeList) {
		for (Employee empl : employeeList) {
			for (String str : re.createReportEmployee(empl)) {
				System.out.println(str);
			}
		}
	}

	public void printReport1(List<Employee> employeeList, int year) {
		for (Employee empl : employeeList) {
			for (String str : re.createReportEmployee(empl, year)) {
				System.out.println(str);
			}
		}
	}

	public void printReport1(List<Employee> employeeList, LocalDate beg, LocalDate end) {
		for (Employee empl : employeeList) {
			for (String str : re.createReportEmployee(empl, beg, end)) {
				System.out.println(str);
			}
		}
	}
}
