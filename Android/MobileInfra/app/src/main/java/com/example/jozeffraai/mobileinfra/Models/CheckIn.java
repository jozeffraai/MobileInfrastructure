package com.example.jozeffraai.mobileinfra.Models;

/**
 * Created by Jozef Fraai on 29-6-2015.
 */
public class CheckIn {
	private int id;
	private String checkInTime;
	private String checkOutTime;
	private int studentID;

	public CheckIn() {
	}


	public CheckIn(int id, String checkInTime, String checkOutTime, int studentID) {
		this.id = id;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
		this.studentID = studentID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}

	public String getCheckOutTime() {
		return checkOutTime;
	}

	public void setCheckOutTime(String checkOutTime) {
		this.checkOutTime = checkOutTime;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
}
