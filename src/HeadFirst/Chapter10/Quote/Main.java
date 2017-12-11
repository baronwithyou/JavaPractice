package HeadFirst.Chapter10.Quote;

class Main {
    public static void main(String []args) {
        Employee e = new Employee();
        e.age = 10;
        changeEmployeeAge(e);
        System.out.println(e.age);
    }

    private static void changeEmployeeAge(Employee e) {
        e = new Employee();
        e.age = 20;
    }
}