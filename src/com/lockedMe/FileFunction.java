package com.lockedMe;

import java.io.File;
import java.io.IOException;

public class FileFunction implements IFileFunction {

	//need ascending order sorting
	@Override
	public boolean showFiles() {
		
		String workingPath = System.getProperty("user.dir");
		File  file = new File(workingPath);

		String[] fileList = file.list();
		
		if (fileList.length==0) {
			System.out.println(file.getPath() +" - No files found in the current directory");
		}
		else {
			System.out.println("This are files in '" + file.getPath() + "' directory");
			for (String name:fileList) {
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
		// TODO Auto-generated method stub
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


}
