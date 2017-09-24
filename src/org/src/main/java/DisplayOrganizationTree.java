package org.src.main.java;

import java.util.Map;
import java.util.TreeMap;
import java.util.List;

public class DisplayOrganizationTree {

	private static int positionInHierarchy = 3;
	private static Map<Integer, List<Employee>> teamStructure = new TreeMap<Integer, List<Employee>>();

	public static void main(String[] args) {

		OrganizationEmployeeData organizationEmployeeData = new OrganizationEmployeeData();
		organizationEmployeeData.defineTeamStructure();

		teamStructure = organizationEmployeeData.teamStructure();
		int keyCEO = organizationEmployeeData.getID_CEO();

		printHierarchy(teamStructure.get(keyCEO));
	}

	/**
	 * Display the Organization structure on the Console.
	 */
	public static void printHierarchy(List<Employee> teamList) {
		String DISPLAY_FORMAT_MANAGERS = "%4s %-10s";
		String DISPLAY_FORMAT_EMPLOYEES = "%10s %-10s";

		for (Employee employee : teamList) {
			if (isCEO()) {
				System.out.println(employee.getEmployeeName());
				positionInHierarchy--;
				
			} else if (isManager()) {
				System.out.print(String.format(DISPLAY_FORMAT_MANAGERS, "", employee.getEmployeeName()));
				positionInHierarchy--;
				
			} else if (isEmployee()) {
				
				System.out.println(String.format(DISPLAY_FORMAT_EMPLOYEES, "", employee.getEmployeeName()));
				positionInHierarchy--;
				
			}
			
			if (hasDirectReports(employee)) {
				System.out.println("");
				printHierarchy(teamStructure.get(employee.getEmployeeID()));
			}
			
			positionInHierarchy++;
		}
	}

	public static boolean hasDirectReports(Employee employee) {
		return teamStructure.containsKey(employee.getEmployeeID());
	}

	public static boolean isEmployee() {
		return positionInHierarchy == 1 ? true : false;
	}
	public static boolean isManager() {
		return positionInHierarchy == 2 ? true : false;
	}
	public static boolean isCEO() {
		return positionInHierarchy == 3 ? true : false;
	}
}