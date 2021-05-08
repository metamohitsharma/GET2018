package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.models.JobTitle;

/**
 * Interface for Job
 * 
 * @author Mohit Sharma
 *
 * @param <J>
 */
public interface JobRepository<J> extends JpaRepository<JobTitle, Integer> {
}
