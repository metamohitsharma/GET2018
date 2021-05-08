package com.metacube.training.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.Status.Status;
import com.metacube.training.models.JobTitle;

/**
 * This class is used to contact Database
 * 
 * @author Mohit Sharma
 *
 */
@Repository
@Transactional
@SuppressWarnings("unchecked")
public class JobDao {
	@Autowired
	SessionFactory sessionFactory;

	private final String SQL_FIND_JOB = "from Job where job_code = :id";
	private final String SQL_DELETE_JOB = "delete from Job where job_code = :id";
	private final String SQL_UPDATE_JOB = "update Job set job_title = :title where job_code = :id";
	private final String SQL_GET_ALL = "from Job";

	/**
	 * Adds Job
	 * 
	 * @param job
	 * @return
	 */
	public Status addJob(JobTitle job) {
		sessionFactory.getCurrentSession().save(job);
		return Status.INSERTED;
	}

	/**
	 * Returns All Jobs
	 * 
	 * @return
	 */
	public List<JobTitle> getAllJobs() {
		TypedQuery<JobTitle> query = sessionFactory.getCurrentSession()
				.createQuery(SQL_GET_ALL);
		return query.getResultList();
	}

	/**
	 * Return Job by code
	 * 
	 * @param code
	 * @return
	 */
	public JobTitle getJobByCode(int code) {
		TypedQuery<JobTitle> query = sessionFactory.getCurrentSession()
				.createQuery(SQL_FIND_JOB);
		query.setParameter("code", code);
		return query.getSingleResult();
	}

	/**
	 * Updates Job
	 * 
	 * @param job
	 * @return
	 */
	public Status updateJob(JobTitle job) {
		TypedQuery<JobTitle> query = sessionFactory.getCurrentSession()
				.createQuery(SQL_UPDATE_JOB);
		query.setParameter("title", job.getJobTitle());
		query.setParameter("code", job.getJobCode());
		if (query.executeUpdate() > 0) {
			return Status.UPDATED;
		}
		return Status.NOT_UPDATED;
	}

	/**
	 * Deletes Job
	 * 
	 * @param code
	 * @return
	 */
	public Status deleteJob(int code) {
		TypedQuery<JobTitle> query = sessionFactory.getCurrentSession()
				.createQuery(SQL_DELETE_JOB);
		query.setParameter("code", code);
		if (query.executeUpdate() > 0) {
			return Status.DELETED;
		}
		return Status.NOT_DELETED;
	}
}
