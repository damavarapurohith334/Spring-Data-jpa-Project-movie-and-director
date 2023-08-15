package com.rohi.dto;

import java.util.Objects;

public class DirectorDTO {
    private String firstName;
    private String lastName;
    private String address;
    private int contactNumber;
    private String email;

    public DirectorDTO() {
    }

    public DirectorDTO(String firstName, String lastName, String address, int contactNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.contactNumber = contactNumber;
        this.email = email;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "DirectorDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", contactNumber=" + contactNumber +
                ", email='" + email + '\'' +
                '}';
    }
    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, address, contactNumber, email);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DirectorDTO that = (DirectorDTO) o;
        return contactNumber == that.contactNumber &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(address, that.address) &&
                Objects.equals(email, that.email);
    }
}
