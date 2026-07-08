import java.util.ArrayList;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Employee(101, "Arun Kumar", "IT", 45000));
        employees.add(new Employee(102, "Priya Sharma", "HR", 42000));
        employees.add(new Employee(103, "Rahul Verma", "Finance", 52000));
        employees.add(new Employee(104, "Sneha Reddy", "IT", 48000));
        employees.add(new Employee(105, "Karthik Nair", "Sales", 39000));
        employees.add(new Employee(106, "Meena Iyer", "Marketing", 46000));
        employees.add(new Employee(107, "Vivek Singh", "Finance", 55000));
        employees.add(new Employee(108, "Divya Patel", "HR", 43000));
        employees.add(new Employee(109, "Suresh Babu", "IT", 61000));
        employees.add(new Employee(110, "Anjali Gupta", "Sales", 40000));
        employees.add(new Employee(111, "Nikhil Joshi", "Marketing", 47000));
        employees.add(new Employee(112, "Pooja Das", "IT", 53000));
        employees.add(new Employee(113, "Ramesh Krishnan", "Operations", 49000));
        employees.add(new Employee(114, "Kavya Menon", "HR", 44000));
        employees.add(new Employee(115, "Ajay Mishra", "Finance", 58000));
        employees.add(new Employee(116, "Neha Kapoor", "Sales", 41000));
        employees.add(new Employee(117, "Sanjay Rao", "Operations", 51000));
        employees.add(new Employee(118, "Lakshmi Narayanan", "Marketing", 50000));
        employees.add(new Employee(119, "Deepak Yadav", "IT", 65000));
        employees.add(new Employee(120, "Swathi Raj", "Finance", 56000));
    
        // Stream<Employee> s1 = employees.stream();
        // Stream<Employee> s2 = s1.filter((e->e.getDepartment().equals("IT")));
        // Stream<Employee> s3 = s2.sorted((e1, e2)->e1.getName().compareTo(e2.getName()));
        // s3.forEach(System.out::println);


        employees.stream()
        .filter((e)->e.getDepartment().equals("IT"))
        .sorted((e1, e2)->e2.getName().compareTo(e1.getName()))
        .forEach(System.out::println);
    
    }

}
