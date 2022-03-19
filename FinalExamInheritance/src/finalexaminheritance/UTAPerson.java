package finalexaminheritance;

public class UTAPerson {
    private String name;
    private String ID;

    public UTAPerson(String name)
    {
	this.name = name;
    }
    public void WhoAmI()
    {
	System.out.printf("I am %s\n", name);
    }
}
