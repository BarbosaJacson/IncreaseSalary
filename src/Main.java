import salario.Employee;
import java.util.List;
import java.util.Scanner;
import java.util.Locale;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        Locale.setDefault(Locale.US);
        int n = 0;
        int i = 0;
        List<Employee> listEmployees = new ArrayList<>();
        System.out.print("How many employees will be registered?   ");
        n = scanner.nextInt();
        scanner.nextLine();

        for (i = 0; i < n; i++) {
            System.out.println("Employee #" + (i + 1) + ": ");
            System.out.print("Id: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine();
            Employee employee = new Employee(id, name, salary);
            listEmployees.add(employee);
        }
        System.out.print("Enter the employee id that will have salary increase: ");
        Integer id = scanner.nextInt();
        // Usa Stream com Lambda pra buscar o funcionário
        listEmployees.stream()
                .filter(emp -> emp.getId() == id)
                .findFirst()
                .ifPresentOrElse(
                        emp -> {
                            // Funcionário encontrado, pede o percentual e aplica aumento
                            System.out.print("Enter the percentage: ");
                            double percent = scanner.nextDouble();
                            emp.increaseSalary(percent);
                        },  () -> System.out.println("This ID does not exist!!")
                );
        System.out.println("\nUpdated employee list:");
        listEmployees.forEach(System.out::println);
        scanner.close();
    }
}

