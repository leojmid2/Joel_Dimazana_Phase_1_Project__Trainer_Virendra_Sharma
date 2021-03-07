package com.lockedMe;

import java.util.Scanner;
import java.io.File;

public class LockedMeMain {
	
	IFileFunction fileFunction = new FileFunction();
	
	public static void main(String[] args) {
		LockedMeMain lockedMe = new LockedMeMain();
		lockedMe.welcome();
		lockedMe.chooseOption();
	}
	
	private void welcome() {
		System.out.println("*******************************************************");
		System.out.println("*******************************************************");
		System.out.println("**                                                   **");
		System.out.println("**                                                   **");
		System.out.println("**               WELCOME TO LockedMe.com             **");
		System.out.println("**                                                   **");
		System.out.println("**                    Developed by:                  **");
		System.out.println("**                    Joel Dimazana                  **");
		System.out.println("**                                                   **");
		System.out.println("**                                                   **");
		System.out.println("*******************************************************");
		System.out.println("*******************************************************\n");
	}

		
	private void chooseOption() {
		Scanner userInput = null;
		String selection = null;
		int option = 0;
		userInput = new Scanner(System.in);

		do {		
			option = mainMenu(userInput);
			switch (option) {
			case 1: {
				System.out.println("OPTION: Show Files "); 
				fileFunction.showFiles();
				break;
			}
			case 2: {
				userMenu(userInput);
				break;
			}
			case 3: {
				System.out.println("Thank you for using lockedMe.com"); 
				userInput.close();
				System.exit(0); 
				break;
				}
			}
		} while (backToMenu(selection, userInput));
		userInput.close();
	}
	
	
	private int mainMenu(Scanner userInput) {
		String selection = null;
		do {
			System.out.println("Please choose an OPTION: ");
			System.out.println("PRESS [1] to Display Current files ");
			System.out.println("PRESS [2] to Display User Options [Add][Delete][Search] ");
			System.out.println("PRESS [3] to Close the application ");
				
			selection = userInput.next();
				
			if (!selection.matches("[123]")) {
				System.out.println("Invalid selection. Please try again");
			}			
		} while (!selection.matches("[123]"));	
		
		return Integer.valueOf(selection); 
	}
	
	private void userMenu(Scanner userInput) {
		String selection = null;
		String fileName = null;
		File file = null;
		do {
			System.out.println("Please select an option:"); 
			System.out.println("[A] - add files"); 
			System.out.println("[D] - delete files"); 
			System.out.println("[S] - search files"); 
			System.out.println("Please enter an option: "); 
			selection = userInput.next();
			if (!selection.matches("[adsADS]")) {
					System.out.println("Invalid selection. Please try again");
				}						
		} while (!selection.matches("[adsADS]"));	
					
		if(selection.equalsIgnoreCase("A")) {
/*			System.out.println("List of Directory: "+ fileFunction.listDirectory().toString());
			System.out.println("Please choose the directory you wish to add the file."); 
			System.out.println("If directory is not specified, the file will be added to the current directory"); 
			String directory = userInput.next();
			
*/
			
			System.out.println("Please enter the file to add"); 
			fileName = userInput.next().toLowerCase(); 	//This is to ignore case and always convert to lower case
			file = new File(fileName);
			fileFunction.addFile(file);
		}
		else if(selection.equalsIgnoreCase("D")) {
			System.out.println("Please enter a file to delete(Case Sensitive)."); 
			file = new File(userInput.next());
			fileFunction.deleteFile(file);
		}
		else if(selection.equalsIgnoreCase("S")) {
			System.out.println("Please enter a file name to search"); 
			file = new File(userInput.next());
			fileFunction.searchFile(file);
		}
	}
	
	
	private boolean backToMenu(String selection, Scanner userInput) {
		boolean isExit=true;
		do {
			System.out.println("\nGo back to MAIN MENU? [Y/N]");
			selection = userInput.next();
			if(!selection.matches("[YNyn]")) {
				System.out.println("Invalid selection. Please try again.");
			}
		} while (!selection.matches("[YNyn]"));
		
		if (selection.equalsIgnoreCase("n")) {
			isExit = false;
			System.out.println("Thank you for using the lockedMe.com"); 
		}			
		return isExit;
	}
	
	
}	//end of class
