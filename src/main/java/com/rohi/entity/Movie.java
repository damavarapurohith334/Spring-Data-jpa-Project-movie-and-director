package com.rohi.entity;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int movieId;

	private String movieTitle;
	private Date dateReleased;
	private Integer movieRunningTime;

	public Movie(int movieId, String movieTitle, Date dateReleased, Integer movieRunningTime) {
		super();
		this.movieId = movieId;
		this.movieTitle = movieTitle;
		this.dateReleased = dateReleased;
		this.movieRunningTime = movieRunningTime;
	}

	public Movie() {
		super();
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
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
		return "Movie [movieId=" + movieId + ", movieTitle=" + movieTitle + ", dateReleased=" + dateReleased
				+ ", movieRunningTime=" + movieRunningTime + "]";
	}

}