package com.sms;

public class Student {

	private String name, course, department;
	private int id, age, roll_no, score;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getRoll_no() {
		return roll_no;
	}

	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getId() {
		return id;
	}

	public Student(int id, String name, int age, int roll_no, String department, String course, int score) {
		this.id = id;
		this.name = name;
		this.course = course;
		this.department = department;
		this.age = age;
		this.roll_no = roll_no;
		this.score = score;
	}

	public Student(String name, int age, int roll_no, String department, String course, int score) {
		this.name = name;
		this.course = course;
		this.department = department;
		this.age = age;
		this.roll_no = roll_no;
		this.score = score;
	}

}
