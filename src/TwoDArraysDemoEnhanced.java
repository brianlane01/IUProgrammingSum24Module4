
public class TwoDArraysDemoEnhanced {
		
	public static void main (String args[]){
			
		int[][] firstArray = new int[2][3];// array with 2 rows and 3 columns
		//first row
		firstArray[0][0] = 10;
		firstArray[0][1] = 20;
		firstArray[0][2] = 45;
		
		//second row
		firstArray[1][0] = 11;
		firstArray[1][1] = 15;
		firstArray[1][2] = 17;
		
		System.out.println( "Values in firstArray by row are\n" );
		buildOutput( firstArray );
		
		int[][] secondArray =
		{
			{ 1, 2, 3 },
			{ 4, 5, 6 }
		};
		
		buildOutput( secondArray );
		
		int thirdArray[][] = {
			{ 1, 2 },
			{ 3 }, //The rest will not be initialized to zero!
			{ 4, 5, 6 }
		};
		
		int[][] fourthArray = new int[3][3];
	
		//System.out.println(thirdArray[0][2]);//index out of bound
		//System.out.println(thirdArray[1][1]);//index out of bound
		
		System.out.println(thirdArray[0][1]); //2
	
		System.out.println(fourthArray[2][2]); //displays zero
		
		System.out.println(secondArray.length); //2
		
		System.out.println(thirdArray.length); //3
		
		System.out.println(fourthArray.length); //3
		
		System.out.println(thirdArray[1].length); //displays 1: length of second row
		
		System.out.println( "Values in secondArray by row are\n" );
		buildOutput( secondArray );
		System.out.println( "\nValues in thirdArray by row are\n" );
		buildOutput( thirdArray );
		System.out.println( "\nValues in fourthArray by row are\n" );
		buildOutput( fourthArray );
		
		System.out.println("Sum of values in firstArray: " + getSum(firstArray));
		System.out.println("Average of values in thirdArray: " + getAverage(thirdArray));
        System.out.println("Smallest value in the first row of secondArray: " + getSmallestInFirstRow(secondArray));
        
        System.out.println("The values in the fourthArray by row before intialization are:\n");
        buildOutput( fourthArray );
        
        System.out.println("\nValues in initialized fourthArray are\n");
        initializeArray(fourthArray);
        buildOutput(fourthArray);
	}// -------- End main() -------
		
	/**
	* Displays the content of a 2D array row by row
	* @param array
	*/
	public static void buildOutput(int array[][]) {
	    // loop through array's rows
	    for (int row = 0; row < array.length; row++) {
	        System.out.print("| ");
	        // loop through columns of current row
	        for (int column = 0; column < array[row].length; column++) {
	            System.out.print(array[row][column] + " | ");
	        }
	        System.out.println();
	    }
	} // end method buildOutput
	
	/**
     * Description: This method will add all the values in an array and returns that value as sum
     * @param array
     * @return sum of all values
     */
    public static int getSum(int array[][]) {
    	
    	// initializes the variable the variable that will contain the sum of the entire array.
        int sum = 0;
        
        //loops through each value in the row of the array and the adds it to the variable sum
        for (int[] row : array) {
            for (int value : row) {
                sum += value;
            }
        }
        
        // returns the value of adding up all elements in a given array
        return sum;
    }
    
    /**
     * Description: This method will return the average of all the values in an array
     * @param: array
     * @return: average of all values
     */
    public static double getAverage(int array[][]) {
    	 double average;
    	// this uses the sum method to get the value of all elements in a given 2D array added together
        // passes the array passed into this method into the getSum method
    	int sum = getSum(array);
        
        // initializes a variable that will contain the number of elements in the 2d Array
        int count = 0;
        
        // goes through each row of the 2D array and gets the number of elements in that row and adds it to
        for (int[] row : array) {
            count += row.length;
        }
        
        // takes the sum of the 2D array and divides it by the number of elements in the 2D array to get the average
        average = sum / count;
        
        return average;
    }
    
    /**
     * Description: This method will return the smallest value in the first row of a 2D array.
     * @param: array
     * @return: smallest value in the first row
     */
    public static int getSmallestInFirstRow(int array[][]) {
    	
    	// we will initialize a variable here that is equal to value in the first element of the first row
        int smallest = array[0][0];
        
        //loops over each value in the first row of the array 
        for (int value : array[0]) {
        	
        	//check to see if the value of the array that the loop is own is less than the value we initialized smallest to
        	// if it is the smallest variable is updated
            if (value < smallest) {
                smallest = value;
            }
        }
        
        //returns the smallest value in the first row of the array. 
        return smallest;
    }
    
    /**
     * Description: This method will initialize the array to number 5 when the row value equals the columns value, otherwise it initializes it to zero
     * @param: array
     * @return: No return 
     */
    public static void initializeArray(int array[][]) {
    	//loop iterates over each row of the 2D array
    	// It will initialize the row index to 0.
    	// The Loop continues as long as row is less than the number of rows in the array.
        for (int row = 0; row < array.length; row++) {
        	
        	// This loop iterates over each column in the current row.
        	// This will also initialize the column index to 0
            for (int column = 0; column < array[row].length; column++) {
            	
            	// Checks if the current element is on the diagonal meaning the row index equal to the column index
            	// If the row is equal to the column sets that value to 5
                if (row == column) {
                    array[row][column] = 5;
                } 
                
                // If not then sets the value to 0
                else {
                    array[row][column] = 0;
                }
            }
        }
    }
}
