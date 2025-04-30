package salario;
import java.util.List;
import java.util.Scanner;
import java.util.Locale;
import java.util.ArrayList;

public class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    public void increaseSalary(double percent) {
        double newSalary = (getSalary() * percent) / 100 + getSalary();
        setSalary(newSalary);
    }

  public String toString() {
      return id + ", Name: " + name + ", Salary: " + String.format("%.2f", salary);
    }

}
