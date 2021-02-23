package com.lockedMe;

import java.io.File;

public class FileFunction implements IFileFunction {

	@Override
	public boolean showFiles() {
		// TODO Auto-generated method stub
		
		String workingPath = System.getProperty("user.dir");
		System.out.println("working path " + workingPath);

	//	test 1
	//	File  file = new File(workingPath+"/myFolder/EmptyFolder");

	//	test 2
		File  file = new File(workingPath+"/myFolder");

	//	System.out.println("test folder " + file.getName()+ " " +file.exists());
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

	@Override
	public void searchFile() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteFile() {
		// TODO Auto-generated method stub

	}

}
