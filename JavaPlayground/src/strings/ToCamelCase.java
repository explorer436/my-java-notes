package strings;

/**
 * 
 * Complete the method/function so that it converts 
 * dash/underscore delimited words into camel casing. 
 * The first word within the output should be capitalized only if the original word was capitalized 
 * (known as Upper Camel Case, also often referred to as Pascal case).
Examples

toCamelCase("the-stealth-warrior"); // returns "theStealthWarrior"

toCamelCase("The_Stealth_Warrior"); // returns "TheStealthWarrior"
 *
 */
public class ToCamelCase {

	public static void main(String[] args) {
		System.out.println(toCamelCase("the-stealth-warrior"));
		
		System.out.println();
		
		System.out.println(toCamelCase("The_Stealth_Warrior"));
		
		System.out.println();
		
		System.out.println(toCamelCase("The-Stealth_Warrior"));
		
		System.out.println();
		
		System.out.println(toCamelCase("theStealthWarrior"));
		

	}
	
	// This approach needs just one pass through the entire string.
	// Convert the initial string into a StringBuffer and manipulate the StringBuffer.
	public static String toCamelCase(String s)
	{
		StringBuffer sb = new StringBuffer(s);
		for (int i = 0; i < sb.length(); i++) 
		{
			if ((sb.charAt(i)=='_') || (sb.charAt(i)=='-'))
			{   
				sb.setCharAt(i+1, Character.toUpperCase((sb.charAt(i+1))));
				sb.deleteCharAt(i);
			}
		}
		return sb.toString();
	}
	
	// Trying functional programming approach.
	// Apply a series of functions to get the final result.
	
	// This approach needs multiple passes through the entire string - so it will be slower compared to toCamelCase().
	public static String toCamelCase2(String s)
	{
	    return replaceByDelimiters(replaceByDelimiters(s, "_"), "-");
	}

	private static String replaceByDelimiters(String s, String stringToBeReplaced) {
		if (s.contains(stringToBeReplaced))
		{
			String[] values = s.split(stringToBeReplaced);
			
			StringBuffer sb = new StringBuffer();
			sb.append(values[0]);
			for (int i = 1; i < values.length; i++)
			{
				sb.append(values[i].substring(0, 1).toUpperCase() + values[i].substring(1));
			}
			
			return sb.toString();
		}
		else
		{
			return s;
		}
	}

}
