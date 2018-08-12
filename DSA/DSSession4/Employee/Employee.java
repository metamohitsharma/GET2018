package GET2018.DSA.DSSession4.Employee;

import java.util.Comparator;

/**
 * This class contains details of Employee
 * 
 * @author Mohit Sharma
 *
 */
public class Employee implements Comparable<Employee>, Comparator<Employee> {
	private int id;
	private String name;
	private String address;

	public Employee() {
	}

	public Employee(int id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	/**
	 * Compare IDs
	 */
	@Override
	public int compareTo(Employee other) {
		return id - other.getId();
	}

	/**
	 * Compare Names
	 */
	@Override
	public int compare(Employee employee1, Employee employee2) {
		return employee1.getName().compareToIgnoreCase(employee2.getName());
	}
}
