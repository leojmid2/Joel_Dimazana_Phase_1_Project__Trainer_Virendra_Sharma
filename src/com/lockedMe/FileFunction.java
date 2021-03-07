package com.lockedMe;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileFunction implements IFileFunction {

	@Override
	public void showFiles() {
		
		String workingPath = System.getProperty("user.dir");
		
		File  file = new File(workingPath);

		String[] fileList = file.list();

		if (fileList.length==0) {
			System.out.println(file.getPath() +" - No files found in the current directory");
		}
		else {
			
			System.out.println("This are files in '" + file.getPath() + "' directory");
			List<String> fileList2 = Arrays.asList(fileList);
			Collections.sort(fileList2);

			for (String name:fileList2) {
				System.out.println(name);
			}
		}
	}
	
	@Override
	public void searchFile(File filename) {
		if(filename.exists()){
			System.out.println("file : " + filename + " exist in current directory");
		}
		else {
			System.out.println("file : " + filename + " doesn't exist in the current directory");
		}

	}
	
	@Override
	public void deleteFile(File file) {
		String workingPath = System.getProperty("user.dir");
		File  path = new File(workingPath);
		String[] files = path.list();

		
		/**
		 * Replaced file.exists() function to accommodate case sensitive filename
		 */
		if (isExistCaseSensitive(file, files)) {
			file.delete();
			System.out.println("File: " + file + " successfully deleted");
		}
		else {
			System.out.println("File: " + file + " not found. Please check case sensitivity");
		}
	}
	
	
	public boolean isExistCaseSensitive(File file, String[] files) {
		for (String f:files ) {
			if (f.equals(file.toString())){
				return true;
			}
		}
		return false;
	}

	@Override
	public void  addFile(File file) {
		try {
			if (file.createNewFile()) 
				System.out.println("File - " + file + " has been added");
			else 
				System.out.println("File - " + file + " already Exist");
						
		} catch (IOException e) {
			e.printStackTrace();
		};
	}


}//end of class
