public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee("E001", "Alex", "Manager", 150000);
        Employee employee2 = new Employee("E002", "David", "Developer", 80000);
        Employee employee3 = new Employee("E003", "John", "Team Lead", 80000);
        Employee employee4 = new Employee("E004", "Carlo", "HR", 80000);

        EmployeeManipulator.addEmployee(employee1);
        EmployeeManipulator.addEmployee(employee2);
        EmployeeManipulator.addEmployee(employee3);
        EmployeeManipulator.addEmployee(employee4);
        EmployeeManipulator.traverseEmployee();
        System.out.println();
        System.out.println(EmployeeManipulator.searchEmployee("E001"));
        System.out.println();
        EmployeeManipulator.delete("E003");
        EmployeeManipulator.traverseEmployee();
    }
}
