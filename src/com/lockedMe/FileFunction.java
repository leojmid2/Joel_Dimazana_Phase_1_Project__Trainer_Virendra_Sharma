package com.lockedMe;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileFunction implements IFileFunction {

	@Override
	public boolean showFiles() {
		
		//Maybe user can find a path and search there
		String workingPath = System.getProperty("user.dir");
		File  file = new File(workingPath);

		String[] fileList = file.list();
		
		//need to change implementation of sort and search using algorithm.
		
		List<String> fileList2 = Arrays.asList(fileList);
		Collections.sort(fileList2);
		
		if (fileList.length==0) {
			System.out.println(file.getPath() +" - No files found in the current directory");
		}
		else {
			System.out.println("This are files in '" + file.getPath() + "' directory");
			
			
			for (String name:fileList2) {
				System.out.println(name);
			}
		}
		return false;
	}

	@Override
	public void searchFile(File filename) {
		if(filename.exists()){
			System.out.println("file : " + filename + " exist in the directory");
		}
		else {
			System.out.println("file : " + filename + " doesn't exist in the directory");
		}

	}
	
	@Override
	public void deleteFile(File file) {
		if (file.exists()) {
			file.delete();
			System.out.println("File: " + file + " successfully deleted");
		}
		else 
			System.out.println("File: " + file + " not found");
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
