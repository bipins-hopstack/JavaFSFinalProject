package com.lockers.demo;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LockedMe { 
	static final String projectFilePath="C:\\Users\\Bipin\\eclipse-workspace\\phase1_assignment\\LockedMeFolder";
	static final String errorMSG="\"Oops!! Some error exists\"";

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		displayMenu();
		getFiles();
		deletFiles();
	}
	
	/***
	 * To get files from the specified directory and display
	 */
	public static void getFiles() {
		try {
			File directoryPath = new File(projectFilePath);
			  //List of all files and directories
			  String[] contents = directoryPath.list();      
			  if(contents.length!=0) {
			  System.out.println("List of files and directories in the specified directory:");
			  for(var i:contents) {
			     System.out.println(i.toString());
			  }
			  }
			  else {
				  System.out.println("Sorry there are no Files in the specified directory");
			  }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(errorMSG);
			
		}
	}
	//Display user Option
	public static void displayMenu()
	{   String welcome="\t********************LOCKEDME.COM*************************\n"
			+ "\t*****************Author:BIPIN REDDY**********************\n"
			+ "\t\t\t 1) Add Files \n"
			+ "\t\t\t 2) Delet Files \n"
			+ "\t\t\t 3) Search Files \n"
			+ "\t\t\t 4) Add Files \n"
			+ "\t\t\t 5) Exit \n";
			
	
		System.out.println(welcome);
	}
		
		//Add a new file
	public static void addFiles() {
		
	}
		
		//Delete a file
	public static void deletFiles() {
		try {
			File directoryPath = new File(projectFilePath);
			Scanner obj= new Scanner(System.in);
			String fileName=obj.nextLine();
			String[] contents = directoryPath.list();
			for(var i:contents) { 
				File filePath=new File(projectFilePath+"\\"+fileName);
				    if(i.equals(fileName)) {
					filePath.delete();
			System.out.println("File deleted sucessfully");
			break;
			 }
				else {
					System.out.println("Sorry No File Exists By The Given Name");
					break;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("");
		}
	}
		
		//Search a file
	public static void serachFiles() {
		
	}
}
