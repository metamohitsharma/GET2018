package GET2018.DSA.DSSession4.Employee;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * This class performs various tests on EmployeeCollection class
 * 
 * @author Mohit Sharma
 *
 */
public class EmployeeTest {

	EmployeeCollection employee;

	@Rule
	public ExpectedException ex = ExpectedException.none();

	@Before
	public void initialize() throws EmployeeException {
		employee = new EmployeeCollection();
		employee.addEmployee(2, "Mohit", "Jaipur");
		employee.addEmployee(1, "Shubham", "UttarPradesh");
		employee.addEmployee(5, "Dipanshu", "Ajmer");
		employee.addEmployee(7, "Chirag", "Udaipur");
		employee.addEmployee(3, "Ayushi", "Jaipur");
	}

	@Test
	public void addEmployeeTest() throws EmployeeException {
		// Adding Employee
		assertTrue(employee.addEmployee(4, "Rajendra", "Bhilwara"));
	}

	@Test
	public void employeeNaturalSort() throws EmployeeException {
		// Sorting Employee on the basis of ID
		List<Employee> sortedEmployees = employee.sortEmployeeInNaturalOrder();
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee(1, "Shubham", "UttarPradesh"));
		employees.add(new Employee(2, "Mohit", "Jaipur"));
		employees.add(new Employee(3, "Ayushi", "Jaipur"));
		employees.add(new Employee(5, "Dipanshu", "Ajmer"));
		employees.add(new Employee(7, "Chirag", "Udaipur"));
		for (int i = 0; i < sortedEmployees.size(); i++) {
			assertEquals(employees.get(i).getId(), sortedEmployees.get(i)
					.getId());
			assertEquals(employees.get(i).getName(), sortedEmployees.get(i)
					.getName());
			assertEquals(employees.get(i).getAddress(), sortedEmployees.get(i)
					.getAddress());
		}
	}

	@Test
	public void employeeSortByName() throws EmployeeException {
		// Sorting Employees on the basis of Name
		List<Employee> sortedEmployees = employee.sortEmployeeByName();
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee(3, "Ayushi", "Jaipur"));
		employees.add(new Employee(7, "Chirag", "Udaipur"));
		employees.add(new Employee(5, "Dipanshu", "Ajmer"));
		employees.add(new Employee(2, "Mohit", "Jaipur"));
		employees.add(new Employee(1, "Shubham", "UttarPradesh"));
		for (int i = 0; i < sortedEmployees.size(); i++) {
			assertEquals(employees.get(i).getId(), sortedEmployees.get(i)
					.getId());
			assertEquals(employees.get(i).getName(), sortedEmployees.get(i)
					.getName());
			assertEquals(employees.get(i).getAddress(), sortedEmployees.get(i)
					.getAddress());
		}
	}

	@Test
	public void addEmployeeWithSameIDException() throws EmployeeException {
		// Adding Employee having Duplicate ID
		ex.expect(EmployeeException.class);
		ex.expectMessage("Duplicate Employee ID are not Allowed");
		employee.addEmployee(2, "Somi", "Jaipur");
	}

	@Test
	public void addEmployeeWithNullException() throws EmployeeException {
		// Adding Employee having Name Null
		ex.expect(NullPointerException.class);
		ex.expectMessage("Name or Address can't be Null");
		employee.addEmployee(10, null, "Jaipur");
	}
}
