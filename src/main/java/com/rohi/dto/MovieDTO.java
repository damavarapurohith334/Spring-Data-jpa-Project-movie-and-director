package com.rohi.dto;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class MovieDTO {
    private String movieTitle;
    private Date dateReleased;
    private Integer movieRunningTime;

    public MovieDTO() {
    }

    public MovieDTO(String movieTitle, Date dateReleased, Integer movieRunningTime) {
        this.movieTitle = movieTitle;
        this.dateReleased = dateReleased;
        this.movieRunningTime = movieRunningTime;
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

    @Override
    public String toString() {
        return "MovieDTO{" +
                "movieTitle='" + movieTitle + '\'' +
                ", dateReleased=" + dateReleased +
                ", movieRunningTime=" + movieRunningTime +
                '}';
    }
    @Override
    public int hashCode() {
        return Objects.hash(movieTitle, dateReleased, movieRunningTime);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieDTO movieDTO = (MovieDTO) o;
        return Objects.equals(movieTitle, movieDTO.movieTitle) &&
                Objects.equals(dateReleased, movieDTO.dateReleased) &&
                Objects.equals(movieRunningTime, movieDTO.movieRunningTime);
    }

}
