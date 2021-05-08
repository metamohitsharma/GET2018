package com.metacube.training.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.Status.Status;
import com.metacube.training.models.Project;

/**
 * This class is used to contact Database
 * 
 * @author Mohit Sharma
 *
 */
@Repository
@Transactional
@SuppressWarnings("unchecked")
public class ProjectDao {
	@Autowired
	private SessionFactory sessionFactory;

	private final String SQL_FIND_PROJECT = "from Project where project_id = :projectId";
	private final String SQL_DELETE_PROJECT = "delete from Project where project_id = :projectId";
	private final String SQL_UPDATE_PROJECT = "update Project set project_name = :name, description = :description, start_date  = :startDate, end_date  = :endDate, project_logo = :logo where project_id = :projectId";
	private final String SQL_GET_ALL = "from Project";

	/**
	 * Adds Project
	 * 
	 * @param project
	 * @return
	 */
	public Status addProject(Project project) {
		sessionFactory.getCurrentSession().save(project);
		return Status.INSERTED;
	}

	/**
	 * Returns All Projects
	 * 
	 * @return
	 */
	public List<Project> getAllProjects() {
		TypedQuery<Project> query = sessionFactory.getCurrentSession()
				.createQuery(SQL_GET_ALL);
		return query.getResultList();
	}

	/**
	 * Returns Project using Id
	 * 
	 * @param id
	 * @return
	 */
	public Project getProjectById(int id) {
		TypedQuery<Project> query = sessionFactory.getCurrentSession()
				.createQuery(SQL_FIND_PROJECT);
		query.setParameter("projectID", id);
		return query.getSingleResult();
	}

	/**
	 * Updates Project
	 * 
	 * @param project
	 * @return
	 */
	public Status updateProject(Project project) {
		TypedQuery<Project> query = sessionFactory.getCurrentSession()
				.createQuery(SQL_UPDATE_PROJECT);
		query.setParameter("name", project.getName());
		query.setParameter("description", project.getDescription());
		query.setParameter("startDate", project.getStartDate());
		query.setParameter("endDate", project.getEndDate());
		query.setParameter("projectLogo", project.getProjectLogo());
		if (query.executeUpdate() > 0) {
			return Status.UPDATED;
		}
		return Status.NOT_UPDATED;
	}

	/**
	 * Deletes Project
	 * 
	 * @param id
	 * @return
	 */
	public Status deleteProject(int id) {
		TypedQuery<Project> query = sessionFactory.getCurrentSession()
				.createQuery(SQL_DELETE_PROJECT);
		query.setParameter("projectID", id);
		if (query.executeUpdate() > 0) {
			return Status.DELETED;
		}
		return Status.NOT_DELETED;
	}
}
