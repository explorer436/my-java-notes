package strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 * 
 * Reverse the characters in a String
 *
 */
public class StringReversal {

	public static void main(String[] args) {
		
		// Note : Apache Commons has a helper method for this as well. StringUtils.reverse()
		
		System.out.println("reverseStringUsingByteArray - input is Testing");reverseStringUsingByteArray("Testing");
		System.out.println("reverseStringUsingByteArray - input is \"\"");reverseStringUsingByteArray("");
		System.out.println("reverseStringUsingByteArray - input is null");reverseStringUsingByteArray(null);
		
		System.out.println();
		
		System.out.println("reverseStringUsingStringBuilder - input is Testing");reverseStringUsingStringBuilder("Testing");
		System.out.println("reverseStringUsingStringBuilder - input is \"\"");reverseStringUsingStringBuilder("");
		System.out.println("reverseStringUsingStringBuilder - input is null");reverseStringUsingStringBuilder(null);
		
		System.out.println();
		
		System.out.println("reverseStringUsingCharArray1 - input is Testing");reverseStringUsingCharArray1("Testing");
		System.out.println("reverseStringUsingCharArray1 - input is \"\"");reverseStringUsingCharArray1("");
		System.out.println("reverseStringUsingCharArray1 - input is null");reverseStringUsingCharArray1(null);
		
		System.out.println();
		
		System.out.println("reverseStringUsingCharArray2 - input is Testing");reverseStringUsingCharArray2("Testing");
		System.out.println("reverseStringUsingCharArray2 - input is \"\"");reverseStringUsingCharArray2("");
		System.out.println("reverseStringUsingCharArray2 - input is null");reverseStringUsingCharArray2(null);
		
		System.out.println();
		
		System.out.println("reverseStringUsingCollections - input is Testing");reverseStringUsingCollections("Testing");
		System.out.println("reverseStringUsingCollections - input is \"\"");reverseStringUsingCollections("");
		System.out.println("reverseStringUsingCollections - input is null");reverseStringUsingCollections(null);
		
		System.out.println();
		
		System.out.println("reverseStringUsingForLoop - input is Testing");reverseStringUsingForLoop("Testing");
		System.out.println("reverseStringUsingForLoop - input is \"\"");reverseStringUsingForLoop("");
		System.out.println("reverseStringUsingForLoop - input is null");reverseStringUsingForLoop(null);

	}
	
	/**
	 * Using a for loop
	 */
	public static void reverseStringUsingForLoop(String input) 
    {
		String output = null;
		if (input != null) {
			output = "";
		    for (int i = input.length() - 1; i >= 0; i--) {
		        output = output + input.charAt(i);
		    }
		    System.out.println(output);
	    }
    }
	
	/**
	 * Using String.getBytes()
	 */
	public static void reverseStringUsingByteArray(String input) 
    { 
		if (input != null)
		{
			byte [] strAsByteArray = input.getBytes(); 
			  
	        byte [] result = new byte [strAsByteArray.length]; 
	  
	        // Store result in reverse order into result byte[] 
	        for (int i = 0; i<strAsByteArray.length; i++) 
	            result[i] =  
	             strAsByteArray[strAsByteArray.length-i-1]; 
	  
	        System.out.println(new String(result));
		}
    }
	
	/**
	 * Using StringBuilder.reverse()
	 */
	public static void reverseStringUsingStringBuilder(String input) 
    {   
		if (input != null)
		{
			StringBuilder output = new StringBuilder(input).reverse(); 
			  
	        System.out.println(output.toString());
		}
    }
	
	/**
	 * Using String.toCharArray()
	 */
	public static void reverseStringUsingCharArray1(String input) 
    {
		if (input != null)
		{
			char[] try1 = input.toCharArray(); 
			  
	        for (int i = try1.length-1; i>=0; i--) 
	        {
	        	System.out.print(try1[i]);
	        }
		}
    }
	
	/**
	 * Using String.toCharArray()
	 */
	public static void reverseStringUsingCharArray2(String input) 
    {
		if (input != null)
		{
			char[] temparray = input.toCharArray(); 
	        int left, right=0; 
	        right = temparray.length-1; 
	  
	        for (left=0; left < right ; left++ ,right--) 
	        { 
	            // Swap values of left and right 
	            char temp = temparray[left]; 
	            temparray[left] = temparray[right]; 
	            temparray[right]=temp; 
	        } 
	  
	        for (char c : temparray) 
	        {
	        	System.out.print(c); 
	        }
		}
    }
	
	/**
	 * Using Collections.reverse()
	 */
	public static void reverseStringUsingCollections(String input) 
    {
		if (input != null)
		{
			char[] hello = input.toCharArray(); 
	        List<Character> trial1 = new ArrayList<>(); 
	  
	        for (char c: hello) 
	        {
	        	trial1.add(c); 
	        }
	  
	        Collections.reverse(trial1); 
	        ListIterator li = trial1.listIterator(); 
	        while (li.hasNext()) 
	        {
	        	System.out.print(li.next());
	        }
		}
    }

}
