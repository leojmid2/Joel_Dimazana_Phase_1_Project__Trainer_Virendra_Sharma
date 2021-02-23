package com.lockedMe;


import java.util.Scanner;

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
			case 2: System.out.println("Display User Detail Files"); break;
			case 3: {
				System.out.println("Thank you for using the application"); 
				System.exit(0); 
				break;
				}
				
			}
			
			
		}
	}	
