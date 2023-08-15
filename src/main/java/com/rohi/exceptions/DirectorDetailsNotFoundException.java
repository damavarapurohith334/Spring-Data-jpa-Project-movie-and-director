package com.rohi.exceptions;

public class DirectorDetailsNotFoundException extends RuntimeException {
	public DirectorDetailsNotFoundException(String message) {
		super(message);
	}
}