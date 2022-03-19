public class OLQ11 {
    //Example 1
    public interface Advisor
    {
        public String readStudentRecord(String studentID)
    }

    public class FacultyAdvisor extends Faculty implements Advisor
    {
        //Override
        public String readStudentRecord(String studentID)
        {
            //actual code to read a student record using Faculty+Advisor permissions
        }
    }

    public class StaffAdvisor extends Staff implements Advisor
    {
        //Override
        public String readStudentRecord(String studentID)
        {
            //actual code to read a student record using Staff+Advisor permissions
        }
    }

    //Example 2
    public interface Drawable
    {
        public void draw();
    }

    public class SpaceObject implements Drawable

    public class Shape implements Drawable

    public class Martian extends SpaceObject //Martian gets drawable(inherited)

    public class Circle extends Shape // Circle get drawable(inherited)

    //Now we can create a container to hold Drawable objects
    Drawable[] drawableObjects = new Drawable[100];

    ArrayList <Drawable> drawableObjects = new ArrayList<>();

    for (Drawable it : drawableObjects)
    {
        it.draw();
    }
    public static void main(String[] args)
    {
        /*
        Checked Exception: These are the exceptions that are checked at compile time. 
        If some code within a method throws a checked exception, then the method must either handle the exception or 
        it must specify the exception using the throws keyword. 
        The compiler checks each method call and method declaration to determine whether or not the method throws a checked exception
        If a method does throw a checked exception, the compiler verifies that the checked exception is caught or is declaed in a throws clause
        This is known as the catch-or-declare requirement
        Exp:  We were not required to handle the exception from opening a file that does not exist because 
        FileNotFOundException is not a subclass of RuntimeException

        Unchecked Exception:These are the exceptions that are not checked at compile time.
        it is not forced by the compiler to either handle or specify the exception. 
        It is up to the programmers to be civilized, and specify or catch the exceptions.
        The compiler does not enforce the catch-or-declare requirement for unchecked exceptions
        Exp: We were not required to put try-catch around nextInt() because it throws an InputMismatchException 
        which is a subclass of RuntimeException

        All exceptions that are direct or indirect subclasses of RunRimeExceptions are unchecked exceptions

        Classes that inherit directly or indirectly from class Error are unchecked
        Errors are serious 
        
        finally Block: optional, placed after the last catch block,
                        executes whether or not an exception is thrown in the try block
        try
        {
        }
        catch
        {
        }
        finally
        { 
        }

        assert: help you debug and identify logic errors in your code
                The assert statement evaluates a boolean expression and, if false
                throws an AssertionError
                AssertionError is a subclass of Error

                2 forms:    assert expression;
                        
                            throws an AssertionError if expression is false
                            Exp:  assert expression 1 : expression2 //evaluates expression 1 and 
                                                                    throws anAssertError with expression2 as the error message
                                                                    if expression 1 is false
        Multiple inheritance - also known as diamond inheritance

        Interface: doesn't have instance variable, only methods
                    The interface specifies what operations an object must permit users to perform
                    Java has the ability to require classes to implement a set of common methods
                    Interface declaration begins with the keyword "interface" and contains only constants and abstract methods
                    All interface members must be public and interfaces may not specify any implementation details
                    No concrete methods declarations
                    No instance variables
                    All methods declared in an interface are implicitly public abstract
        
                    To use an interface, a concrete class must specify that it implements the interface
                    and declare each method in the interface with the signature specified in the interface declaration

                    If a class does not implement all of the methods of the inteface, then that class will be abstract
        
        MULTITHREADING

        CONCURRENT VS PARALLEL
            Concurrent tasks: tasks that are making progress at once
            Parallel: tasks are executing simultaneously

        Parallelism is a subset of concurrency

        Processs: a self-contained execution environment including its own memory space
        Thread: An independent path of execution within a process, running concurrently with other threads within a shared memory space
        A thread is the unit of execution within a process. A process can have anywhere from just one thread to many threads
        
        Two types of memory are available to a process or a thread
            the stack
            the heap
        Each thread has its own stack
        All threads share the heap

        EXECUTOR
        Runnable is an interface
        The Runnable interface declares a single method run
        An Executor object executes Runnable
        An Executor object creates and manages a group of threads called a thread pool

        When an Executor begins executing a Runnable, the Executor calls the Runnable object's run method which executes in the new thread
        
        The ExecutorService interface extends Executor
            declares various methods for handling an Executor
        You obtain an ExecutorService object by calling one of the static methods declared in class Executors
        Exp: ExecutorService executorService = Executors.newCachedThreadPool();


        */
        public class Tash implements Runnable
        {
            Random rn = new Random();
            private final int sleepTime;
            private final String name;

            public Tash(String taskName)
            {
                name = taskName;
                sleepTime = rn.nextInt(5000);
            }
            public void run()//override run so it doesn't become abstract
            {
                System.out.printf("%s is going to sleep for %d milliseconds\n");
                Thread.sleep(sleepTime);
            }
            /*
            sleep() is a static method of the class Thread
            sleep() will place the thread in the timed waiting state for the specified number of milliseconds
            The thread loses the processor and trhe system will allow another thread to execute
            When the time is up, the thread wakes up and enters the runnable state
            */
        }
    }
}
