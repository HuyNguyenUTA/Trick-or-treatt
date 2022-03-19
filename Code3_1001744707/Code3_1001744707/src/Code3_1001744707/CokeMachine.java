//Huy Nguyen
//1001744707
package Code3_1001744707;

public class CokeMachine 
{
    private String machineName;
    private int changeLevel;
    private int maxChangeCapacity = 5000;
    private int inventoryLevel;
    private int maxInventoryCapacity = 100;
    private int CokePrice;
    private int changeDispensed;
    private static int numberOfCokesSold = 0;
    
    public enum ACTION
    {
        DISPENSECHANGE, INSUFFICIENTCHANGE, INSUFFICIENTFUNDS, EXACTPAYMENT, NOINVENTORY
    }
    public CokeMachine(String name, int cost, int change, int inventory)//coke cost, change level, inventory level
    {
        machineName = name;
        CokePrice = cost;
        changeLevel = change;
        inventoryLevel = inventory;
    }
    
    public String getMachineName()
    {
        return machineName;
    }
    
    public int getChangeLevel()
    {
        return changeLevel;
    }
    
    public int getMaxChangeCapacity()
    {
        return maxChangeCapacity;
    }
    
    public int getInventoryLevel()
    {
        return inventoryLevel;
    }
    
    public int getMaxInventoryLevel()
    {
        return maxInventoryCapacity;
    }
    
    public int getCokePrice()
    {
        return CokePrice;
    }
    
    public int getChangeDispensed()
    {
        return changeDispensed;
    }
    
    public int getNumberOfCokesSold()
    {
        return numberOfCokesSold;
    }
    
    public boolean incrementInventoryLevel(int amountToAdd)
    {
        if(amountToAdd + inventoryLevel <= maxInventoryCapacity)
        {
            inventoryLevel = inventoryLevel + amountToAdd;
            return true;
        }
        else if (amountToAdd + inventoryLevel > maxInventoryCapacity)
        {
            return false;
        }
        return false;
    }
    
    public boolean incrementChangeLevel(int amountToAdd)
    {
        if(amountToAdd + changeLevel <= maxChangeCapacity)
        {
            changeLevel = changeLevel + amountToAdd;
            return true;
        }
        else if(amountToAdd + changeLevel > maxChangeCapacity)
        {
            return false;
        }
        return false;
    }
    
    public ACTION buyACoke(int payment)
    {
        if(payment == CokePrice)
        {
            if(changeLevel == maxChangeCapacity)
            {
                return ACTION.NOINVENTORY;
            }
            inventoryLevel = inventoryLevel-1;
            changeLevel = changeLevel + CokePrice;
            numberOfCokesSold++;
            return ACTION.EXACTPAYMENT;
        }
        else if( payment > CokePrice)
        {
            changeDispensed = payment - CokePrice;
            if(changeDispensed > changeLevel)
            {
                return ACTION.INSUFFICIENTCHANGE;
            }
            else
            {
                changeLevel = changeLevel + CokePrice;
                inventoryLevel = inventoryLevel - 1;
                numberOfCokesSold++;
                return ACTION.DISPENSECHANGE;
            }
        }
        else if( payment < CokePrice )
        {
            return ACTION.INSUFFICIENTFUNDS;
        }
        return ACTION.EXACTPAYMENT;
    }
    public String toString()
    {
        return String.format("Machine Name" + "            " + machineName + "\n" + "Current Inventory Level " +   inventoryLevel + "\n" + "Current Change Level    " + changeLevel + "\n" + "Last Change Dispensed   " + changeDispensed + "\n" + "Inventory Capacity      " + maxInventoryCapacity + "\n" + "Change Capacity         " + maxChangeCapacity + "\n" + "Coke Price              " + CokePrice + "\n"+ "Coke Sold               " + numberOfCokesSold);
    }
}
