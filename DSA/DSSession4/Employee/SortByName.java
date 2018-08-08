package GET2018.DSA.DSSession4.Employee;

import java.util.Comparator;

/**
 * Implementing Comparator for custom Sorting for EmployeeName
 * 
 * @author Mohit Sharma
 *
 */
public class SortByName implements Comparator<Employee> {

	@Override
	public int compare(Employee employee1, Employee employee2) {
		return employee1.getName().compareToIgnoreCase(employee2.getName());
	}
}
