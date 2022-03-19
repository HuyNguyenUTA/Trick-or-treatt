//Huy Nguyen
//1001744707
package Code4_1001744707;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Code4_1001744707 
{
    enum ACTION
    {
        DISPENSECHANGE, INSUFFICIENTCHANGE, INSUFFICIENTFUNDS, EXACTPAYMENT, NOINVENTORY
    }
    static String displayMoney(int moneyValue)
    {
        String dollar = "";
        String cent = "";
        dollar = String.valueOf( moneyValue / 100 );
        cent = String.valueOf( moneyValue % 100 );
        String result = "$" + dollar + "." + (cent.length() == 1 ? "0" : "") + cent;
        return result;
    }
    static int CokeMenu()
    {
        Scanner input = new Scanner(System.in);
        int userChoice = 5;
        System.out.println("0. Walk away");
        System.out.println("1. Buy a Coke");
        System.out.println("2. Restock Machine");
        System.out.println("3. Add change");
        System.out.println("4. Display Machine Info");
        System.out.println("5. Update Machine Name");
        System.out.println("6. Update Coke price");
        System.out.printf("Choice: ");
        try
        {
            userChoice = input.nextInt();
        }
        catch(Exception e)
        {
            String userchoice = input.next();
        }
        return userChoice;
    }
    static void ReadFile(String fileName, ArrayList<CokeMachine> SetOfCokeMachines) 
    {
        File file = new File(fileName);
        Scanner sc = null;
        String[] fileLine= new String[100];
       
        //Scanner scan = new Scanner(file);
        try
        {
            sc = new Scanner(file);
        }
        catch(Exception e)
        {
            System.out.printf("%s file name does not exist...exiting", fileName);
            System.exit(0);
        }
        while(sc.hasNextLine())
        {
            fileLine = sc.nextLine().split("[|]");
            SetOfCokeMachines.add(new CokeMachine(fileLine[0],Integer.parseInt(fileLine[1]), Integer.parseInt(fileLine[2]), Integer.parseInt(fileLine[3])));
        }
        sc.close();
    }
    static void WriteFile(String fileName, ArrayList<CokeMachine> SetOfCokeMachines) throws FileNotFoundException
    {
        PrintWriter out = null;
        try
        {
            out = new PrintWriter(fileName);
        }
        catch(Exception e)
        {
            System.out.println("Unable to write output file");
            System.exit(0);
        }
        for(CokeMachine iter : SetOfCokeMachines)
        {
            out.printf("%s|%d|%d|%d\n",iter.getMachineName(), iter.getCokePrice(), iter.getChangeLevel(), iter.getInventoryLevel());
        }
        out.close();
    }
    static int MachineMenu(ArrayList<CokeMachine> SetOfCokeMachines)
    {
        Scanner input = new Scanner(System.in);
        int machineChoice = 5;
        for(int i=0; i<SetOfCokeMachines.size(); i++)
        {
            if(i==0)
            {
                System.out.printf("%d. Exit\n",i);
            }
            System.out.printf("%d. ",++i);
            System.out.printf(SetOfCokeMachines.get(--i).getMachineName() + "\n");
            if(i==SetOfCokeMachines.size()-1)
            {
                System.out.printf("%d. Add new machine\n",i+=2);
                machineChoice = i;
                break;
            }
        }
        System.out.print("Choice: ");
        try
        {
            machineChoice = input.nextInt();
        }
        catch(Exception e)
        {
            String userchoice = input.next();
        }
        return machineChoice;
    }
    
    public static void main(String[] args)  throws FileNotFoundException
    {
        Scanner input = new Scanner(System.in);
        int userChoice=3; 
        int restockQuantity = 0;
        int payment = 0;
        int changeAdd = 0;
        char equalSign = '=';
        String newMachineName;
        int newCokePrice = 0;
        String inputFileName = "";
        String outputFileName = "";
        int machineChoice = 1;
        String newCokeMachine ="";
        CokeMachine MyCokeMachine = new CokeMachine("New Machine", 50, 500, 100);//Machine name, Coke cost, Change lavel, Inventory level
        ArrayList<CokeMachine> SetOfCokeMachines = new ArrayList<>();
        if(args.length != 2)
        {
            System.out.println("Missing command line parameters – - Usage : INPUTFILENAME= OUTPUTFILENAME=");
            System.exit(0);
        }
        else
        {
            inputFileName = args[0].substring(args[0].indexOf(equalSign)+1);
            outputFileName = args[1].substring(args[1].indexOf(equalSign)+1);
            System.out.println(args[0].substring(args[0].indexOf(equalSign)+1));
            System.out.println(args[1].substring(args[1].indexOf(equalSign)+1));
        }
        ReadFile(inputFileName, SetOfCokeMachines);
        machineChoice = MachineMenu(SetOfCokeMachines);
        while(machineChoice != 0)
        {
            if(machineChoice == SetOfCokeMachines.size()+1)
            {
                SetOfCokeMachines.add(new CokeMachine("New Coke Machine", 50, 500, 100));
            }
            else
            {
                MyCokeMachine = SetOfCokeMachines.get(machineChoice-1);
                do
                {
                    System.out.println(MyCokeMachine.getMachineName()+"\n");
                    userChoice = CokeMenu();
                    switch(userChoice)
                    {
                        case 0:
                            if(MyCokeMachine.getNumberOfCokesSold()>0)
                            {
                                System.out.println("Bye - enjoy your Coke");
                            }
                            else
                            {
                                System.out.println("Are you sure you aren't really THIRSTY and need a Coke?");
                            }
                            break;
                        case 1:
                            if(MyCokeMachine.getInventoryLevel() == 0)
                            {
                                System.out.println("This Coke Machine is out of inventory\n");
                                break;
                            }
                            System.out.printf("A coke costs %s\n", displayMoney(MyCokeMachine.getCokePrice()));
                            System.out.print("Insert payment ");
                            payment = input.nextInt(); 
                            switch(MyCokeMachine.buyACoke(payment))
                            {
                                case DISPENSECHANGE:
                                    System.out.printf("Here is your Coke and your change of %s\n\n", displayMoney(MyCokeMachine.getChangeDispensed()));
                                    break;
                                case INSUFFICIENTCHANGE:
                                    System.out.println("This Coke Machine does not have enough change and cannot accept your payment\n");
                                    break;
                                case INSUFFICIENTFUNDS:
                                    System.out.println("Insufficent payment...returning your payment.\n\n");
                                    break;
                                case EXACTPAYMENT:
                                    System.out.printf("Thank you for exact payment\nHere's your Coke\n\n");   
                                    break;   
                                case NOINVENTORY:
                                    System.out.println("Unable to sell a Coke - call 1800WEDONTCARE to register a complain...returning your payment\n");
                            }
                            break;
                        case 2:
                            System.out.println("How much product are you adding to the machine ?");
                            restockQuantity = input.nextInt();
                            if(MyCokeMachine.incrementInventoryLevel(restockQuantity))
                            {
                                System.out.println("Your machine has been restocked");
                            }
                            else 
                            {
                                System.out.println("You have exceeded your machine's max capacity - no inventory was added");
                            }

                            System.out.println("Your inventory level is " + MyCokeMachine.getInventoryLevel());
                            break;
                        case 3:
                            System.out.println("How much change are you adding to the machine?");
                            changeAdd = input.nextInt();
                            if(MyCokeMachine.incrementChangeLevel(changeAdd))
                            {
                                System.out.println("Your change level has been updated");
                            }
                            else
                            {
                                System.out.println("You exceeded your machine's max change capacity - no change added");                      
                            }

                            System.out.println("Your change level is " + displayMoney(MyCokeMachine.getChangeLevel()) + " with a max capacity of " + displayMoney(MyCokeMachine.getMaxChangeCapacity()));
                            break;
                        case 4:
                            System.out.println(MyCokeMachine);
                            break;
                        case 5:
                            System.out.println("Enter a new machine name:");
                            newMachineName=input.nextLine();
                            MyCokeMachine.setMachineName(newMachineName);
                            System.out.println("Machine name has been updated\n");
                            break;
                        case 6:
                            System.out.println("Enter a new Coke price");
                            MyCokeMachine.setCokePrice(newCokePrice=input.nextInt());
                            System.out.println("Coke price has been updated\n");
                            break;
                        default:
                            System.out.println("Invalid menu choice. Please choose again");
                    }
                }while(userChoice != 0);
            }
            machineChoice = MachineMenu(SetOfCokeMachines);
        }
        WriteFile(outputFileName, SetOfCokeMachines);
        System.out.printf("%d Coke(s) were sold today!\n",CokeMachine.numberOfCokesSold);
    }
}