//Huy Nguyen
//1001744707
package Code3_1001744707;

import java.util.Scanner;

public class Code3_1001744707 
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
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        int userChoice; 
        int restockQuantity = 0;
        int payment = 0;
        int changeAdd = 0;
        CokeMachine MyCokeMachine = new CokeMachine("CSE 1325 Coke Machine", 50, 500, 100);//Machine name, Coke cost, Change lavel, Inventory level
        
        do
        {
            System.out.println(MyCokeMachine.getMachineName());
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
                            System.out.printf("Here is your Coke and your change of %s\n", displayMoney(MyCokeMachine.getChangeDispensed()));
                            break;
                        case INSUFFICIENTCHANGE:
                            System.out.println("This Coke Machine does not have enough change and cannot accept your payment\n");
                            break;
                        case INSUFFICIENTFUNDS:
                            System.out.println("Insufficent payment...returning your payment.\n");
                            break;
                        case EXACTPAYMENT:
                            System.out.printf("Thank you for exact payment\nHere's your Coke\n");   
                            break;   
                        case NOINVENTORY:
                            System.out.println("Unable to sell a Coke - call 1800WEDONTCARE to register a complain...returning your payment");
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
                default:
                    System.out.println("Invalid menu choice. Please choose again");
            }
        }
        while(userChoice != 0);
    }
}
