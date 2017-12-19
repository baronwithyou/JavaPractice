package Algorithm.Chapter5;

public class Employee {
    private String name;
    private double salary;
    private int seniority;

    public Employee(String name, double salary, int seniority) {
        this.name = name;
        this.salary = salary;
        this.seniority = seniority;
    }

    public Employee(String name) {
        this(name, 0, 0);
    }

    public boolean equals(Employee rhs) {
        return name.equals(rhs.getName());
    }

    public int hashCode() {
        return name.hashCode();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setSeniority(int seniority) {
        this.seniority = seniority;
    }

    public String getName() {

        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getSeniority() {
        return seniority;
    }

    @Override
    public String toString() {
        return name;
    }
}
