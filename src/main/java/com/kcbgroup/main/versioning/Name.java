package com.kcbgroup.main.versioning;

public class Name {
    private String firstName;
    private String lastName;
    private String surname;

    public Name(){

    }

    public Name(String  firstName, String lastName, String surname){
        this.firstName = firstName;
        this.lastName = lastName;
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
