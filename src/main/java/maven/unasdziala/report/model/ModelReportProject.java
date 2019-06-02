package maven.unasdziala.report.model;

import java.util.ArrayList;
import java.util.List;

public class ModelReportProject {
	
	
private List<String> listForReport = new ArrayList<>();
	
	public void appendList(String str){
		this.listForReport.add(str);		
	}

	public List<String> getListForReport() {
		return listForReport;
	}

	public void setListForReport(List<String> listForReport) {
		this.listForReport = listForReport;
	}
	
	
	
	
//	private ArrayList<ArrayList<String>> lineToPrint;
//
//	public ArrayList<ArrayList<String>> getLineToPrint() {
//		return lineToPrint;
//	}
//
//	public void setLineToPrint(ArrayList<ArrayList<String>> lineToPrint) {
//		this.lineToPrint = lineToPrint;
//	}
//	
//	public void addMainLine(ArrayList<String> strArr) {
//		lineToPrint.add(strArr);
//	}
	
	

	
	

}
