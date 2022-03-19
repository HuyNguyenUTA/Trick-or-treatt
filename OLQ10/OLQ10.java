public class OLQ10 {
    public static void main(String[] arg)
    {
        /*
        Polymorphism: describes the ability of different objects to be accessed by a common interface
        Inheritance: describes the ability of objects to derive behavior patterns from other objects
                     These objects can then customize and add new unique characteristics
        Encapsulation: describes the ability of objects to maintain their internal workings independently from the program they are used in
                    Classes encapsulate attributes and methods into objects created from those classes

        public void setMileage(int mileage)
        {
            if(mileage > this.mileage)
                this.mileage = mileage;
        }
        private boolean isNewCar()
        {
            return ((mileage < 100)?true:false);
        }
        //Java polymorphism means that a call to an instance method will cause
        a different method to be executed depending on the type of object 
        that invokes the method
        
        //Subclasses Fish, Frog and Bird are created from superclass Animal
        //The instantiations of Fish, Frog and Bird are kept in an ArrayList 
        of type Animal
        */
        @Override
        public void move()
        {
            //Fish fly 10 feet eery second
            Random rn = new Random();
            xycoordinates[0] += rn.nextInt(4);
            xycoordinates[1] +=rn.nextInt(4);
        }

        @Override
        public void move()
        {
            //Birds fly 10 feet eery second
            Random rn = new Random();
            xycoordinates[0] += rn.nextInt(11);
            xycoordinates[1] +=rn.nextInt(11);
        }

        @Override
        public void move()
        {
            //Frogs jump 5 feet every second
            Random rn = new Random();
            xycoordinates[0] += rn.nextInt(6);
            xycoordinates[1] += rn.nextInt(6);
        }

        package animaldemo;
        public class Animal
        {
            private String name;
            int xycoordinates[] = new int [2];

            Animal(String name)
            {
                this.name = name;
            }

            public String getName()
            {
                return name;
            }

            public String toString()
            {
                return String.format("\n%s is at %d-%d", name, xycoordinates[0], xycoordinates[1]);
            }

            public void move()//each instance of Animal moves differently
            {
                for(Animal it : Zoo)
                {
                    it.move();//the same message sent to a variety of objects has "many forms" of results
                }
            }
        }

        //AnimalDemo.java
        public static void main(String[] args)
        {
            ArrayList <Animal> Zoo = new ArrayList<>();
            Scanner in = new Scanner(System.in);
            String AnimalFile;
        
            System.out.print("Enter the file name of Fish");
            AnimalFile = in.nextLine();
            ReadFile(AnimalFile, "Fish", Zoo);

            System.out.print("Enter the file name of Frog");
            AnimalFile = in.nextLine();
            ReadFile(AnimalFile, "Frog", Zoo);

            System.out.print("Enter the file name of Bird");
            AnimalFile = in.nextLine();
            ReadFile(AnimalFile, "Bird", Zoo);
        }

        public static void ReadFile(String filename, String AnimalType, ArrayList <Animal> Zoo)
        {
            File FH = new File(filename);
            Scanner FileReader = null;

            try
            {
                FileReader = new Scanner(FH);
            }
            catch(Exception e)
            {
                System.out.printf("%s file name does not exist...exiting\n", filename);
                System.exit(0);
            }

            String FileLine[] = FileReader.nextLine().split(",");

            switch(AnimalType)
            {
                case "Fish":
                    for(String it : FileLine)
                        Zoo.add(new Fish(it));
                    break;
                case "Frog":
                    for(String it : FileLine)
                        Zoo.add(new Frog(it));     
                    break;
                case "Bird":
                    for(String it : FileLine)
                        Zoo.add(new Bird(it));    
                    break;
            }
            FileReader.close();



            //Abstract Classes and Methods
            /*
            Superclasses in inheritance hierarchies are called abstract superclasses
            Abstract classes are incomplete- cannot be used to instantiate objects
            If a subclass does not do something to become concrete, then the subclass will be abstract
            Classes that can be used to instantiate objects are called concrete classes
            */
            //A class that contains abstract methods must be an abstract class even if that class contains some concrete
            //Each concrete subclass of an abstract superclass also must provide concrete implementations of each of the superclass's abstract methods
            //An abstract class typically contains one or more abstract methods that subclasses must override if they want to be conrete
            
            public abstract class Shape
            {
                public abstract void draw();//abstract method, cannot have a body
            }
        }
    }
}
