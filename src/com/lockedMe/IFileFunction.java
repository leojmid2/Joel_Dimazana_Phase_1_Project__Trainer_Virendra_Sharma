package com.lockedMe;

import java.io.File;
import java.util.List;

interface IFileFunction {
	
	boolean showFiles(); 
	void searchFile(File file);
	void deleteFile(File file);
	void addFile(File file);
	List listDirectory();
}
