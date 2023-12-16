import java.util.Scanner;

//base class: employee
class Employee{
    private int employeeId;
    private String employeeName;
    private String designation;
    
    //constructor
    public Employee(int employeeId, String employeeName, String designation){
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.designation = designation;
    }
    
    //getter methods
    public int getEmployeeId(){
        return employeeId;
    }
    public String getEmployeeName(){
        return employeeName;
    }
    public String getDesignation(){
        return designation;
    }

    //setter methods
    public void setEmployeeId(int employeeId){
        this.employeeId = employeeId;
    }

    public void setEmployeeName(String employeeName){
        this.employeeName = employeeName;
    }

    public void setDesignation(String designation){
        this.designation = designation;
    }

    //abstract method for calculating bonus
    public double calculateBonus(){
        return 0.0; //base class calculation logic (can be overridden in derived classes)
    }

    public void displayEmployeeInfo(){
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Designation: " + designation);
    }

    public double calculateWeeklySalary(){
        return 0;
    }
}

//derived class: hourly employee
class HourlyEmployee extends Employee{
    private double hourlyRate;
    private int hoursWorked;

    public HourlyEmployee(int employeeId, String employeeName, String designation, double hourlyRate, int hoursWorked){
        super(employeeId, employeeName, designation);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    //method to calculate weekly salary
    public double calculateWeeklySalary(){
        return hourlyRate * hoursWorked;
    }

    //override calculateBonus method for hourly employee
    @Override
    public double calculateBonus(){
        //custom bonus calculation for hourly employee
        return calculateWeeklySalary() * 0.05; //5% of weekly salary as bonus
    }

    //method to disply detailed informatuon for HourlyEmployee
    @Override
    public void displayEmployeeInfo(){
        super.displayEmployeeInfo();
        System.out.println(("Hourly Rate: Rs. " +hourlyRate));
        System.out.println("Hours Worked: " + hoursWorked + "hours");
        System.out.println("Weekly Salary: Rs. " + calculateWeeklySalary());
        System.out.println("Bonus: Rs. " + calculateBonus());
    }
}

//derived class: SalariedEmployee
class SalariedEmployee extends Employee{
    private double monthlySalary;

    //constructor
    public SalariedEmployee(int employeeId, String employeeName, String designation, double monthlySalary){
        super(employeeId, employeeName, designation);
        this.monthlySalary = monthlySalary;
    }

    //method to calculate weekly salary
    public double calculateWeeklySalary(){
        return monthlySalary/4; //assuming a 4-week month
    }

    //override calculateBonus method for SalariedEmployee
    @Override
    public double calculateBonus(){
        //custom bonus calculation
        return monthlySalary * 0.1; //10% of monthly salary as bonus
    }
    //method to display detailed infor for salaried employees
    public void displayEmployeeInfo(){
        super.displayEmployeeInfo();
        System.out.println("Monthly Salary: Rs. " + monthlySalary);
        System.out.println("Weekly Salary: Rs. " + calculateWeeklySalary());
        System.out.println("Bonus: Rs. " + calculateBonus());
    }
}

//derived class: executive employee
class ExecutiveEmployee extends SalariedEmployee{
    private double bonusPercentage;

    public ExecutiveEmployee(int employeeId, String employeeName, String designation, double monthlySalary, double bonusPercentage){
        super(employeeId, employeeName, designation, monthlySalary);
        this.bonusPercentage = bonusPercentage;
    }

    //override calculateBonus method for Executive employee
    @Override
    public double calculateBonus(){
        double baseBonus = super.calculateBonus(); //invoke base class method
        return baseBonus + (getMonthlySalary() * bonusPercentage /100);
    }

    private double getMonthlySalary(){
        return 0;
    }

    //method to display detail information of executive employees
    @Override
    public void displayEmployeeInfo(){
        super.displayEmployeeInfo();
        System.out.println("Bonus Percentage: " + bonusPercentage + "%");
        System.out.println("Bonus: Rs. " + calculateBonus());
    }
}

//main program
public class lab3{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int MAX_EMPLOYEES = 10;
        Employee[] employees = new Employee[MAX_EMPLOYEES];
        int employeeCount = 0;

        while(true){
            System.out.println("Select an option: ");
            System.out.println("1. Create Hourly Employee");
            System.out.println("2. Create Salaried Employee");
            System.out.println("3. Cretae Executive Employee");
            System.out.println("4. Display All Employees");
            System.out.println("5. Exit");

            int option = scanner.nextInt();

            switch(option){
                case 1:
                    createAndAddHourlyEmployee(scanner, employees, employeeCount);
                    employeeCount++;
                    break;
                case 2:
                    createAndAddSalariedEmployee(scanner, employees, employeeCount);
                    employeeCount++;
                    break;
                case 3:
                    createAndAddExecutiveEmployee(scanner, employees, employeeCount);
                    employeeCount++;
                    break;
                case 4:
                    displayAllEmployees(employees, employeeCount);
                    break;
                case 5:
                    //exit the program
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println(("Invalid Option. Please choose a valid option"));
            }
        }
    }

    private static void createAndAddHourlyEmployee(Scanner scanner, Employee[] employee, int index){
        System.out.println("\nEnter information for hourly employee:");
        System.out.print("Employee ID: ");
        int hourlyEmployeeId = scanner.nextInt();
        System.out.print("Employee Name: ");
        String hourlyEmployeeName = scanner.next();
        System.out.print("Designation: ");
        String hourlyEmployeeDesignation = scanner.next();
        System.out.print("Hourly Rate: Rs. ");
        double hourlyRate = scanner.nextDouble();
        System.out.print("Hours Worked: ");
        int hoursWorked = scanner.nextInt();

        employee[index] = new HourlyEmployee(hourlyEmployeeId, hourlyEmployeeName, hourlyEmployeeDesignation, hourlyRate, hoursWorked);
        System.out.println("Hourly Employee create and added to the list.");
    }
    private static void createAndAddSalariedEmployee(Scanner scanner, Employee[] employees, int index) {
        System.out.println("\nEnter information for Salaried Employee:");
        System.out.print("Employee ID: ");
        int salariedEmployeeId = scanner.nextInt();
        System.out.print("Employee Name: ");
        String salariedEmployeeName = scanner.next();
        System.out.print("Designation: ");
        String salariedEmployeeDesignation = scanner.next();
        System.out.print("Monthly Salary: Rs. ");
        double monthlySalary = scanner.nextDouble();

        employees[index] = new SalariedEmployee(salariedEmployeeId, salariedEmployeeName,
                salariedEmployeeDesignation, monthlySalary);

        System.out.println("Salaried Employee created and added to the list.");
    }

    private static void createAndAddExecutiveEmployee(Scanner scanner, Employee[] employees, int index) {
        System.out.println("\nEnter information for Executive Employee:");
        System.out.print("Employee ID: ");
        int executiveEmployeeId = scanner.nextInt();
        System.out.print("Employee Name: ");
        String executiveEmployeeName = scanner.next();
        System.out.print("Designation: ");
        String executiveEmployeeDesignation = scanner.next();
        System.out.print("Monthly Salary: Rs. ");
        double executiveMonthlySalary = scanner.nextDouble();
        System.out.print("Bonus Percentage: ");
        double bonusPercentage = scanner.nextDouble();

        employees[index] = new ExecutiveEmployee(executiveEmployeeId,
                executiveEmployeeName, executiveEmployeeDesignation, executiveMonthlySalary, bonusPercentage);

        System.out.println("Executive Employee created and added to the list.");
    }

    private static void displayAllEmployees(Employee[] employees, int employeeCount) {
        if (employeeCount == 0) {
            System.out.println("No employees to display.");
        } else {
            System.out.println("\nAll Employees:");
            for (int i = 0; i < employeeCount; i++) {
                employees[i].displayEmployeeInfo();
                System.out.println();
            }
        }
    }
}