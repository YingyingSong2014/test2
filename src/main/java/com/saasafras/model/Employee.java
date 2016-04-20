package com.saasafras.model;

public class Employee {
	private String id;
	private String lastName;
	private String firstName;
	private Role role; 
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public Employee(String id, String lastName, String firstName) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
	}
	public Employee() {
		super();
	}
	public Employee(String id, String lastName, String firstName, Role role) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.role = role;
	}
	

}
