//Week 4 
//13,15,17 September Lecture
import java.util.Arrays;//sorting array
import java.util.Scanner;//use scanner
public class OLQ4
{
    public static void main(String[] args)
    {
        //declare scanner in
        Scanner in = new Scanner(System.in);

        String olq4 = "hello world";

        //in.next picks up characters before whitespace
        //in.nextLine reads through whitespace and stops at the newline
        //toUpperCase() and toLowerCase()
        System.out.println(olq4.toUpperCase());
        olq4 = olq4.toLowerCase();
        System.out.println(olq4);
        
        //using sub string
        //Formula: String.substring(start,excluded end)
        //if only one parameter: String.substring(start) -> from start to end of string
        System.out.println(olq4.substring(2,5));

        System.out.println(olq4.charAt(0)); //using character at index method using charAt()
        
        //Finding a character in a string
        //Method: lastIndexOf(ch) //returns index of "ch"
        //Method: lastIndexOf(ch, fromIndex) //returns index of the last occurrence of ch working backwards from fromIndex in the string
        //ALl returns -1 if not matched


        //Method: Integer.parseInt()
        //Same for double Double.parseDouble()
        //Convert a string that only contains numbers into a number
        String intString = "123";
        int intValue = Integer.parseInt(intString);

        //Prompt for a phrase
        System.out.print("Enter a phrase ");
        String phrase = in.nextLine();

        //prompt for a delimeter
        System.out.print("Enter the delimiter");
        String delimiter = in.nextLine();

        //store the tokens of a string using "split" method inside of a string array
        String [] tokens = phrase.split(delimiter); //String [] tokens = String.split("[delimetersymbol]");

        //print out the tokens of a string array after splitting
        for(int i = 0; i < tokens.length; i++)
        {
            System.out.println(tokens[i]);
        }

        //read a single character from the input and upper case it
        System.out.print("Enter a string and read a character at charAt()");
        char single_character = in.next().toUpperCase().charAt(0);
        System.out.println(single_character);

        //MAX and MIN values of integer and double
        //Integer.MAX_VALUE
        //Integer.MIN_VALUE
        //Double.MAX_VALUE
        //Double.MIN_VALUE

        //array
        //String string = new String[5];
        int array[] = {5,4,3,2,1};
        int my2D [][] = {{0,1,2,3},
                        {4,5,6,7},
                        {8,9,10,11}};
        //import java.util.Arrays; to sort array
        Arrays.sort(array);

        //print out the array values after sorting
        for(int i = 0; i < array.length; i++) //method length of an array
        {
            System.out.println(array[i]);
        }

        //Partially filled Arrays -> Week 4 slides (page 110)

        //String Compare returns true or false
        //Formula String1.equals(String2)
        //don't use == (it tests whether the two strings are stored in the same memory location)
        //if case doesn't matter, then use equalsIgnoreCase();
        String string1 = "hello world";
        String string2 = "hello world";
        if(string1.equals(string2))
        {
            System.out.printf("String %s and %s are equals\n", string1, string2);
        }

        //to compare the ASCII value of strings
        //use formula: String1.compareTo(String2)
        // use this formula to ignore case: String1.compareToIgnoreCase(String2)
        //if String 1 < String 2 -> compareTo() < 0
        //if String 1 > String 2 -> compareTo() > 0
        //if String 1 = String 2 -> compareTo() = 0
        System.out.print("Enter your first word");
        String word1 = in.next();
        System.out.print("Enter your second word");
        String word2 = in.next();
        if(word1.compareTo(word2) < 0)
        {
            System.out.printf("%s < %s\n", word1, word2);
        }
        if(word1.compareTo(word2) > 0)
        {
            System.out.printf("%s > %s\n", word1, word2);
        }
        if(word1.compareTo(word2) == 0)
        {
            System.out.printf("%s = %s\n", word1, word2);
        }

        
    }
}