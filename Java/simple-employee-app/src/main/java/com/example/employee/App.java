package com.example.employee;

import java.lang.reflect.Method;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World");

        // demonstrate Employee usage
        Employee e = new Employee(1, "Alice", "Smith");
        System.out.println("Created employee: " + e);

        // Call the legacy method to show it runs too
        e.legacyOperation();

        // Reflection: list methods and indicate which are annotated with @Old
        Class<Employee> ec = Employee.class;
        Method[] methods = ec.getMethods();
        for (Method m : methods) {
            System.out.print("Method: " + m.getName());
            if (m.isAnnotationPresent(Old.class)) {
                Old ann = m.getAnnotation(Old.class);
                String note = ann != null ? ann.value() : "";
                System.out.print("  <-- @Old" + (note.isEmpty() ? "" : ": " + note));
            }
            System.out.println();
        }
    }
}
