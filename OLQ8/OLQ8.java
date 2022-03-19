package olq8;
public class OLQ8 {
    public static void main(String[] args)
    {
        /*
            package olq8;
            public class Account
            {
                private String name;
                private double balance;

                public Account(String name, double balance)
                {
                    this.name = name;
                    if(balance > 0.0)
                    {
                        this.balance = balance;
                    }
                }

                public void setName(String name)
                {
                    this.name = name;
                }

                public String getName()
                {
                    return name;
                }

                public void deposit(double depositAmount)
                {
                    if(depositAmound > 0.0)
                    {
                        balance += depositAmount;
                    }
                }

                public double getBalance()
                {
                    return balance;
                }

                public boolean withdraw(double withdrawalAmount)
                {
                    if(withdrawal <= balance)
                    {
                        balance -= withdrawalAmount;
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }

                UML:
                1st: Account
                2nd:-name : String
                    -balance : Double
                3rd:<<constructor>> Account(name : String, balance: double)
                    +setName(name : String)
                    +getName() : String
                    +deposit(depositAmount : double)
                    +getBalance() : double
            }
        */
        Scanner in = new Scanner(System.in);

        Account sAccount = new Account("Superman",-7);
        Account bAccount = new Account("Batman",1000000);

        System.out.printf("sAccount is name %s and has a balance of $%.2f\n", sAccount.getName(), sAccount.getBalance());
        System.out.printf("bAccount is name %s and has a balance of $%.2f\n", bAccount.getName(), bAccount.getBalance());

        System.out.printf("How much money should Batman give Superman?");
        double batLoan = in.nextDobuel();
        
        if(bAccount.withdraw(batLoan))
        {
            sAccount.deposit(batLoan);

            System.out.printf("Superman now has $%.2f in his account", sAccount.getBalance());
            System.out.printf(" and Batman has $%.2f in his account\n", bAccount.getBalance());
        }
        else
        {
            System.out.printf("Batman does not have that much money\n");
        }

        /*Method Overloading toString()
        publid String toString()
        {
            return "Pencil Machine status : " + PENCIL_PRICE + "" + changeLevel + "" + inventoryLevel;
        }
        System.out.println(PM);
        */

        //Enhanced for loop and 2D arrays
        //regularloop
        int MultiplicationTable[][] = new int [9][9];

        for(int i = 1; i <= 9; i++)
        {
            for(int j = 1; j <= 9; j++)
            {
                System.out.printf("%5d", MultiplicationTable[i][j]);
            }
        }

        //enhanced for loop
        for(int[] row : MultiplicationTable)
        {
            for(int column : row)
            {
                System.out.printf("%5d", column);
            }
        }
        
        //exeption error example
        public class Time1
        {
            private int hour;
            private int minute;
            private int second;

            public void setTime(int hour, int minute, int second)
            {
                if(hour < 0 || hour >= 24|| minute < 0 || minute>= 60|| second < 0 || second >= 60)
                {
                    throw new IllegalArgumentException("hour, minute and/or second was out of range");
                }
                this.hour = hour;
                this.minute = minute;
                this.second = second;
            }

        }

        public static void main(String[] args)
        {
            Time1 time = new Time1();

            try
            {
                time.setTime(99,99,99);
            }
            catch(IllegalArgumentException e)
            {
                System.out.printf("Exception: %s\n\n", e.getMessage);//getMessage is a method in the IllegalArgumentException object that gets the message that was written to the object when it was thrown
            }
        }

        public static void main(String[] args)
        {
            Candy C1 = new Candy("Butterfinger", 100, "fun size");
            Candy C2 = new Candy("Snickers", 100, "mini");
            Candy C3 = new Candy("M&M", 100, "snack size");
            Candy C4 = new Candy("Candy Corn", 123, "handful");

            ArrayList<Candy>AllCandy = new ArrayList<>();
            AllCandy.add(new Candy("Butterfinger", 100, "fun size"));
            AllCandy.add(new Candy("Snikers", 100, "mini"));
            AllCandy.add(new Candy("M&Ms", 100, "snack size"));
            AllCandy.add(new Candy("Butterfinger", 100, "handful"));

            BagOfCandy Bag1 = new BagOfCandy();
            for(Candy it : AllCandy)
            {
                try
                {
                    /*Bag1.addCandy(C2);
                    Bag1.addCandy(C3);
                    Bag1.addCandy(C1);
                    Bag1.addCandy(C4);*/
                    Bag1.addCandy(it);
                }
                catch(IllegalArgumentException reject)
                {
                    System.out.printf("Candy not added : %s\n", reject.getMessage);
                }
            }
            Bag1.printCandy();
        }

        public class BagOfCandy
        {
            private ArrayList<Candy> CandyList = new ArrayList<>();

            public void addCandy(Candy candy)
            {
                if(CandyList.contains(candy.getName()))
                {
                    String message = candy.getName() + " - allergy alert";
                    throw new IllegalArgumentException(message);
                }
                CandyList.add(candy);
            }

            public void WhatisInmyBag()
            {
                for (Candy it : CandyList)
                {
                    System.out.println(it);
                }
            }
        }

        public class Candy
        {
            private String name;
            private int calories;
            private String size;

            public String toString()
            {
                return"Name: " + name + "Calories:" + calories + "Size:" +size;
            }

            Candy(String name, int calories, String size)
            {
                this.name = name;
                this.calories = calories;
                this.size = size;
            }

            publid String getName()
            {
                return name;
            }
        }

        //sprintf(array,"%d",x); -> print to an array

        //String Format
        String message = candy.getName() + " - allergy alert";
        throw new IllegalArgumentException(message);

        -> throw new IllegalArgumentException(String.format("%s - allergy alert", candy.getName()));
        //String format returns the String "Butterfinger - allery alert"

        public String toString()
        {
            return String.format("My dog is %d years old which means my dog is %s",age, isOld()?"old":"young");
        }
    }
}
