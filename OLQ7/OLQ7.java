public class OLQ7 {

/*Class File  -> Account.java
    package accountdemo;

    public class Account
    {
        private String name;//instance variable

        public void setName(String name)//local variable
        {
            this.name = name;
        }
        public String getName()
        {
            return name;
        }
    }
*/

/* Project File -> AccountDemo.java
    package accountdemo;

    public class AccountDemo
    {
        public static void main(String[] args)
        {
            Account myAccount = new Account();

            Scanner in = new Scanner(System.in);

            Account myAccount = new Account();
            System.out.println("Initial name is %s\n", myAccount.getName());

            System.out.print("Please enter account name");
            String theName = in.nextLine();

            myAccount.setName(theName);

            System.out.println("Account's name is %s\n", myAccount.getName());
        }
    }

    it prints null for myAccount.getName(); because it's an local variable inside of the class
    Local variables are not automatically initialized
    Every instance variable has a default initial value
    The default value for an instance variable of type String is null
    Instance variables can only be accessed from main using public 
    Instance Variable:
    set = setters
    get = getters

    UML is divided into 3 sections: 
    top compartment -> name of the class
    Exp: Account

    middle compartment -> class's attributes, privates (-), public(+)
    Exp: -name:String  (private String name)

    bottom compartment -> methods, privates (-), public(+)
    Exp: +setName(name : String)
         +getName() : Strings
        _The constructor goes in the 3rd compartment, 
        _to distinguish a constructor from a class's operations, place the word "constructor" between guillemets(<<and>>) before the constructor's name
        exp: <<constructor>> Account(name: String)
    Java are divided into primitive types and reference types
    Primitive types: hole 1 value, initialized to 0
    References: store the addresses of objects in the computer's memory, refer to an object in the program, initialized to NULL
    
    /*Constructor 
    _ Cannot return value
    public class Account
    {
        private String name;

        public Account(String name) //constructor(same name as the class)
        {                           //When the object is instantiated
        this.name = name;             the private instance variable name is set to the String parameter passed in the constructor
        }
        public void setName(String name)
        {
            this.name = name;
        }
        public String getName()
        {
            return name;
        }
    }

    public class AccountDemo
    {
        public static void main(String[] args)
        {
            Account sAccount = new Account("Superman");
            Account bAccount = new Account("Batman");

            System.out.printf("sAccount is named %s\n", sAccount.getName());
            System.out.printf("bAccount is named %s\n", bAccount.getName());
        }
    }

    Exp:
    Student
    -studentID: string
    -netID: string
    -emailAddress: string

    +getStudentID():string
    +setStudentID(newStudentID:string)
    +getNetID():string
    +setNetID(newNetID:string)
    +getEmailAddress():string
    +setEmailAddress(newEmailAddress:string)

    public class Student
    {
        private String studentID;
        private String netID;
        private String emailAddress;

        public String getStudentID()
        {
        }
        public void setStudentID(String newStudentID)
        {
        }
        public String getNetID()
        {
        }
    }

    There are 4 methods of relationship between classes: 
    Association:"has a" relationship, classes are aware of each other, uni or bi directional
    Aggregation:"has a"/"whole-part" relationship, a class(the whole) is composed of/has other classes(the parts), empty diamond on "whole" side
    Composition: a very strong aggregation, a class(the whole) is composed of/has other classes(the parts) BUT the parts cannot exist without the whole
                black diamond on"whole" side
    Inheritance: represents the"is a" relationship, relationship between a support class/base class and a derived/subclass,empty arrow is on the side of the super class

    1..*: many
    */
}
