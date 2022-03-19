package finalexaminheritance;

import java.util.ArrayList;

public class FinalExamInheritance {

    public static void main(String[] args) {
        Student S = new Student("Student");
	Employee E = new Employee("Employee");
	ArrayList<UTAPerson> ABC = new ArrayList<UTAPerson>();
        ABC.add(new Student("Student"));
        ABC.add(new Employee("Employee"));
        for(UTAPerson it : ABC)
        {
            it.WhoAmI();
        }
    }
    
}
