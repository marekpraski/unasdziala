package maven.unasdziala.parser;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileLister {

	public List<String> resultList;
	public String pth;


	FileLister(String pth) {
		this.pth = pth;

		listFiles(pth);
		

	}
	
	private void listFiles(String path) {
		File folder = new File(path);

		File[] files = folder.listFiles();

		for (File file : files) {
			if (file.isFile()) {
				this.resultList.add(file.getAbsolutePath());
			} else if (file.isDirectory()) {
				listFiles(file.getAbsolutePath());
				
			}
		}
	}


}