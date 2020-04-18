package com.luv2code.springdemo.entity;

import org.springframework.web.multipart.MultipartFile;

public class DocumentDetails {
	MultipartFile file;
	String firstName;
	String lastName;
	String email;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "DocumentDetails [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
}
