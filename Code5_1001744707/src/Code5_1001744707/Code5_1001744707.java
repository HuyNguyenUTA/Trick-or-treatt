//Huy Nguyen
//1001744707
package code5_1001744707;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Code5_1001744707 
{
    public static void  CreateCandyList(String fileName, HashMap<String, Integer>CandyList) 
    {  
        File file = new File(fileName);
        Scanner sc = null;
        String[] fileLine = new String[100];
        
        try
        {
            sc = new Scanner(file);
        }
        catch(Exception e)
        {
            System.out.printf("%s file does not exist...exiting\n", fileName);
            System.exit(0);
        }
        while(sc.hasNextLine())
        {
            fileLine = sc.nextLine().split("[|]");
            CandyList.put(fileLine[0],Integer.parseInt(fileLine[1]));
        }
        sc.close();
    } 
    
    public static String CreateHouses( String fileName, ArrayList<House>house, HashMap<String, Integer>CandyList) 
    { 
        String HouseHeading ="           ";
        File file = new File(fileName);
        Scanner sc = null;
        String fileLine = "";
        Random rand = new Random();
        try
        {
            sc = new Scanner(file);
        }
        catch(Exception e)
        {
            System.out.printf("%s file does not exist...exiting\n", fileName);
            System.exit(0);
        }
        while(sc.hasNextLine()) 
        {
            fileLine = sc.nextLine();
            HouseHeading = HouseHeading + fileLine;//concatenate HouseHeading with line from file  
            for (int i = 0; i < 11-fileLine.length(); i++) 
            {  
                HouseHeading += " "; 
            } 
            if(rand.nextInt(2)==0)//if a random number between 0 and 2 is 0  
            {
                house.add(new CandyHouse(fileLine, CandyList));//then add a CandyHouse to the ArrayList of Houses 
            }
            else
            {
                house.add(new ToothbrushHouse(fileLine, CandyList));//else add a ToothbrushHouse to the ArrayList of Houses
            }
        }
        sc.close();
        HouseHeading = HouseHeading + "\n\n";
    return HouseHeading;
    }
    
    public static void CreateTOTs( String fileName,  ArrayList<TrickOrTreater> trickortreater,  ArrayList<House> house) 
    { 
        /* Set up File and Scanner */ 
        File file = new File(fileName);
        Scanner sc = null;
        String fileLine = "";
        /* Open file and catch exception if needed.  Exit if file does not open */ 
        try
        {
            sc = new Scanner(file);
        }
        catch(Exception e)
        {
            System.out.printf("%s file does not exist...exiting\n", fileName);
            System.exit(0);
        }
        /* while reading the file */ 
        /*    get next line */ 
        /*    add TrickOrTreater to ArrayList */ 
        while(sc.hasNextLine())
        {
            fileLine = sc.nextLine();
            trickortreater.add(new TrickOrTreater(fileLine, house));
        }
        /* close file */    
        sc.close();
    } 
    public static void main(String[] args) 
    {
        HashMap<String, Integer>CandyList = new HashMap<String, Integer>();
        ArrayList<House> house = new ArrayList<>();
        ArrayList<TrickOrTreater> trickortreater = new ArrayList<>();
        String arg1 = "";
        String arg2 = "";
        String arg3 = "";
        String equalSign = "=";
        String houseList = "";
        String ScreenOutput = "";
        if(args.length != 3)
        {
            System.out.println("Command line parameters errors");
            System.exit(0);
        }
        else
        {
            arg1 = args[0].substring(args[0].indexOf(equalSign)+1);
            arg2 = args[1].substring(args[1].indexOf(equalSign)+1);
            arg3 = args[2].substring(args[2].indexOf(equalSign)+1);
            System.out.println(args[0].substring(args[0].indexOf(equalSign)+1));
            System.out.println(args[1].substring(args[1].indexOf(equalSign)+1));
            System.out.println(args[2].substring(args[2].indexOf(equalSign)+1));
        }
        CreateCandyList(arg1,CandyList);
        houseList = CreateHouses(arg2,house, CandyList);
        CreateTOTs(arg3, trickortreater, house);
        System.out.print(CandyList);
        ExecutorService executorService = Executors.newCachedThreadPool(); 
        for(TrickOrTreater it : trickortreater)//enhanced for loop over TrickOrTreater ArrayList 
        { 
            executorService.execute(it);  // where it is iterator over the ArrayList 
        } 
        TextAreaFrame TAF = new TextAreaFrame(); 
        TAF.setVisible(true); 
        while (TrickOrTreater.ImDone != trickortreater.size())//TrickOrTreater’s ImDone static variable is not equal to the size of TrickOrTreater ArrayList
        { 
            ScreenOutput = String.format("%s", houseList); 
            for(TrickOrTreater it : trickortreater)//enhanced for loop over TrickOrTreater ArrayList 
            { 
                ScreenOutput += String.format("%s%s\n", it.getPath(), it.getName()); 
            } 
            TAF.textArea.setText(ScreenOutput); 
        }
        executorService.shutdown(); 
        /*Create a string called BucketContents and put “Candy!!” and two newlines in it. 
        enhanced for loop over TrickOrTreater ArrayList 
         concatenate BucketContents and the return value of printBucket() 
        TAF.textArea.setText(BucketContents);*/
        String BucketContents ="Candy!\n\n";
        for(TrickOrTreater it : trickortreater)
        {
            BucketContents += it.printBucket();
        }
        TAF.textArea.setText(BucketContents);
    }
}
