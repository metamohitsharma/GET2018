package com.metacube.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.metacube.training.Status.Status;
import com.metacube.training.models.JobTitle;
import com.metacube.training.repository.JobRepository;

/**
 * This class contains Business Logic for Job
 * 
 * @author Mohit Sharma
 *
 */
@Service
public class JobService {

	@Autowired
	private JobRepository<JobTitle> jobRepository;

	/**
	 * Adds Job
	 * 
	 * @param job
	 * @return
	 */
	public Status addJob(JobTitle job) {
		jobRepository.save(job);
		return Status.INSERTED;
	}

	/**
	 * Returns Job By code
	 * 
	 * @param code
	 * @return
	 */
	public JobTitle getJobByCode(int code) {
		return jobRepository.findOne(code);
	}

	/**
	 * Returns All Jobs
	 * 
	 * @return
	 */
	public List<JobTitle> getAllJobs() {
		return jobRepository.findAll();
	}

	/**
	 * Deletes Job
	 * 
	 * @param code
	 * @return
	 */
	public Status deleteJob(int code) {
		jobRepository.delete(code);
		return Status.DELETED;
	}

	/**
	 * Updates Job
	 * 
	 * @param job
	 * @return
	 */
	public Status updateJob(JobTitle job) {
		jobRepository.saveAndFlush(job);
		return Status.UPDATED;
	}
}
