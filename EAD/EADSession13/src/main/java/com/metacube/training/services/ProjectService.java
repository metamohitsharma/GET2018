package com.metacube.training.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.metacube.training.Status.Status;
import com.metacube.training.dao.ProjectDao;
import com.metacube.training.models.Project;

/**
 * This class contains Business Logic for Project
 * 
 * @author Mohit Sharma
 *
 */
@Service
public class ProjectService {

	@Autowired
	private ProjectDao projectDao;

	/**
	 * Adds Project
	 * 
	 * @param project
	 * @return
	 */
	public Status addProject(Project project) {
		return projectDao.addProject(project);
	}

	/**
	 * Returns Project By Id
	 * 
	 * @param id
	 * @return
	 */
	public Project getProjectById(int id) {
		return projectDao.getProjectById(id);
	}

	/**
	 * Returns All Projects
	 * 
	 * @return
	 */
	public List<Project> getAllProjects() {
		return projectDao.getAllProjects();
	}

	/**
	 * Deletes Project
	 * 
	 * @param id
	 * @return
	 */
	public Status deleteProject(int id) {
		Project project = projectDao.getProjectById(id);
		if (project == null) {
			return Status.NOT_EXIST;
		} else {
			return projectDao.deleteProject(id);
		}
	}

	/**
	 * Updates Project
	 * 
	 * @param project
	 * @return
	 */
	public Status updateProject(Project project) {
		List<Project> listOfProject = projectDao.getAllProjects();
		for (Project existingProject : listOfProject) {
			if (project.getProjectId() == existingProject.getProjectId()) {
				return projectDao.updateProject(project);
			}
		}
		return Status.NOT_EXIST;
	}
}
