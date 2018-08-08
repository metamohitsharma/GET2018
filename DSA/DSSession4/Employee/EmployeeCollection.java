package GET2018.DSA.DSSession4.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class performs various methods for Employee class
 * 
 * @author Mohit Sharma
 */
public class EmployeeCollection {
	Set<Integer> idSet = new HashSet<Integer>();
	List<Employee> employeeList = new ArrayList<Employee>();

	/**
	 * Adds Employee in employeeList
	 * 
	 * @param id
	 * @param name
	 * @param address
	 * @throws EmployeeException
	 */
	public boolean addEmployee(int id, String name, String address)
			throws EmployeeException {
		if (name == null || address == null) {
			throw new NullPointerException("Name or Address can't be Null");
		}

		// Checking if the given ID is not Duplicate
		if (!idSet.contains(id)) {
			idSet.add(id);
			employeeList.add(new Employee(id, name, address));
		} else {
			throw new EmployeeException("Duplicate Employee ID are not Allowed");
		}
		return true;
	}

	/**
	 * Sorting Employees on the basis of ID
	 * 
	 * @return
	 */
	public List<Employee> sortEmployeeInNaturalOrder() {
		List<Employee> sortbyID = new ArrayList<Employee>(employeeList);
		Collections.sort(sortbyID);
		return sortbyID;
	}

	/**
	 * Sorting Employees on the basis of EmployeeName
	 * 
	 * @return
	 */
	public List<Employee> sortEmployeeByName() {
		List<Employee> sortByName = new ArrayList<Employee>(employeeList);
		Collections.sort(sortByName, new SortByName());
		return sortByName;
	}
}
