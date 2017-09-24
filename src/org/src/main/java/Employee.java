package org.src.main.java;

public class Employee {

	private int employeeID;
	private String employeeName;
	private int managerID;

	public Employee(String employeeName, int employeeID, int managerID) {
		this.employeeName = employeeName;
		this.employeeID = employeeID;
		this.managerID = managerID;
	}

	public Employee(String employeeName, int employeeID) {
		this.employeeID = employeeID;
		this.employeeName = employeeName;
	}

	public int getEmployeeID() {
		return this.employeeID;
	}

	public int getManagerID() {
		return this.managerID;
	}

	public String getEmployeeName() {
		return this.employeeName;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}

}
