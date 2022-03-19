import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;
public class PracticeForOLQ5 
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner in = new Scanner(System.in);

        System.out.println("1. Encode file");
        System.out.println("2. Decode file");
        System.out.println("3. View file contents");
        System.out.println("4. Exit");
        System.out.println("\nEnter Choice");
        int Choice;
        do
        {
            try
            {
                Choice = in.nextInt();
            }
            catch(Exception e)
            {
                Choice = 0;
                in.next();
            }
            if(Choice < 1 || Choice > 4)
            {
                System.out.print("Invalid choice. Please reenter");
            }
        }
        while (Choice < 1 || Choice > 4);

        switch(Choice)
        {
            case 1:
                in.nextLine();
                System.out.println("Enter file name to be encoded");
                String ifilename = in.nextLine();
                File ifh = new File(ifilename);
                Scanner If = null;
                try
                {
                    If = new Scanner(ifh);
                }
                catch(Exception e)
                {
                    System.out.println("File not found...exiting");
                    System.exit(0);
                }
                System.out.println("Enter file to write to");
                String out = in.nextLine();
                PrintWriter OF = new PrintWriter(out);
                while(If.hasNextLine())
                {
                    String FileLine = If.nextLine();
                    for (int i = 0; i < FileLine.length(); i++)
                    {
                        OF.print((char)((int)FileLine.charAt(i)-13));
                    }
                    OF.println();
                }
                OF.close();
                break;
            case 2:
                in.nextLine();
                System.out.print("Enter file name to be decoded");
                String IFilename = in.nextLine();
                File iFH = new File(IFilename);
                Scanner Ifh =null;
                try
                {
                    Ifh = new Scanner(iFH);
                }
                catch(Exception e)
                {
                    System.out.println("FIle not found ... exiting");
                    System.exit(0);

                }
                System.out.println("Enter file to write to");
                String OUT = in.nextLine();
                PrintWriter OFF = new PrintWriter(OUT);
                while(Ifh.hasNextLine())
                {
                    String Fileline = Ifh.nextLine();
                    for (int i = 0; i < Fileline.length(); i++)
                    {
                        OFF.print((char)((int)Fileline.charAt(i)+13));
                    }
                    OFF.println();
                }
                OFF.close();
                break;
            case 3:
                in.nextLine();
                System.out.print("Enter file name");
                String IFIlename = in.nextLine();
                File IFH = new File(IFIlename);
                Scanner IF =null;
                try
                {
                    IF = new Scanner(IFH);
                }
                catch(Exception e)
                {
                    System.out.println("FIle not found ... exiting");
                    System.exit(0);

                }
                String fileline = "";
                while(IF.hasNextLine())
                {
                    fileline = IF.nextLine();
                    System.out.println(fileline);
                }
                break;
        }
    }
}
