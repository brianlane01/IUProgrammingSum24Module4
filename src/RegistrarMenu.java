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
		
		// Scanner object will allow user to enter in courses to the list...
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
			switch (userChoice) {

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
			case 5:
				System.out.println("Exiting the Registrar Menu");
				finished = true;
				break;
			default:
				System.out.println("Invalid Input");
			} // end of switch statement
		} // end of while loop
		
		input.close();
	} //end of main
	
	public static void createCourse() {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter the title of the course you are creating: ");
		String course = input.nextLine().toUpperCase();
		
		if ( courseList.contains(course)) {
			System.out.println("The course: " + course + " already exists and was not added to the list.");
		}
		else {
			courseList.add(course);
			System.out.println("The course: " + course + " was successfully add to the list.");
		}
		
	}
	
	public static void removeCourse() {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter the title of the course you are removing: ");
		String course = input.nextLine().toUpperCase();
		
		
		if (courseList.contains(course)) {
			courseList.remove(course);
			System.out.print("The course: " + course + " was removed from the list.");
		}
		else {
			System.out.print("The course: " + course + " was not found in the list.");
		}
		
	}
	
	public static void numComputingCourses() {
		int compCourses = 0; 
		
		for (String course : courseList) {
			
			try {
				if (course.substring(0, 4).equals("COMP")) {
					compCourses++;
				}
			}
			catch (StringIndexOutOfBoundsException e) {
				
			}
		}
		
		System.out.println("The number of computing courses in the list is: " + compCourses + " .");
	}
	
	public static void displayCourses() {
		for (String crs: courseList) {
			System.out.println(crs);
		}	
	}

}

