public class OLQ9{
    //Object Relationships
        /*
        //Inheritance
        Tree <--- Oak Tree (Oak Tree is a tree, "is a" relationship)

        Existing class is the superclass and new class is the subclass
        A subclass can be a superclass of future subclasses
        The subclass exhibit the behaviors of its superclass and add behaviors that are specific to the subclass

        The //direct superclass// is the superclass from which the subclass explicitly inherits
        An //indirect superclass// is any class above the //direct superclass// in the class hierarchy
        The Java class hierarchy begins with class Object(in package java.lang)
        Java supports only single inheritance, in which each class is derived from exactly one direct superclass

        Although classes can exist independently, once they are associated with an inheritance relationships, they become related to other classes
        
        Even when a superclass method is appropriate for a subclass, that subclass often needs a customized version of the method
        The subclass can override the superclass method with an appropriate implementation

        
        */

        //This program has 3 separate file, they are in the same package shapedemo
        //main package : ShapeDemo.java
        //class file : Shape.java
        //class file : Circle.java
    public static void main(String[] args)
    {
        Shape A = new Shape("Poly");
        Circle C = new Circle("Hoop", 5.0);
        Rectangle R = new Rectangle("NotQuiteSquare", 4.5, 3.2);
        Square S = new Square("Quad", 3.4);

        System.out.printf("\n My name is %s\n", A.getName());

        System.out.printf("\nMy name is %s and my area is %.2f\n", C.getName(), C.getArea());//Circle inherits getName from shape
        System.out.printf("\nMy name is %s and my area is %.2f\n", R.getName(), R.getArea());
        System.out.printf("\nMy name is %s and my area is %.2f\n", S.getName(), S.getArea());
        C.setColor("Blue");

        System.out.printf("%s's color is %s\n", C.getName(), C.getColor());
    }
}

//package shapedemo;
public class Shape
{
    public String shapeName;
    public double dim1;
    public double dim2;
    private String color;

    public Shape(String name)
    {
        shapeName = name;
    }

    public String getName()
    {
        return shapeName;
    }

    public void setColor(String color)
    {
        if(color == "Blue")
        {
            this.color = "Green";
        }
        else
        {
            this.color = color;
        }
    }

    public String getColor()
    {
        return color;
    }

}

//package shapedemo;
public class Circle extends Shape // altering Circle does not affect Shape
{
    private double radius = 0;
    private String name;
    private String color;

    public Circle(String name, double radius)
    {
        super(name);//calling the constructor of the super class
        this.dim1 = this.dim2 = radius;
    }

    public double getArea()
    {
        return Math.PI*Math.pow(radius,2);
    }
}

//package shapedemo;
public class Rectangle extends Shape
{
    public Rectangle(String name, double height, double width)
    {
        super(name);
        this.dim1 = height;
        this.dim2 = width;
    }

    public double getArea()
    {
        return dim1 * dim2;
    }

//package shapedemo;
public class Square extends Rectangle
{
    publid Square(String name, double size)
    {
        super(name, size, size);
    }
}
}
