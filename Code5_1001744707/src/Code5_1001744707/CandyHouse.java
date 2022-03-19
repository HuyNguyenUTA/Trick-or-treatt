package code5_1001744707;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
        
public class CandyHouse extends House
{
    public CandyHouse(String name, HashMap<String, Integer>CandyList)
    {
        super(name, CandyList);
    }
    public synchronized String ringDoorbell(TrickOrTreater TOT) 
    { 
        String Candy = "";
        /* Call addToPath from TrickOrTreater and pass "+"  */ 
        TOT.addToPath("+");
        /* Call Thread.sleep to sleep for 3000 milliseconds */ 
        try
        {
            Thread.sleep(3000);
        }
        catch(InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
        /* get random number between 1 and number of candies listed in the CandyList */
        Random rand = new Random();
        int i = rand.nextInt(CandyList.size())+1;
        /* use an enhanced for loop to loop over the CandyList – Week12 – Slides 72-76 */ 
        for(HashMap.Entry mapElement : CandyList.entrySet())
        { 
            /* if the iterator’s value equals the chosen random number */ 
            /* then set Candy equal to key from the iterator */
            if((int)mapElement.getValue() == i)
            {
                Candy = (String)mapElement.getKey();
            }
        } 
        return Candy;
    } 
}
