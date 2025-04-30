import salario.Employee;
import java.util.List;
import java.util.Scanner;
import java.util.Locale;
import java.util.ArrayList;

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
        double percent = 0;
        boolean idExists = false; // Verificar se o ID foi encontrado

// Percorre a lista de funcionários
        for (Employee employee : listEmployees) {
            if (employee.getId() == id) { // Compara o ID do funcionário com o ID informado
                idExists = true; // Marca que o ID existe
                scanner.nextLine(); // Limpa o buffer do scanner
                System.out.print("Enter the percentage: ");
                percent = scanner.nextDouble();
                 break; // Sai do loop após encontrar o funcionário
            }
        }

// Se o ID não foi encontrado, exibe a mensagem
        if (!idExists) {
            System.out.println("This ID does not exist!!");
        }

         for (Employee employee : listEmployees) {
            if (id == employee.getId()) {
               employee.increaseSalary(percent);
            }

        }  System.out.println("Updated list of employees: " + listEmployees);

    }


}

