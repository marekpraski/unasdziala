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
			if (file.isFile()) {
				if(file.getName().contains(".xlsx") || file.getName().contains(".xls") || file.getName().contains(".xlsb")) {
					
					this.resultList.add(file.getAbsolutePath());
					
				}
			} else if (file.isDirectory()) {
				listFiles(file.getAbsolutePath());
				
			}
		}
	}


}
