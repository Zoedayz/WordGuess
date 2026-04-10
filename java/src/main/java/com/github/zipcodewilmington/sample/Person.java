package com.github.zipcodewilmington.sample;

public class Person implements PersonInterface {

    private String firstName;
    private String lastName;
    private Integer age;

    public Person() {
        this.firstName = "";
        this.lastName = "";
        this.age = 0;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public Integer getAge() {
        return age;
    }

    @Override
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", age " + age;
    }
}
