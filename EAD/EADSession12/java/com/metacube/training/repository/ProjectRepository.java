package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.models.Project;

/**
 * Interface for Project
 * 
 * @author Mohit Sharma
 *
 * @param <P>
 */
public interface ProjectRepository<P> extends JpaRepository<Project, Integer> {
}
