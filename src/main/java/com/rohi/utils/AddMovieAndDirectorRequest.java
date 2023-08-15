package com.rohi.utils;

import java.time.LocalDateTime;
import java.util.Date;

public class AddMovieAndDirectorRequest {
    private String movieTitle;
    private Date dateReleased;
    private Integer movieRunningTime;
    private String firstName;
    private String lastName;
    private String address;
    private int contactNumber;
    private String email;

    public AddMovieAndDirectorRequest() {
    }

    public AddMovieAndDirectorRequest(String movieTitle, Date dateReleased, Integer movieRunningTime,
                                      String firstName, String lastName, String address, int contactNumber, String email) {
        this.movieTitle = movieTitle;
        this.dateReleased = dateReleased;
        this.movieRunningTime = movieRunningTime;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.contactNumber = contactNumber;
        this.email = email;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public Date getDateReleased() {
        return dateReleased;
    }

    public void setDateReleased(Date dateReleased) {
        this.dateReleased = dateReleased;
    }

    public Integer getMovieRunningTime() {
        return movieRunningTime;
    }

    public void setMovieRunningTime(Integer movieRunningTime) {
        this.movieRunningTime = movieRunningTime;
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
        return "AddMovieAndDirectorRequest{" +
                "movieTitle='" + movieTitle + '\'' +
                ", dateReleased=" + dateReleased +
                ", movieRunningTime=" + movieRunningTime +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", contactNumber=" + contactNumber +
                ", email='" + email + '\'' +
                '}';
    }
}
