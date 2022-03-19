import java.util.Scanner;
import java.util.Random;
enum MyPets
{
    AUSTIN, SYLVESTER, SHADE
}
public class OLQ3
{
    public static void main(String[] args)
    {
        final int HAHA = 247;
        Scanner in = new Scanner(System.in);


        System.out.println("pick a number");
        int userNumber = in.nextInt();

        //Random number with integer
        Random rn = new Random();
        int randN = rn.nextInt(userNumber+1);
        System.out.println("Your random number between 0 and " + userNumber + " is " + randN);

        String string = "hello";
        char a = string.charAt(0);
        String subString = string.substring(0,3);
        MyPets name = MyPets.AUSTIN;

        //Random Number with Double 
        /*double randomDouble = Math.random();
        int randomInt = (int)(randomDouble * 10) +1;
        double olq3NumberDouble = Math.random();
        int olq3NumberInteger = (int)(olq3NumberDouble * userNumber);*/


        System.out.println("Hello World!");
        System.out.println(a);
        System.out.println(subString);
        System.out.println(name);
        //System.out.println(randomDouble);
        //System.out.println(randomInt);
        //System.out.println("Your random number between 0 and " + userNumber + " is " + olq3NumberInteger);
    }
}