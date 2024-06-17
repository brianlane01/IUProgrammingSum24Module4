/*
 * Group Assignment Problem One
 * Description:
 * 	Create a method that accepts an integer array and another integer value. The method will replace all instances of the integer number in the 
 * 	array with zeros and returns the new array. Incorporate the method into a working program that tests the validity of your method. Your program 
 * 	will display the elements of a given array before the method is called, and it will display the elements in the array again right after the method 
 * 	is invoked.
 * 
 * @Group: Team White
 * 		@Members: Brian Lane, Andres Aleman, Yash Patel,Gavin Werner, and Bryan Wills
 * @Date: June 15, 2024
 */

public class MagicArray {
    
    public static void main(String[] args) {
    	
    	
        // This will initialize the array and sets the magic number
        int[] exampleArray = {156, 100, 356, 100, 2545, 543, 100, 100, 435, 3, 100};
        
        // This is the number the method magicReplace will look for in the array to replace
        int magicNumber = 100;
        
        // This will display the above array in the console so that the user can see the array before the magic number 
        // is replaced
        System.out.println("Array before replacement:");
        
        // To practice methods more this is calling a simple method that will print the original array to the console
        printArray(exampleArray);
        
        /*
         * This is declaring and initializing a new array that will be the original array with the magic number replaced
         * In this case 2 will be replace in the original array
         * After the new array is declared it is initialized by calling the magicReplace Method.
         * This method has two parameters that are being passed into one being the array to replace numbers in and the other an int representing 
         * what number needs to be replaced
         */
        int[] modifiedArray = magicReplace(exampleArray, magicNumber);
        
        // After the magicReplace method returns the new array this will print the new array to the console showing that the magic number is replaced
        System.out.println("Array after replacement:");
        
        // To practice methods more this is calling a simple method that will print the original array to the console
        printArray(modifiedArray);
        
    }
    
    /**
     * Description: This method will take in two parameters (The original array and a number that needs to be replaced in the array) it will then replace the
     * 	magic number with a set value (Currently 200) it will then return a new array with every instance of the magicNumber in the original array 
     * 	now replaced with a new value (200)
     * @param theArray
     * @param magicNumber
     * @return a new array with the magic number replaced
     */
    public static int[] magicReplace(int[] theArray, int magicNumber) {
    	
        /*
         * Create a new array to store the result
         * With the theArray.length the compiler knows the new array needs to have the same number of values as the original array
         * This way the new array holds the same number of elements.
         */
        int[] resultArray = new int[theArray.length];
        
        /*
         * We will utilize a for loop that will go through each element of the original array
         * In coding the elements in the array are numbered from 0 up so i is set to 0 so that the method will start with the first number 
         * in the array... If we had i=1 then it would skip the first element in the array
         * The i++ makes the loop go to each number in the array until i is no longer less than theArray.lenght
         * This makes the loop stop once it examines the last index of the array.
         */
        for (int i = 0; i < theArray.length; i++) {
        	
        	//This if statement checks to see if the current number the loop is on is equal to the magic number
            if (theArray[i] == magicNumber) {
            	
            	//If magic number is found then it will be replace with the value of 200
                resultArray[i] = 200;
            } 
            
            //If the value is not equal to the magic number it will pace the current number into the new array
            else {
                resultArray[i] = theArray[i];
            }
        }
        
        //Returns the new array with all instances of the magic number replaced with the value of 0
        return resultArray;
     }
    
    /**
     * Description: Simple method to the takes in a given array and then will print it out to the console in readable format for users
     * @param array
     */
    public static void printArray(int[] array) {
    	
    	//This is simply a loop making it so that each value in the array is separated by a space so that it is more readable.
        for (int element : array) {
            System.out.print(element + ", ");
        }
        System.out.println();
    }
}