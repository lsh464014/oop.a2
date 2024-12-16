/**
 * The {@code Person} class represents a person with a name, age, and phone number.
 * It is an abstract class and can be extended to represent different types of people
 * with additional properties and behaviors.
 */
public abstract class Person {
    private String name;
    private int age;
    private String phoneNumber;

    /**
     * Default constructor that initializes the person's attributes to default values.
     */
    public Person() {
        this.name = "";
        this.age = 0;
        this.phoneNumber = "";
    }

    /**
     * Constructor that initializes a person with the specified name, age, and phone number.
     *
     * @param name the name of the person
     * @param age the age of the person
     * @param phoneNumber the phone number of the person
     */
    public Person(String name, int age, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the name of the person.
     *
     * @return the name of the person
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the person.
     *
     * @param name the new name of the person
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the age of the person.
     *
     * @return the age of the person
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the person.
     *
     * @param age the new age of the person
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets the phone number of the person.
     *
     * @return the phone number of the person
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number of the person.
     *
     * @param phoneNumber the new phone number of the person
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns a string representation of the person, including their name, age, and phone number.
     *
     * @return a string representation of the person
     */
    @Override
    public String toString() {
        return String.format("Name=%s, Age=%d, Phone=%s",
                name, age, phoneNumber);
    }
}
