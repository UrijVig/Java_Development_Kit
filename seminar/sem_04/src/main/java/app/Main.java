package main.java.app;

public class Main {
    public static void main(String[] args) {
        EmployeeDirectory empDir = new EmployeeDirectory();
        empDir.addEmployee(new Employee(415,"58965896", "Stiv", 21));
        empDir.addEmployee(new Employee(58,"61497421", "Mark", 22));
        empDir.addEmployee(new Employee(693,"654165498", "Karl", 24));
        empDir.addEmployee(new Employee(254,"98721", "Mark", 19));
        empDir.addEmployee(new Employee(589,"1624987", "David", 20));
        empDir.addEmployee(new Employee(256,"61498798", "Elis", 21));
        System.out.println("Вывод списка номеров по имени");
        System.out.println(empDir.getPhoneNumberByName("Mark"));
        System.out.println(empDir.getPhoneNumberByName("David"));
        System.out.println(empDir.getPhoneNumberByName("Karla"));
        System.out.println("Вывод списка сотрудников по стажу");
        System.out.println(empDir.getEmployeeByExperience(21));
        System.out.println(empDir.getEmployeeByExperience(20));
        System.out.println(empDir.getEmployeeByExperience(2));
        System.out.println("Вывод сотрудника по табельному номеру");
        System.out.println(empDir.getEmployeeByPersonalNumber(254));
        System.out.println(empDir.getEmployeeByPersonalNumber(65));
    }
}
