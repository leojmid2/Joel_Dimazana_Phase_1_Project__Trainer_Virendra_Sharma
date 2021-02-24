package com.lockedMe;

import java.util.Scanner;
import java.io.File;

public class LockedMeMain {
	
	IFileFunction fileFunction = new FileFunction();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		
		LockedMeMain runner = new LockedMeMain();
		runner.chooseOption();
	}
		
	private void chooseOption() {
		boolean exitApp = true;
		File file = null;
		Scanner userInput = null;
		String selection = null;
		int option = 0;
		userInput = new Scanner(System.in);

		do {				
			do {
			System.out.println("Please choose an OPTION: ");
			System.out.println("PRESS [1] to Display Current files ");
			System.out.println("PRESS [2] to Display User files ");
			System.out.println("PRESS [3] to Close the application ");
				
			selection = userInput.next();
				
			if (!selection.matches("[123]")) {
				System.out.println("Invalid selection. Please try again");
			}
				
			} while (!selection.matches("[123]"));	
					
			option = Integer.valueOf(selection); 
					
			switch (option) {
			case 1: {
				System.out.println("OPTION: Show Files "); 
				fileFunction.showFiles();
				break;
			}
			case 2: {
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
					System.out.println("Please enter a file to add"); 
					file = new File(userInput.next());
					fileFunction.addFile(file);
				}
				else if(selection.equalsIgnoreCase("D")) {
					System.out.println("Please enter a file to delete"); 
					file = new File(userInput.next());
					fileFunction.deleteFile(file);
				}
				else if(selection.equalsIgnoreCase("S")) {
					System.out.println("Please enter a file name to search"); 
					file = new File(userInput.next());
					//System.out.println(System.getProperty("user.dir"));
					fileFunction.searchFile(file);
				}
				break;
			}
			case 3: {
				System.out.println("Thank you for using the application"); 
				userInput.close();
				System.exit(0); 
				break;
				}
			}
				
			do {
				System.out.println("\nGo back to MAIN MENU? [Y/N]");
				selection = userInput.next();
				if(!selection.matches("[YNyn]")) {
					System.out.println("Invalid selection. Please try again.");
				}
			} while (!selection.matches("[YNyn]"));

			if (selection.equalsIgnoreCase("n")) {
				exitApp = false;
				System.out.println("Thank you for using the application"); 
			}			
		} while (exitApp);
		userInput.close();
	}

}	//end of class
