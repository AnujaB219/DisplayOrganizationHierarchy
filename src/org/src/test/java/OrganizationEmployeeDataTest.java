package org.src.test.java;
import org.src.main.java.*;

import org.junit.Assert;
import org.junit.Test;


public class OrganizationEmployeeDataTest {
	
	@Test
	public void IsCEOTest() {
		
		Employee employee1 = new Employee("Ray",233);
		Employee employee2 = new Employee("Shena",40, 28);
		
		OrganizationEmployeeData organizationEmployeeData = new OrganizationEmployeeData();
		
		Assert.assertTrue(organizationEmployeeData.isCEO(employee1));
		Assert.assertFalse(organizationEmployeeData.isCEO(employee2));	
	}
	
}
