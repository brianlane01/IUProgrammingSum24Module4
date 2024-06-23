
/**
 * Description: Extra Credit Problem 2
 * 		Re-write the solution for Problem 2 using a regular one-dimensional Array instead of an ArrayList. Name your class RegistrarMenuArray
 * 		
 * 		Basics of problem 2 that needs to be rewritten as one-dimensional
 * 
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
import java.util.Arrays;

public class RegistrarMenuArray {
	
	//initialize the array. it has a capacity of 20 courses and is of type string to allow for for the course names to be saved
	static String[] courseList = new String[20];  
	
	// Globally scoped variable to count the number of courses in the registrar array
	static int courseCount = 0;
	
	public static void main(String[] args) {
		
		// Scanner object will allow user to enter in a menu selection...
		Scanner input = new Scanner(System.in);
		boolean finished = false;
		int userChoice = 0;
		
		
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
			
			// Loop until a valid choice is entered
			// the loop will handle if the user was to enter anything other than a integer such as b/, so that it does not break the program and cause you to start over
			boolean validChoice = false;
			
			while (!validChoice) {
				String userInput = input.nextLine();
				if (userInput.matches("[1-5]")) {
					userChoice = Integer.parseInt(userInput);
					validChoice = true;
				} 
				else {
					System.out.println("Invalid Input. Please enter a number between 1 and 6.");
				}
			}
			
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
		
		//checks  the course by calling the created helper method that checks to see if the entered course is a duplicate if so does not add
		if ( containsCourse(course)) {
			System.out.println("The course: " + course + " already exists and was not added to the list.");
		}
		
		// if not a duplicate adds the course to the Array
		else {
			
			// this is a check to see if the array is at maximum capacity if it is then the helper method resizeArray is called 
			// this will allow for the size of the array to be increased to add additional courses
			if (courseCount == courseList.length) {
			 	   resizeArray();
			    }
			
			// This will correctly add the new course to the array at the next available position. It updates the courseList array, 
			// so that the new course is stored and the array remains accurate.
			courseList[courseCount] = course; 
			
			// courseCount variable is then updated to the new course count...
			courseCount++; 
			System.out.println("The course: " + course + " was successfully add to the list.");
		}
		
	}
	
	/**
     * Description: This method will allow a user to delete a course from the Registrar list. 
     * 				The user will be able to input a name for the course after which the 
     * 				program will convert all the enter characters to upper case to avoid case sensitivity 
     * 				issues. The method will then check to see if the course is in the Array before finally 
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
		
		// This will use the helper method courseIndex to find the index of the course the user inputed to determine if the course is in the list
		// the helper method returns the index or -1.. -1 means it it is not in the list 
		int index = courseIndex(course);
				
		// checks for the course in the list if found deletes the course 
		// -1 means it it is not in the list 
		if (index != -1) {
			
			//  for-loop to shift all elements after the found course one position to the left. This removes the course from the array without messing with the other elements .
			for (int i = index; i < courseCount -1; i++) { 
				// this will assign the value of the next element (courseList[i + 1]) to the current position (courseList[i]).
				courseList[i] = courseList[i + 1]; 
			}
			
			//need to remove the duplicate element that was shifted.
			courseList[courseCount - 1] = null;
			
			// lower the course count by one because the course was removed from the array
			courseCount--;
			System.out.println("The course: " + course + " was removed from the list.");
		}
		
		// if course is not in the Array the program displays the following message and goes back to the main menu 
		else {
			System.out.print("The course: " + course + " was not found in the list.");
		}
		
	}
	
	/**
     * Description: This method will allow a user to see how many computing courses are in the Registrar list. 
     * 				the program will go through each element in the Array checking the first 4 characters of each entry
     * 				to see if they equal COMP if so the compCourses variable is incremented by 1. After the entire Array
     * 				has been checked then it will display the current value of compCourses. 
     * @param this method does not currently take in any parameters
     * @return this method does not return anything
     */
	public static void numComputingCourses() {
		int compCourses = 0; 
		
		// the for loop allows us to go over each element in the Array
		for (int i = 0; i < courseCount; i++) {
			
			// utilizing the try catch to handle any entries in the Array that are less the four characters long.
			try {
				if (courseList[i].substring(0, 4).equals("COMP")) {
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
     * Description: This method will go through each item in the Array and display each course on a new line in the console.  
     * @param this method does not currently take in any parameters
     * @return this method does not return anything
     */
	public static void displayCourses() {
		System.out.println("These are the current courses in the Registrar List: ");
		
		for (String crs: courseList) {
			
			// since the array has an initial capacity of 20 if there are not 20 courses in the list the system will display null for any index values that do not contain anything
			System.out.println(crs);
		}	
	}
	
	/**
     * Description: This method will go through each item in the Array and check if the course that was passed in as a parameter already exists in the array.  
     * @param of type String received from the createCourse method above 
     * @return true or false; true the course is already in the array or false the course is not in the array
     */
	public static boolean containsCourse(String course) {
		
		// goes through the array to see if the course is already in the array
		for (int i = 0; i < courseCount; i++) {
			if (courseList[i].equals(course)) {
				return true;
			}
		}
		return false;
	}
	
	/**
     * Description: This method will essentially create a new array for the program to use to store courses. 
     * 				When the array contains 20 elements, new courses cannot be added because arrays have a fixed size once they are created. 
     * 				This method will copy the original array and then double its length each time it reaches capacity. This allows you to add new courses.
     * 				The new, larger array is then assigned back to the courseList variable. This allows us to increase the size of the array while maintaining the integrity of the values
     * 				already in  the array. 
     * @param this method does not currently take in any parameters
     * @return this method does not return anything
     */
	public static void resizeArray() {
		courseList = Arrays.copyOf(courseList, courseList.length * 2);
	}
	
	/**
     * Description: This method searches for the specified course in the courseList array. It will check each element to see if it matches the course parameter.
     * 				If a match is found, it returns the index of the matching element. If no match is found after checking, it returns -1 to indicate that the course is not in the array. 
     * 				This method identifies the specific position of the course to accurately delete the course from a one-dimensional array.
     * @param of type String received from the removeCourse method above 
     * @return int, either the index position of the course or -1 if the course is not in the list 
     */
	public static int courseIndex(String course) {
		
		for (int i = 0; i < courseCount; i++) {
			if (courseList[i].equals(course)) {
				return i;
			}
		}
		return -1;
	}

}

