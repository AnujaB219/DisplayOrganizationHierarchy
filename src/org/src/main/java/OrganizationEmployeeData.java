
package org.src.main.java;

import java.util.Map;
import java.util.TreeMap;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class OrganizationEmployeeData {

	private int ID_CEO = 1;
	private Map<Integer, List<Employee>> teamStructure = new TreeMap<Integer, List<Employee>>();

	public int getID_CEO() {
		return ID_CEO;
	}

	public void setID_CEO(int id) {
		ID_CEO = id;
	}

	public Map<Integer, List<Employee>> teamStructure() {
		return teamStructure;
	}

	public void setTeamStructure(Map<Integer, List<Employee>> teams) {
		teamStructure = teams;
	}

	public void defineTeamStructure() {

		List<Employee> employees = getAllEmployeesForTheOraganization();
		Map<Integer, List<Employee>> teamStructure = new TreeMap<Integer, List<Employee>>();

		/*
		 * Build the map as per the manager-employee relationship specified in the
		 * employees list
		 */
		employees.forEach(employee -> {
			if (isCEO(employee)) {
				employee.setManagerID(ID_CEO);
			}
			if (!managerExistsInTeamStructureMap(teamStructure, employee)) {
				/*Create a new entry in the team Structure map, with key as the
				 * id of this employee's manager*/
				teamStructure.put(employee.getManagerID(), new ArrayList<Employee>());
			}
			
			/*Add the employee to the list of team mates for the Manager*/
			teamStructure.get(employee.getManagerID()).add(employee);
		});

		setTeamStructure(teamStructure);

	}
	
	public boolean managerExistsInTeamStructureMap (Map<Integer, List<Employee>> teamStructure, Employee employee) {
		return teamStructure.containsKey(employee.getManagerID());
	}
	
	public boolean isCEO(Employee employee) {
		return employee.getManagerID() == 0 ? true: false;
	}
	
	public List<Employee> getAllEmployeesForTheOraganization () {
		
		return Arrays.asList(new Employee("Alan", 100, 150), 
							new Employee("Martin", 220, 100),
							new Employee("Jamie", 150), 
							new Employee("Alex", 275, 100), 
							new Employee("Dave", 300, 400),
							new Employee("Suzie", 234, 400), 
							new Employee("Ray", 298, 100), 
							new Employee("Steve", 400, 150),
							new Employee("David", 190, 400));
	}
}
