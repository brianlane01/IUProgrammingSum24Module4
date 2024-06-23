/**
 * File: RegistrarMenuArrayList.java
 * Description: This program is about practicing array lists in java. This structure will store and manipulate courses that are offered by the registrar
 * @author: Awny Alnusair
 * @version 1.0
 */

import java.util.Scanner;
import java.util.ArrayList;

public class RegistrarMenuArrayList
{
	static Arraylist<String> courseList = new ArrayList<String>();

	public static void main(String[] args)
	{
			Scanner input = new Scanner( System.in );
			boolean finished = false;
			int userChoice;

			while (finished == false)
			{
				// Menu Display
				System.out.println("");
				System.out.println("Registrar Menu");
				System.out.println("====================");
				System.out.println(" 1.  Create a course");
				System.out.println(" 2.  Remove a course from the list");
				System.out.println(" 3.  The number of computing courses in the list");
				System.out.println(" 4.  Current courses in the list");
				System.out.println(" 5.  Exit");
				System.out.println("");

				// Get the input from the user
				System.out.print("Please input your choice (1-5): ");
				userChoice = input.nextInt();
				// switch to correspondence function
				switch (userChoice)
				{
					case 1:
						createCourse();break;
					case 2:
						removeCourse();break;
					case 3:
						numComputingCourses();break;
					case 4:
						displayCourses();break;
					case 5:
						finished = true; break;
					default:
						System.out.println("Invalid Input!\n");break;
				} // end switch
			} // end while
	} // end of main method

	public static void createCourse() {
		Scanner input = new Scanner( System.in );
		System.out.print("Please enter the title of the course: ");
		String course = input.nextLine().trim().toUpperCase();

		if (courseList.contains(course)) {
				System.out.println("The course already exists.");
		} 
		
		else {
				courseList.add(course);
				System.out.println("The course was successfully added to the list.");
		}
	}

	public static void removeCourse() {
		Scanner input = new Scanner( System.in );
		System.out.print("Please enter the title of the course that you are removing: ");
		
		 String course = input.nextLine().trim().toUpperCase();
		
		if (courseList.contains(course)){
			courseList.remove(course);
			System.out.print("The course was successfully removed from the list");
		}
		else
			System.out.print("The course is not found in the list");
	}

	public static void numComputingCourses() {
		int count = 0;
		
		for (String course : courseList) {
				if (course.length() >= 4 && course.substring(0, 4).equals("COMP")) {
						count++;
				}
		}
		System.out.println("The number of computing courses in the list: " + count);
	}

	public static void displayCourses() {
		for (String crs: courseList) {
			System.out.println(crs);
		}

	}
	
}





