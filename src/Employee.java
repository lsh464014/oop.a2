/**
 * The {@code Employee} class represents an employee, which is a type of {@link Person}.
 */
public class Employee extends Person {
    private double salary;
    private boolean isFullTime;

    /**
     * Default constructor that initializes the employee's attributes to default values.
     */
    public Employee() {
        super();
        this.salary = 0.0;
        this.isFullTime = false;
    }

    /**
     * Constructor that initializes the employee's attributes with the specified values.
     *
     * @param name the name of the employee
     * @param age the age of the employee
     * @param phoneNumber the phone number of the employee
     * @param salary the salary of the employee
     * @param isFullTime indicates if the employee is full-time or part-time
     */
    public Employee(String name, int age, String phoneNumber, double salary, boolean isFullTime) {
        super(name, age, phoneNumber);
        this.salary = salary;
        this.isFullTime = isFullTime;
    }

    /**
     * Gets the salary of the employee.
     *
     * @return the salary of the employee
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Sets the salary of the employee.
     *
     * @param salary the new salary of the employee
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Checks if the employee is full-time.
     *
     * @return {@code true} if the employee is full-time, {@code false} otherwise
     */
    public boolean isFullTime() {
        return isFullTime;
    }

    /**
     * Sets the employment status of the employee.
     *
     * @param fullTime the employment status of the employee
     */
    public void setFullTime(boolean fullTime) {
        isFullTime = fullTime;
    }

    /**
     * Returns a string representation of the employee, including the details from the {@link Person}
     * class (name, age, and phone number), as well as the salary and employment status (full-time or part-time).
     *
     * @return a string representation of the employee
     */
    @Override
    public String toString() {
        return super.toString() + String.format(", Salary=%.2f, IsFullTime:%b",
                salary, isFullTime);
    }
}
