public class EmployeeManipulator {
    static Employee[] employees = new Employee[100]; // Assume a maximum of 100 employees
    static int employeeCount = 0; // To keep track of the number of employees

    public static void addEmployee(Employee employee) {
        if (employeeCount < employees.length) {
            employees[employeeCount] = employee;
            employeeCount++;
        } else {
            System.out.println("Employee array is full.");
        }
    }

    public static boolean searchEmployee(String employeeID) {
        for (int i = 0; i < employeeCount; i++) {
            if (employees[i].getEmployeeID().equalsIgnoreCase(employeeID)) {
                return true;
            }
        }
        return false;
    }

    public static void delete(String employeeID) {
        boolean found = false;
        for (int i = 0; i < employeeCount; i++) {
            if (employees[i].getEmployeeID().equalsIgnoreCase(employeeID)) {
                for (int j = i; j < employeeCount - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[employeeCount - 1] = null; // Remove the last element
                employeeCount--;
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Element not found");
        }
    }

    public static void traverseEmployee() {
        for (int i = 0; i < employeeCount; i++) {
            System.out.println(employees[i].toString());
        }
    }
}