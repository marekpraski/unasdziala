package maven.unasdziala.parser;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FileLister {

	private List<String> resultList = new LinkedList<>();
	private String pth;


	FileLister(String pth) {
		this.pth = pth;

		listFiles(pth);
		

	}

	public List<String> getResultList() {
		return resultList;
	}

	private void listFiles(String path) {
		File folder = new File(path);

		File[] files = folder.listFiles();

		for (File file : files) {
			String appendix =null;
			if (file.isFile()) {
				int pointPosition =  file.getName().lastIndexOf('.');
				if (pointPosition>0) {
					appendix = file.getName().substring(pointPosition);
				}
				if((file.getName().contains(".xlsx") && appendix.length()==4) ||
						(file.getName().contains(".xls") && appendix.length()==3)
						|| (file.getName().contains(".xlsb") && appendix.length()==4)) {
					
					this.resultList.add(file.getAbsolutePath());
					
				}
			} else if (file.isDirectory()) {
				listFiles(file.getAbsolutePath());
				
			}
		}
	}


}
