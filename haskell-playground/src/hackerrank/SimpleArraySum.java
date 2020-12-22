package hackerrank;

import java.util.Arrays;

import collections.StreamReduce;

/**
 * 
 * Given an array of integers, find the sum of its elements.

For example, if the array ar = [1,2.3], 1 + 2 + 3 = 6, so return 6.

Function Description

Complete the simpleArraySum function in the editor below. It must return the sum of the array elements as an integer.

simpleArraySum has the following parameter(s):

    ar: an array of integers

Input Format

The first line contains an integer, n, denoting the size of the array.
The second line contains n space-separated integers representing the array's elements.

Constraints
0 < n, ar[i] <= 1000

Output Format

Print the sum of the array's elements as a single integer.

Sample Input

6
1 2 3 4 10 11

Sample Output

31

Explanation

We print the sum of the array's elements:
.
 *
 */
public class SimpleArraySum {

	public static void main(String[] args) {
		int[] inputArray = new int[] { 1, 5, 2, 1, 4, 0 };
		System.out.println("result for input " + Arrays.toString(new int[] { 1, 5, 2, 1, 4, 0 }) + " is " + simpleArraySum(inputArray));
		// 13
		
		// Using streams
		System.out.println("using stream API : " + StreamReduce.getSumOfAllElementsOfArray(inputArray));
	}
	
	public static int simpleArraySum(int[] ar) {
        int result = 0;
        
        if (ar.length > 0)
        {
        	for (int i : ar)
        	{
        		result = result + i;
        	}
        }
        
        return result;

    }

}
