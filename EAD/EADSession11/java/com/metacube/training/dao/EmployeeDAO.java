package com.metacube.training.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.Status.Status;
import com.metacube.training.models.Employee;

/**
 * This class is used to contact Database
 * 
 * @author Mohit Sharma
 *
 */
@Repository
@Transactional
@SuppressWarnings("unchecked")
public class EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private final String SQL_FIND_EMPLOYEE = "from Employee where emp_code = :code";
	private final String SQL_UPDATE_EMPLOYEE = "update Employee set first_name = :firstName, middle_name = :middleName, last_name  = :lastName, dob  = :dob, gender = :gender, email_id = :email, skills = :skills where emp_code = :code";
	private final String SQL_GET_ALL = "from Employee";
	private final String SQL_DELETE_EMPLOYEE = "delete from Employee where emp_code = :code";
	private final String SQL_GET_EMPLOYEE_BY_EMAIL = "from Employee where email_id = :email";
	private final String SQL_SEARCH_EMPLOYEE = "from Employee where first_name = :firstName or last_name = :lastName";

	/**
	 * Returns Employee using Email
	 * 
	 * @param emailId
	 * @return
	 */
	public Employee getEmployeeByEmail(String emailId) {
		TypedQuery<Employee> query = sessionFactory.getCurrentSession()
				.createQuery(SQL_GET_EMPLOYEE_BY_EMAIL);
		query.setParameter("email", emailId);
		return query.getSingleResult();
	}

	/**
	 * Returns All Employees
	 * 
	 * @return
	 */
	public List<Employee> getAllEmployees() {
		TypedQuery<Employee> query = sessionFactory.getCurrentSession()
				.createQuery(SQL_GET_ALL);
		return query.getResultList();
	}

	/**
	 * Searches Employee
	 * 
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	public List<Employee> searchEmployee(String firstName, String lastName) {
		TypedQuery<Employee> query = sessionFactory.getCurrentSession()
				.createQuery(SQL_SEARCH_EMPLOYEE);
		query.setParameter("firstName", firstName);
		query.setParameter("firstName", lastName);
		return query.getResultList();
	}

	/**
	 * Returns Employee using Code
	 * 
	 * @param code
	 * @return
	 */
	public Employee getEmployeeByCode(int code) {
		TypedQuery<Employee> query = sessionFactory.getCurrentSession()
				.createQuery(SQL_FIND_EMPLOYEE);
		query.setParameter("code", code);
		return query.getSingleResult();
	}

	/**
	 * Updates Employee
	 * 
	 * @param employee
	 * @return
	 */
	public Status updateEmployee(Employee employee) {
		TypedQuery<Employee> query = sessionFactory.getCurrentSession()
				.createQuery(SQL_UPDATE_EMPLOYEE);
		query.setParameter("firstName", employee.getFirstName());
		query.setParameter("middleName", employee.getMiddleName());
		query.setParameter("lastName", employee.getLastName());
		query.setParameter("dob", employee.getDob());
		query.setParameter("gender", employee.getGender());
		query.setParameter("email", employee.getEmailId());
		query.setParameter("skills", employee.getSkills());
		query.setParameter("code", employee.getCode());
		boolean result = query.executeUpdate() > 0;
		if (result == true) {
			return Status.UPDATED;
		} else {

			return Status.NOT_UPDATED;
		}
	}

	public Status deleteEmployee(int id) {
		TypedQuery<Employee> query = sessionFactory.getCurrentSession()
				.createQuery(SQL_DELETE_EMPLOYEE);
		query.setParameter("code", id);
		if (query.executeUpdate() > 0) {
			return Status.DELETED;
		}
		return Status.NOT_DELETED;
	}

	public Status addEmployee(Employee employee) {
		sessionFactory.getCurrentSession().save(employee);
		return Status.INSERTED;
	}
}
