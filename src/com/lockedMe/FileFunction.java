package com.lockedMe;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
		 * Replace file.exists() function to accommodate case sensitive filename
		 * 
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

	@Override
	public List<String> listDirectory() {
		String workingPath = System.getProperty("user.dir");
		File  currentFiles = new File(workingPath);
		List<String> directory = new ArrayList<String>();
		
		System.out.println("current " + currentFiles);
		
		File[] files = currentFiles.listFiles();
		for (File file:files) {
			if (file.isDirectory()) {
				directory.add(file.getName());
			}
		}
		Collections.sort(directory);
		return directory;	
	}

}//end of class
