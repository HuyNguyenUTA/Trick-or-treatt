package code5_1001744707;

import java.util.ArrayList;
import java.util.HashMap;
public abstract class House 
{
    public abstract String ringDoorbell(TrickOrTreater TOT);
    private String houseName;
    HashMap<String, Integer>CandyList = new HashMap<>();
    
    public House(String name, HashMap<String, Integer>CandyList)
    {
        houseName = name;
        this.CandyList = CandyList;
    }
}
