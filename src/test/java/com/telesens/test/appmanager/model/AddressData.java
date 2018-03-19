package com.telesens.test.appmanager.model;

public class AddressData {
    private final String firstName;
    private final String lastName;

    public AddressData(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
