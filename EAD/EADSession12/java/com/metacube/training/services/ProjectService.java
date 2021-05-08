package com.metacube.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.Status.Status;
import com.metacube.training.models.Project;
import com.metacube.training.repository.ProjectRepository;

/**
 * This class contains Business Logic for Project
 * 
 * @author Mohit Sharma
 *
 */
@Service
public class ProjectService {

	@Autowired
	private ProjectRepository<Project> projectRepository;

	/**
	 * Adds Project
	 * 
	 * @param project
	 * @return
	 */
	public Status addProject(Project project) {
		projectRepository.save(project);
		return Status.INSERTED;
	}

	/**
	 * Returns Project By Id
	 * 
	 * @param id
	 * @return
	 */
	public Project getProjectById(int id) {
		return projectRepository.findOne(id);
	}

	/**
	 * Returns All Projects
	 * 
	 * @return
	 */
	public List<Project> getAllProjects() {
		return projectRepository.findAll();
	}

	/**
	 * Deletes Project
	 * 
	 * @param id
	 * @return
	 */
	public Status deleteProject(int id) {
		projectRepository.delete(id);
		return Status.DELETED;
	}

	/**
	 * Updates Project
	 * 
	 * @param project
	 * @return
	 */
	public Status updateProject(Project project) {
		projectRepository.saveAndFlush(project);
		return Status.UPDATED;
	}
}
