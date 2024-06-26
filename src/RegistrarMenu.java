/**
 * Description: 
 * 		Consider the program that was demonstrated in this module's Video. The program allows the user to use a menu that deals with courses.  
 * 		Starting with the finished code that was demonstrated in the video, enhance the program with the following additional requirements:
 * 		
 * 		1. Ensure case-insensitive addition and removal of courses. One way to achieve this is to convert the courses to upper-case or lower-case before 
 * 		adding the course to the list.
 * 
 * 		2. Ensure that no duplicate courses are added to the array. So, if the course that the user is trying to add already exists, your code will reject 
 * 		the addition. Display appropriate messages to the user regardless (The course is added or the course already exists and it was not added to the list)
 * 
 * 		3. Implement the method that counts the number of computing courses in the array. A course is a computing course if the title of the course begins with 
 * 		the four letters COMP.  Hint: use the substring method of the String class.
 * 
 * @Group: Team White
 * 		@Members: Brian Lane, Yash Patel, Gavin Werner
 * 
 * @Date: June 17, 2024
 * 
 */

import java.util.Scanner;
import java.util.ArrayList;

public class RegistrarMenu {
	
	static ArrayList<String> courseList = new ArrayList<String>();
	
	public static void main(String[] args) {
		
		// Scanner object will allow user to enter in a menu selection...
		Scanner input = new Scanner(System.in);
		boolean finished = false;
		int userChoice;
		
		
		while (finished == false) {
			//Menu Display
			System.out.println("");
			System.out.println("         Team White Registrar Menu         ");
			System.out.println("");
			System.out.println("|=========================================|");
			System.out.println("|                                         |");
			System.out.println("| 1. Create a  New Course                 |");
			System.out.println("| 2. Remove a Course                      |");
			System.out.println("| 3. Number of Computing Courses in List  |");
			System.out.println("| 4. Display the Current Courses          |");
			System.out.println("| 5. Exit                                 |");
			System.out.println("|                                         |");
			System.out.println("|=========================================|");
			System.out.print("Please enter your choice (1-5): ");
			
			userChoice = input.nextInt();
			
			/*
			 * The following switch statement will match the users inputed integer to one of the following cases...
			 * If a user enters the # 3 then the program will go to case 3 call the numComputingCourses method and then do what is in that method 
			 * The Program follows a similar approach with the other cases
			 * The default will handle if the use enters anything other than 1-5
			 */
			switch (userChoice) {
			
			// Cases 1-4 will call on the method listed under them when they are selected
			case 1:
				createCourse();
				break;
			case 2:
				removeCourse();
				break;
			case 3:
				numComputingCourses();
				break;
			case 4:
				displayCourses();
				break;
				
			// This will close the program
			case 5:
				System.out.println("Exiting the Registrar Menu");
				finished = true;
				break;
			// handles if anything other than 1-5 is entered
			default:
				System.out.println("Invalid Input");
			} // end of switch statement
		} // end of while loop
		
		input.close();
	} //end of main
	
	/**
     * Description: This method will allow a user to add a course to the Registrar list. 
     * 				The user will be able to input a name for the course after which the 
     * 				program will convert all the enter characters to upper case to avoid case sensitivity 
     * 				issues. The method will then check to see if the course is already added or not before finally 
     * 				adding it to the list. 
     * @param this method does not currently take in any parameters
     * @return this method does not return anything
     */
	public static void createCourse() {
		
		// Scanner object will allow user to enter in a course
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please enter the title of the course you are creating: ");
		
		// The compiler takes the users entered text converts it to upper case
		// used nextLine here so that if the course title is more than one word the whole title will be captured and not just the first word...
		String course = input.nextLine().toUpperCase();
		
		//checks to see if the course is a duplicate if so does not add
		if ( courseList.contains(course)) {
			System.out.println("The course: " + course + " already exists and was not added to the list.");
		}
		
		// if not a duplicate adds the course to the ArrayList
		else {
			courseList.add(course);
			System.out.println("The course: " + course + " was successfully add to the list.");
		}
		
	}
	
	/**
     * Description: This method will allow a user to delete a course from the Registrar list. 
     * 				The user will be able to input a name for the course after which the 
     * 				program will convert all the enter characters to upper case to avoid case sensitivity 
     * 				issues. The method will then check to see if the course is in the ArrayList before finally 
     * 				deleting it from the list. 
     * @param this method does not currently take in any parameters
     * @return this method does not return anything
     */
	public static void removeCourse() {
		
		// Scanner object will allow user to enter in a course
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please enter the title of the course you are removing: ");
		
		// The compiler takes the users entered text converts it to upper case
		// used nextLine here so that if the course title is more than one word the whole title will be captured and not just the first word...
		String course = input.nextLine().toUpperCase();
		
		// checks for the course in the list if found deletes the course 
		if (courseList.contains(course)) {
			courseList.remove(course);
			System.out.print("The course: " + course + " was removed from the list.");
		}
		
		// if course is not in the ArrayList the program displays the following message and goes back to the main menu 
		else {
			System.out.print("The course: " + course + " was not found in the list.");
		}
		
	}
	
	/**
     * Description: This method will allow a user to see how many computing courses are in the Registrar list. 
     * 				the program will go through each element in the ArrayList checking the first 4 characters of each entry
     * 				to see if they equal COMP if so the compCourses variable is incremented by 1. After the entire ArrayList 
     * 				has been checked then it will display the current value of compCourses. 
     * @param this method does not currently take in any parameters
     * @return this method does not return anything
     */
	public static void numComputingCourses() {
		int compCourses = 0; 
		
		// the for loop allows us to go over each element in the ArrayList 
		for (String course : courseList) {
			
			// utilizing the try catch to handle any entries in the ArrayList that are less the four characters long.
			try {
				if (course.substring(0, 4).equals("COMP")) {
					compCourses++;
				}
			}
			
			// with the current setup if the system comes across an entry the is 3 or less characters it can throw the StringIndexOutOfBoundsException exception
			// the catch block below will simply catch the exception and keep going to the next entry in the ArrayList without the program stopping because of the exception..
			// by leaving the catch portion blank as it currently is the program will simply continue with the next iteration of the loop without incrementing the count
			catch (StringIndexOutOfBoundsException e) {
				
			}
		}
		
		System.out.println("The number of computing courses in the list is: " + compCourses + " .");
	}
	
	/**
     * Description: This method will go through each item in the ArrayList and display each course on a new line in the console.  
     * @param this method does not currently take in any parameters
     * @return this method does not return anything
     */
	public static void displayCourses() {
		for (String crs: courseList) {
			System.out.println(crs);
		}	
	}

}

