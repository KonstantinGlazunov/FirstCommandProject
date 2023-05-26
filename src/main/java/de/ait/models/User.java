package de.ait.models;

public class User {
    private String firstName;
    private String lastName;
    private int age;
    private double height;

    public User(String firstName, String lastName, int age, double height) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.height = height;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }


    @Override
    public String toString() {
        /*Kirill|Petrov|55|1.90*/
        return firstName + "|" +
                lastName + "|" +
                age + "|" +
                height;
    }
}
