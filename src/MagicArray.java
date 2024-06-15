public class MagicArray {
    
    public static void main(String[] args) {
        // Initialize the array and magic number
        int[] exampleArray = {1, 2, 3, 4, 2, 5, 2};
        int magicNumber = 2;
        
        // Display the array before replacement
        System.out.println("Array before replacement:");
        printArray(exampleArray);
        
        // Call the magicReplace method
        int[] modifiedArray = magicReplace(exampleArray, magicNumber);
        
        // Display the array after replacement
        System.out.println("Array after replacement:");
        printArray(modifiedArray);
    }
    
    public static int[] magicReplace(int[] theArray, int magicNumber) {
        // Create a new array to store the result
        int[] resultArray = new int[theArray.length];
        
        // Copy the elements, replacing magicNumber with 0
        for (int i = 0; i < theArray.length; i++) {
            if (theArray[i] == magicNumber) {
                resultArray[i] = 0;
            } else {
                resultArray[i] = theArray[i];
            }
        }
        
        return resultArray;
    }
    
    // Helper method to print the array elements
    public static void printArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}