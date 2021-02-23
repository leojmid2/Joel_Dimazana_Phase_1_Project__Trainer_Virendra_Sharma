package com.lockedMe;

import java.io.File;
import java.io.IOException;

public class FileFunction implements IFileFunction {

	//need ascending order sorting
	@Override
	public boolean showFiles() {
		// TODO Auto-generated method stub
		
		String workingPath = System.getProperty("user.dir");
		System.out.println("working path " + workingPath);

	//	test 1
	//	File  file = new File(workingPath+"/myFolder/EmptyFolder");

	//	test 2
		File  file = new File(workingPath+"/myFolder");

		String[] fileList = file.list();
		
		if (fileList.length==0) {
			System.out.println(file.getPath() +" - No files found in the current directory");

		}
		else {
			System.out.println("Files in the " + file.getPath() + "directory:");
			for (String name:fileList) {
				System.out.println(name);
			}
		}
		return false;
	}

	//need to search method
	@Override
	public void searchFile() {
		// TODO Auto-generated method stub
		String workingPath = System.getProperty("user.dir");
		System.out.println("working path " + workingPath);
		
		//	test 1
		File  file = new File(workingPath+"/myFolder");
	}

	@Override
	public void deleteFile() {
		// TODO Auto-generated method stub

	}

	@Override
	public void  addFile(File file) {
		// TODO Auto-generated method stub
		boolean fileExist = false; 
		try {
			if (file.createNewFile()) 
				System.out.println("File - " + file + " has been added");
			else 
				System.out.println("File - " + file + " already Exist");
						
		} catch (IOException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		};
		
	}

}
