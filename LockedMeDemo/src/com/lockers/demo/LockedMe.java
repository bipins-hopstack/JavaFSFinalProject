package com.lockers.demo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LockedMe { 
	static final String projectFilePath="C:\\Users\\Bipin\\eclipse-workspace\\phase1_assignment\\LockedMeFolder";
	static final String errorMSG="Oops!! Some error occured.please contact :admin@lockedme.com";

	public static void main(String[] args) {
		try {
			int choice;
			Scanner obj=new Scanner(System.in);
			do {
				displayMenu();
				choice=obj.nextInt();
				obj.nextLine();
				switch(choice) {
				case 1:{getFiles();
				break;}
				case 2:{addFiles();
				break;}
				case 3:{deletFiles();
				break;}
				case 4:{searchFiles();
				break;}
				case 5:System.exit(0);
			}	
			}
			while(choice >0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(errorMSG);
		}
		
	}
	private static void searchFiles() {
		// TODO Auto-generated method stub
		try {
			File directoryPath = new File(projectFilePath);
			Scanner obj=new Scanner(System.in);
			String searchFileName;
			  //List of all files and directories
			System.out.println("please enter file name to search");
			searchFileName=obj.nextLine();
			  String[] contents = directoryPath.list();      
			  if(contents.length!=0) {
			  for(var i:contents) {
				  if(searchFileName.equals(i.toString()))
			     System.out.println("File is found");
			  }
			  }
			  else {
				  System.out.println("Sorry there are no files in the specified directory");
			  }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(errorMSG);
			
		}
		
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
				  System.out.println("Sorry there are no files in the specified directory");
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
			+ "\t\t\t 1) Display all files in the directory \n"
			+ "\t\t\t 2) Add new file \n"
			+ "\t\t\t 3) Delete a files \n"
			+ "\t\t\t 4) Search a file \n"
			+ "\t\t\t 5) Exit \n"
			+"\t\t\t Eneter your choice :";
			
	       System.out.println(welcome);
	}
		
		//Add a new file
	public static void addFiles() {
		
		try {
			Scanner obj=new Scanner(System.in);
			String fileName;
			int linesCount;
			
			System.out.println("Please Enter file name to create");
			fileName=obj.nextLine();
			System.out.println("please enter no of lines");
			linesCount=Integer.parseInt(obj.nextLine());
				
		      File myObj = new File(projectFilePath+"\\"+fileName);
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		        FileWriter myWriter = new FileWriter(projectFilePath+"\\"+fileName);
		        	for(int i=1;i<=linesCount;i++) {
		        		System.out.println("Enter line "+i);
		        		myWriter.write(obj.nextLine()+"\n");
		        		}
		        myWriter.close();
		        System.out.println("Successfully wrote to the file.");
		      } else {
		        System.out.println("File already exists.Try Different Name");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		    
		    }
	}
		
		//Delete a file
	public static void deletFiles() {
		Scanner obj= new Scanner(System.in);
		boolean isTrue = false;
		try {
			File directoryPath = new File(projectFilePath);
			System.out.println("Please Enter file name  to delete");
			String fileName=obj.nextLine();
			String[] contents = directoryPath.list();
			
			File filePath=new File(projectFilePath+"\\"+fileName);
			for(var i:contents) { 
				isTrue= i.equals(fileName);
				if(isTrue){
					filePath.delete();
			System.out.println("File deleted sucessfully");
			break;
			 }
			}
			if(!isTrue) {
				System.out.println("Sorry No file exists by the name"+fileName);
			}
				
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(errorMSG);
		}
		
	}

}
