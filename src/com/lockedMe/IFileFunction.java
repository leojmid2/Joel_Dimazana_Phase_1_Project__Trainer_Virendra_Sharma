package com.lockedMe;

import java.io.File;

interface IFileFunction {
	
	boolean showFiles(); 
	void searchFile(File file);
	void deleteFile(File file);
	void addFile(File file);
}
