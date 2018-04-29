// Lab 2 – Week 2
/* Lab2LoopsArrays2.java
 * Author: Derek Christensen
 * Date: 20180425
*/

/** Lab2LoopsArrays2.java
   PART 1:
   Store and analyze Exam Scores, including:
   - input
   - correctness of entries
   - AVG, MIN, MAX
   - output
   by using:
   - Arrays
   - Loops
   - number formatting
   - error checking & messaging
   
   PART 2:
   Expand PART 1 to include multiple class sections:
   - include use of a sentinel
   - inner and outer loops   
 */

import java.util.*;                 // required to use Scanner and Random classes
import java.util.Scanner;
import java.text.DecimalFormat;     //required to use DecimalFormat class

public class Lab2LoopsArrays2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner (System.in);
		
		int[] scores = new int[50];
		
		String input = "SECTION";
		char section = 'Z';
		char enterAnother = 'Y';

		int totalClass = 0;
		int lowClass = 100, highClass = 0;
		
		double averageSection;
		double averageClass;
		
		DecimalFormat df = new DecimalFormat("#,##0.00");
		
		System.out.println("How many scores to you need to enter for all Sections combined? ");		
		int number = Integer.parseInt(s.nextLine());
		scores = new int[number];
		
// Read in defined number of scores using the 'length'
// data property to control the loop
		
		int indexClass = 0;
		do          // Iterate thru Sections
		{
			System.out.println("\nEnter Section Letter (A, B, C, etc.): ");
//			s.nextLine();
//			s.nextLine();
			input = (s.nextLine()).toUpperCase();
			section = input.charAt(0);
			
			int indexSection = 0, totalSection = 0;
			int lowSection = 100, highSection = 0;
			int temp = -1;
			
			System.out.println("Enter up to " + 
                    (scores.length - indexClass) + 
                    " scores or 999 to end:");
			
			do          // Iterate thru Section Scores
			{
				temp = s.nextInt();
				
				if (temp != 999) {
					
					while (temp < 0 || temp > 100) {
						System.out.println("Score must be a number from 0 to 100.");
						temp = s.nextInt();
					} // end while
					
					scores[indexClass] = temp;
					totalSection += temp;
					totalClass += temp;
					
					if (temp < lowSection)
						lowSection = temp;
					if (temp > highSection)
						highSection = temp;
					if (temp < lowClass)
						lowClass = temp;
					if (temp > highClass)
						highClass = temp;
					
					indexSection++;
					indexClass++;
					
				} // end if

			} while (indexClass < scores.length && temp != 999); //end while
			
			averageSection = (double)totalSection/indexSection;
			
			System.out.println("\nSection " + section + " results: ");
			System.out.println("Sum of scores: " + totalSection);
			System.out.println("Numer of scores: " + indexSection);
			System.out.println("High score: " + highSection);
			System.out.println("Low Score: " + lowSection);
			System.out.print("Average score: " + df.format(averageSection) + "\n");
			
			System.out.print("\nDo you want to enter another section? (Y)es or (N)o: ");
			s.nextLine();
			String response = (s.nextLine()).toUpperCase();
			enterAnother = response.charAt(0);
			
		} while (indexClass < scores.length && enterAnother == 'Y'); //end while
		
		for (int score : scores) {
			System.out.print(score + " ");
		} // end for
		
		averageClass = (double)totalClass/scores.length;
		
		System.out.println("\n\nClass results: ");
		System.out.println("Sum of scores: " + totalClass);
		System.out.println("Numer of scores via index: " + indexClass);
		System.out.println("Numer of scores via array length: " + scores.length);
		System.out.println("Class High = " + highClass);
		System.out.println("Class Low = " + lowClass);
		System.out.println("Class Average = " + df.format(averageClass));
		
	} // end main
} // end class
