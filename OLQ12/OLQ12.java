/*
Generic Collections
ArrayList
LinkedList
Vector

You use linkedlist because it's better for inserting and deleting than arraylist
*/
public class NumberThread implements Runnable
{
	private int number;
	static int counter = 1;

	public NumberThread(int number)
	{
		this.number = number;
	}

	public void run()
	{
		System.out.printf("%d-", number);

		if(counter++ % 10 ==0)
		{
			System.out.println();
		}
	}
}
public class AlphabetThread implements Runnable
{
	private char letter;

	public ALphabetThreat(char letter)
	{
		this.letter = letter;
	}

	public void run()
	{
		synchronized(System.out)
		{
			System.out.print(letter);
			System.out.print(letter);
		}
	}
}
public void run()
{
	Random rn = new Random();

	try
	{
		for(int i=0; i<5; i++)
		{
			System.out.printf("$%s$\n", Thread.currentThread().getName());
			Thread.sleep(rn.nextInt(50));
		}
		System.out.println();
	}
	catch(InterruptedException e)
	{
		Thread.currentThread().interrupt();
	}
	System.out.printf("$s is done sleeping\n", name);
}
public class OLQ12
{
	public static void main(String[] args)
	{
		DollarThread task1 = new DollarThread("task1");
		DollarThread task2 = new DollarThread("task2");
		DollarThread task3 = new DollarThread("task3");
		AsterickThread task4 = new AsterickThread("task4");
		AsterickThread task5 = new AsterickThread("task5");
		AsterickThread task6 = new AsterickThread("task6");

		ArrayList <AlphabetThread> AT = new ArrayList<>();

		for(int i=0; i< 26; i++)
		{
			AT.add(new AlphabetThread((char)(i+65)));
		}

		ExecutorService executorService = Executors.newCachedThreadPool();

		for(int i = 0; i<26; i++)
		{
			executorService.execute(AT.get(i));
		}

		executorService.shutdown();

		//
		ArrayList <NumberThread> NT = new ArrayList<>();

		for(int i = 10; i<100; i++)
		{
			NT.add(new NumberThread(i));
		}

		System.out.println("Starting Executor");

		ExecutorService executorService = Executors.newCachedThreadPool();

		for(int i = 0; i < 90; i++)
		{
			executorService.execute(NT.get(i));
		}

		executorService.shutdown();
	}
}