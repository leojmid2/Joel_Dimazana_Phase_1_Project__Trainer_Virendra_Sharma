package com.lockedMe;

import java.io.File;

interface IFileFunction {
	
	boolean showFiles(); 
	void searchFile();
	void deleteFile();
	void addFile(File file);
}
