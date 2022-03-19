package code5_1001744707;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
public class TrickOrTreater implements Runnable 
{ 
    public static int ImDone; 
     
    private String name; 
    private String path = "."; 
    private ArrayList<House>ListOfHouses = new ArrayList<>(); 
    private HashMap<String, Integer>Bucket = new HashMap<>(); 
     
    /* constructor accepts a name and an ArrayList of Houses */ 
    public TrickOrTreater(String name, ArrayList<House> house)
    {
        this.name = name;
        this.ListOfHouses = house;
    }
    /* instance method getName() that returns the name */ 
    public String getName()
    {
        return name;
    }
    /* instance method getPath() that return the path */ 
    public String getPath()
    {
        return path;
    }
    /* void instance method addToPath that accepts a string that it concatenates */ 
    /* onto instance variable path                                               */     
    public void addToPath(String string)
    {
        path += string;
    }
    /* private void instance method Walk that accepts a speed */ 
        /* for loop 10 times                                 */ 
        /*    concatenate . onto path                        */  
        /*    sleep for speed number of milliseconds         */ 
    private void Walk(int speed) 
    {
        for(int i=0; i<10; i++)
        {
            path+= ".";
            try
            {
               Thread.sleep(speed);
            }
            catch(InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }
        }
    }
    /* public instance method named printBucket that returns a String */  
    public String printBucket()
    { 
        /* declare two strings – Candy and BucketContents                 */ 
        /* declare an integer named CandyCount and set to 0               */ 
        String Candy = "";
        String BucketContents = "";
        int CandyCount = 0;
        BucketContents = String.format("%-10s - ", name); 
 
        /*  use an enhanced for loop to loop over Bucket – Week12 – Slides 72-76 */ 
        for(HashMap.Entry mapElement : Bucket.entrySet())
        { 
            /* set Candy equal to the iterator’s key */ 
            /* set CandyCount equal to the iterator’s value */
            Candy = (String)mapElement.getKey();
            CandyCount = (int)mapElement.getValue();
            BucketContents += String.format("%15s %d ", Candy, CandyCount); 
        } 
        BucketContents += "\n"; 
        return BucketContents; 
    } 
     
    /* override run() from Runnable *. 
    */
    public void run() 
    { 
        /* create integer speed and count and set both to 0 */ 
        /* create string named Candy */ 
        int speed = 0;
        int count = 0;
        String Candy = "";
        Random rand = new Random();
        /* enhanced for loop over ListOfHouses*/

            for(House iter: ListOfHouses)
            { 
                /* set speed equal to a random number between 1 and 1501 */  
                speed = rand.nextInt(1501)+1;
                /* pass speed to instance method Walk */ 
                Walk(speed);
                /* call ringDoorbell using the iterator and pass in this */ 
                /* store the return value of ringDoorbell() in Candy */ 
                Candy =  iter.ringDoorbell(this);
                /* if HashMap Bucket contains a key of Candy */ 
                /* set count equal to the value associated with Candy from Bucket */ 
                /* increment count and put (Candy, count) pair in Bucket */ 
                /* else Candy is not in Bucket - put Candy in Bucket with a value of 1 */ 
                if(Bucket.containsKey(Candy))
                {
                    count = Bucket.get(Candy);
                    //++count;
                    Bucket.put(Candy, ++count);
                }
                else
                {
                    count = 1;
                    Bucket.put(Candy, count);
                }
            }
        /* add a synchronized block on object this to protect the update of ImDone */
        synchronized(this)
        {
            ImDone++;
        }
    } 
     
}