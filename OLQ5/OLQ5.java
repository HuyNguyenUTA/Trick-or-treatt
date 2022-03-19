//Week 5
//20,22,24 September Lecture
import java.util.ArrayList;//ArrayList Package
import java.util.Arrays;//to Sort an Array
import java.util.Collections;//to Sort an Array List
import java.util.Scanner;//Scanner
import java.io.File;//File Handling to read file
import java.io.FileNotFoundException;//File Handling to read file
import java.io.PrintWriter;
public class OLQ5
{
    public static void main(String[] args) throws FileNotFoundException 
    {
        //1.Declare an Arraylists
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> alphabet = new ArrayList<>();
        ArrayList<Integer> IList = new ArrayList<>();
        ArrayList<Character> CList = new ArrayList<>();
        ArrayList<Double> DList = new ArrayList<>();
        //2.Add element to array list
        names.add("Happy");
        names.add("Dopey");
        names.add("Grumpy");
        IList.add(1);
        IList.add(2);
        IList.add(3);
        CList.add('A');
        CList.add('B');
        DList.add(1.2);
        System.out.println(names);
        System.out.println(IList);
        System.out.println(CList);
        System.out.println(DList);

        //3. Get element in ArrayList
        System.out.printf("3. %s\n", names.get(0));
        //String getNames = names.get(1);

        //4. ArrayList method size() returns the number of elements in the ArrayList
        System.out.printf("4. ArrayList size is %d\n", names.size());

        //5. printing array list using for loop
        System.out.print("Printing array list using for loop :\n");
        for (int i = 0; i < names.size(); i++)
        {
            System.out.printf("%s\n",names.get(i));
        }

        //6. Using for loop to add elements to Array List
        for(int i =0; i < 26; i++)
        {
            String myLetter = String.valueOf((char)(i+65));
            alphabet.add(i, myLetter);
        }
        System.out.printf("6. Printing alphabet elements:%s\n",alphabet);

        //Set an array list element to a new value using "set" method
        //names.set(2, "Doc");

        //7. Insert an element in the middle of an array list
        names.add(1, "Sleepy");
        System.out.printf("7. After inserting %s\n",names);

        //8. Remove an element from the list
        names.remove(1);
        System.out.printf("8. After removing:%s\n",names);

        //Sort an array (import java.util.Arrays)
        //Arrays.sort(array_name);

        //Sort an array list (import java.util.Collections)
        //Method: Collections.sort(ArrayList_Name);

        //Sort an array list in reverse order
        //Method: Collections.sort(ArrayListName, Collections.reverseOrder);

        //Converting ArrayList to String using concatenation
        String HelloListString = IList + "";
        System.out.println(HelloListString);

        /*Convert an array to a string
        int Hello[] = {1,2,3,4,5};
        String Bye = Arrays.toString(Hello);*/

        /*Convert char to string using concatenation
        char Letter= 'A'
        String Word = Letter + "";*/

        //9. Array Copy
        //Method: NewArray = Arrays.copyOf(OldArray, length of NewArray);
        /*Alternative Method: int [] Hello = {1,2,3,4,5}
                              int [] Hola = Hello;*/
        int Hello[] = {1,2,3,4,5};
        int Hola[] = Arrays.copyOf(Hello, Hello.length*4);
        System.out.printf("9. Array copy: %s",Arrays.toString(Hola));

        //10. ArrayList copy
        //Method: NewArrayList = new ArrayList<>(OldArrayList);
        ArrayList<Integer> NewArrayList = new ArrayList<>(IList);
        System.out.println("\n10. ArrayListCopy: " + NewArrayList + "");

        //11. Convert an int to a String
        int Number = 1;
        String StringNumber1 = String.valueOf(Number);
        String StringNumber2 = Integer.toString(Number);
        String StringNumber3 = "" + Number;

        System.out.print(Number);
        System.out.print(StringNumber1);
        System.out.print(StringNumber2);
        System.out.println(StringNumber3);

        //12. Try and Catch Error
        Scanner in = new Scanner(System.in);
        System.out.print("Enter something ");
        int choice = 0;

        try
        {
            choice = in.nextInt();
            System.out.printf("12. You entered %d\n", choice);
        }
        catch(Exception e)
        {
            System.out.printf("12. You entered %s\n", in.nextLine());
            //choice = -1;
            //in.nextLine();
        }

        //More example of Try and Catch Error
        int Seal[] = {1,2,3,4,5};

        for(int i =0; i<=Seal.length; i++)
        {
            try
            {
                System.out.print(Seal[i]);
            }
            catch(Exception Team)
            {
                System.out.printf("\n%d is a bad index\n", i);
            }
        }

        //File Handling

        //To Read File
        //import java.io.File; and java.io.FileNotFoundException;
        //Add exception handling to main statement
        System.out.print("Enter a file namne");//Ask for file name
        String FileName = in.next();//Store file name in a string

        File fileIn = new File(FileName);//Create a file handle: Exp: File fileIN = new File("input.txt");

        if(fileIn.exists())
        {
            System.out.println("Your file exist");
        }
        else
        {
            System.out.println("Your file does not exist");
        }
        Scanner inFileRead = new Scanner(fileIn);//Scanner

        if(inFileRead.hasNextDouble())
        {
            System.out.println("read a line");
        }
        String FileLine = "";//make a string

        while (inFileRead.hasNextLine())//while the file still has something to read from
        {
            FileLine = inFileRead.nextLine();//read from file
            System.out.println(FileLine);
        }
        inFileRead.close();//close file

        //To Write File
        //import java.io.PrintWriter;
        //add exception handling to main statement: throws FileNotFoundException
        Scanner inn = new Scanner(System.in);//Scanner
        System.out.print("Enter file name ");//Ask for file name
        String fileName = inn.nextLine();//Store file name in a string

        PrintWriter out = new PrintWriter(fileName);//open the file for writing

        Scanner write = new Scanner(System.in);
        System.out.print("Enter something to write to the file");
        String fileLine = write.nextLine();

        out.println(fileLine);
        out.close();

        //System.exit(0);

        /*Read from a file to initialize a 2D array*/
        //Step 1: Ask for the file name
        Scanner twoDArray = new Scanner(System.in);
        System.out.println("Ente a file name");
        String Filename = twoDArray.nextLine();

        //Step 2: Open the file
        File FH = new File(Filename);
        if(FH.exists())
        {
            System.out.println("Your file exist");
        }
        else
        {
            System.out.println("Your file does not exist");
        }
        Scanner inFile = new Scanner(FH);

        //Step 3: Read the file
        String fileline = inFile.nextLine();

        //Make a 2D Array
        char My2D[][] = new char[5][5];

        //Read from a file
        int counter =0;
        for (int i =0; i < My2D.length; i++)
        {
            for(int j = 0; j < My2D[0].length; j++)
            {
                My2D[i][j] = fileline.charAt(counter++);
                System.out.printf("%c", My2D[i][j]);
            }
            System.out.printf("\n");
        }
    }
}