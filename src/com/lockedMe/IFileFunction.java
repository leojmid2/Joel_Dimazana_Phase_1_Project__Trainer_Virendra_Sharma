package com.lockedMe;

import java.io.File;

interface IFileFunction {
	
	void showFiles(); 
	void searchFile(File file);
	void deleteFile(File file);
	void addFile(File file);
}
