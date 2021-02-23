package com.lockedMe;


import java.util.Scanner;
import java.io.File;

public class LockedMeMain {
	
	IFileFunction fileFunction = new FileFunction();


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("********************************************");
		System.out.println("********************************************");
		System.out.println("**                                        **");
		System.out.println("**                                        **");
		System.out.println("**         Welcome to LockedMe.com        **");
		System.out.println("**                                        **");
		System.out.println("**              Developed by:             **");
		System.out.println("**              Joel Dimazana             **");
		System.out.println("**                                        **");
		System.out.println("**                                        **");
		System.out.println("********************************************");
		System.out.println("********************************************\n");
		System.out.println("Please choose an OPTION: ");
		System.out.println("PRESS [1] to return current files ");
		System.out.println("PRESS [2] to return user detail files ");
		System.out.println("PRESS [3] to close the application ");
		
		
		LockedMeMain runner = new LockedMeMain();
		runner.chooseOption();

		
	}
		
		void chooseOption() {
			Scanner userInput = new Scanner(System.in);
			//need to throw exception if not a number
			int option = Integer.valueOf(userInput.nextLine());
			//System.out.println("user input is " + option);
			switch (option) {
			case 1: {
				System.out.println("Display Current Files"); 
				fileFunction.showFiles();
				break;
			}
			case 2: {
				System.out.println("Display User Detail Files"); 
				System.out.println("Please enter a file name"); 
				File file = new File(userInput.next());

				System.out.println("Choose what to do with the file: "); 
				System.out.println("[A] - add files"); 
				System.out.println("[D] - delete files"); 
				System.out.println("[S] - search files"); 
				System.out.println("Please enter an option: "); 
				
				if(userInput.next().equalsIgnoreCase("A")) {
					fileFunction.addFile(file);
				}
				else if(userInput.next().equalsIgnoreCase("D")) {
					System.out.println("Delete the file"); 
				}
				else if(userInput.next().equalsIgnoreCase("S")) {
					System.out.println("Search a file"); 
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
			
			
		}
	}	
