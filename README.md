# DisplayOrganizationHierarchy
 This is a command line application that prints organization hierarchy.
  
------------------------------------------------------------------------

Description

The application has the following data as a List of Employees:

[Employee Name    ID      ManagerID]

Alan		        100       150,
Martin          220       100,
Jamie           150     ,
Alex            275       100,
Dave            300       400,
Suzie           234       400,
Steve           400       150,
David           190       400


It outputs the hierarchy as shown below:

Jamie

     Alan      
           Martin    
           Alex      
           Ray       
     Steve     
           Dave      
           Suzie     
           David    


Assumptions:

1.	The only Employee who can be without a managerID is the CEO. All others would have a manager ID.
2.	The seniority level (hierarchy) is only 3 levels deep –CEO/ managers/ employees.



# Data Representation:

## Design In Java

Abstractions:
1.	Employee    : An Entity encapsulating a person who is an Employee.
State - Name/ ID/ ManagerID
Behavior - Create Employees. (All Employees must have a name and an id.) 


2.	OrganizationalData 
   State - Map teamStructure which maps managers to the teams (List of direct reports).
   Behavior - Provides employee Data for an organization.

3.	DisplayStructure  Has-A  OrganisationData.  
    State - int positionInHierarchy 
    Behavior - printHierarchy() given a List of teammates for a manager.


Scenarios Considered:

1.	Invalid Employees : Reinforce supplying name/ID for an employee with the Constructor. 	
2.	Data Source Change: Easily change the interface “OrganisationData /defineTeamStructure” to populate data from the specific data source without affecting other classes/Interfaces.
3.	Corrupt Employee IDs:  Having employee data in the ArrayList as employee objects doesn’t check unique constraint for the employee ID key. However, in practical scenarios, we will have data from a reliable source viz. an SQL table. So, this case would be taken care of. 
