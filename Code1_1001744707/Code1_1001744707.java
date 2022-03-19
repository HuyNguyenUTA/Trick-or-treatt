//Huy Nguyen
//1001744707
import java.util.Scanner;
public class Code1_1001744707
{
    enum ACTION
    {
        DISPENSECHANGE, INSUFFICIENTCHANGE, INSUFFICIENTFUNDS, EXACTPAYMENT 
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
    static int PencilMenu()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Please choose from the following options\n");
        System.out.println("0. No pencils for me today");
        System.out.println("1. Purchase pencils");
        System.out.println("2. Check inventory level");
        System.out.println("3. Check change level\n");
        System.out.printf("Choice: ");
        int userChoice = input.nextInt();
        return userChoice;
    }
    static ACTION buyPencils(final int PENCIL_PRICE, int total, int payment,int pencil, int inventoryAndChange[], String changeReturnString[])
    {
        int changeReturnInt = 0;
        if(payment == pencil*PENCIL_PRICE)
        {
            inventoryAndChange[0] = inventoryAndChange[0]-pencil;
            inventoryAndChange[1] = inventoryAndChange[1] + (pencil*PENCIL_PRICE);
            return ACTION.EXACTPAYMENT;
        }
        else if( payment > pencil * PENCIL_PRICE )
        {
            changeReturnInt = payment - ( pencil * PENCIL_PRICE );
            if(changeReturnInt > inventoryAndChange[1])
            {
                return ACTION.INSUFFICIENTCHANGE;
            }
            else
            {
                inventoryAndChange[1] = inventoryAndChange[1] + ( pencil * PENCIL_PRICE );
                inventoryAndChange[0] = inventoryAndChange[0] - pencil;
                changeReturnString[0] = displayMoney(changeReturnInt);
                return ACTION.DISPENSECHANGE;
            }
        }
        else if( payment < pencil*PENCIL_PRICE )
        {
            return ACTION.INSUFFICIENTFUNDS;
        }
        return ACTION.EXACTPAYMENT;
    }
    public static void main(String[] args)
    {
        final int PENCIL_PRICE = 60;

        Scanner input = new Scanner(System.in);
        int userChoice;
        //int inventory[]= {100};
        //int change[] = {500};
        int inventoryAndChange[] = {100,500};
        String changeReturnString[] = {""};
        int pencil = 0;
        int payment = 0;
        int inventoryLevel = 0;
        int changeLevel = 0;
        int total = 0;
        String totalString = "";
        String pencilPriceString = "";
        String changeLevelString = "";

        pencilPriceString = displayMoney(PENCIL_PRICE);
        System.out.println("Welcome to my Pencil Machine\n");
        do
        {
            userChoice = PencilMenu();
            inventoryLevel = inventoryAndChange[0];

            changeLevel = inventoryAndChange[1];
            changeLevelString = displayMoney(changeLevel);

            switch(userChoice)
            {
                case 0:
                    break;
                case 1:
                    if(inventoryLevel == 0)
                    {
                        System.out.println("This Pencil Dispenser is out of inventory\n");
                        break;
                    }
                    System.out.printf("A pencil costs %s\n", pencilPriceString);
                    System.out.printf("How many pencils would you like to purchase? ");
                    pencil = input.nextInt();
                    while(pencil < 1 || pencil > inventoryLevel)
                    {
                        System.out.println("Cannot sell that quantity of pencils. Please reenter quantity");
                        pencil = input.nextInt();
                    }
                    total = PENCIL_PRICE*pencil;
                    totalString = displayMoney(total);
                    System.out.printf("Your total is %s\n", totalString);
                    System.out.printf("Enter your payment (in cents) ");
                    payment = input.nextInt();
                    switch(buyPencils(PENCIL_PRICE, total, payment, pencil, inventoryAndChange, changeReturnString))
                    {
                        case DISPENSECHANGE:
                            System.out.printf("Here is your pencils and your change of %s\n", changeReturnString[0]);
                            break;
                        case INSUFFICIENTCHANGE:
                            System.out.println("This Pencil Dispenser does not have enough change and cannot accept your payment");
                            break;
                        case INSUFFICIENTFUNDS:
                            System.out.println("You did not enter a sufficient payment. No pencils for you.");
                            break;
                        case EXACTPAYMENT:
                            System.out.println("Here's your pencils. Thank you for exact payment");                           
                            break;
                        default:
                            System.out.println("Something wrong happened!");
                    }
                    break;
                case 2:
                    System.out.printf("The current inventory level is %d\n", inventoryLevel);
                    break;
                case 3:
                    System.out.printf("The current change level is %s\n", changeLevelString);
                    break;
                default:
                    System.out.println("Invalid menu option\n");
            }
        }
        while(userChoice != 0);
    }
}
