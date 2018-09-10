package com.metacube.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.metacube.training.Query.Queries;
import com.metacube.training.Status.Status;
import com.metacube.training.models.Project;

/**
 * This class is used to contact Database
 * 
 * @author Mohit Sharma
 *
 */
@Service
public class ProjectDao {
	private Connection connection;

	/**
	 * Adds Project
	 * 
	 * @param project
	 * @return
	 */
	public Status addProject(Project project) {
		try {
			connection = ConnectionToDB.getConnection();
			String query = Queries.ADD_PROJECT;
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, project.getName());
			statement.setString(2, project.getDescription());
			statement.setDate(3, project.getStartDate());
			statement.setDate(4, project.getEndDate());
			statement.setString(5, project.getProjectLogo());
			int result = statement.executeUpdate();
			if (result > 0) {
				return Status.INSERTED;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return Status.NOT_INSERTED;
	}

	/**
	 * Returns All Projects
	 * 
	 * @return
	 */
	public List<Project> getAllProjects() {
		List<Project> listOfProject = new ArrayList<Project>();
		try {
			connection = ConnectionToDB.getConnection();
			String query = Queries.GET_ALL_PROJECTS;
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			Project project;
			while (resultSet.next()) {
				project = new Project();
				project.setProjectId(resultSet.getInt("project_id"));
				project.setName(resultSet.getString("name"));
				project.setDescription(resultSet.getString("description"));
				project.setStartDate(resultSet.getDate("start_date"));
				project.setEndDate(resultSet.getDate("end_date"));
				project.setProjectLogo(resultSet.getString("project_logo"));
				listOfProject.add(project);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return listOfProject;
	}

	/**
	 * Returns Project using Id
	 * 
	 * @param id
	 * @return
	 */
	public Project getProjectById(int id) {
		Project project = new Project();
		try {
			connection = ConnectionToDB.getConnection();
			String query = Queries.GET_PROJECT_BY_ID;
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				project.setProjectId(resultSet.getInt("project_id"));
				project.setName(resultSet.getString("name"));
				project.setDescription(resultSet.getString("description"));
				project.setStartDate(resultSet.getDate("start_date"));
				project.setEndDate(resultSet.getDate("end_date"));
				project.setProjectLogo(resultSet.getString("project_logo"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return project;
	}

	/**
	 * Updates Project
	 * 
	 * @param project
	 * @return
	 */
	public Status updateProject(Project project) {
		try {
			connection = ConnectionToDB.getConnection();
			String query = Queries.UPDATE_PROJECT;
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, project.getName());
			statement.setString(2, project.getDescription());
			statement.setDate(3, project.getStartDate());
			statement.setDate(4, project.getEndDate());
			statement.setString(5, project.getProjectLogo());
			statement.setInt(6, project.getProjectId());
			int result = statement.executeUpdate();
			if (result > 0) {
				return Status.UPDATED;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
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
		try {
			connection = ConnectionToDB.getConnection();
			String query = Queries.DELETE_PROJECT;
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			int result = statement.executeUpdate();
			if (result > 0) {
				return Status.DELETED;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return Status.NOT_DELETED;
	}
}
