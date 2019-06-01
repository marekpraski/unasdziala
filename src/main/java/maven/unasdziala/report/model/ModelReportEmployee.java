package maven.unasdziala.report.model;

import java.util.ArrayList;
import java.util.List;

public class ModelReportEmployee {

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
	
	
	
	
	
	
	
}
