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
import com.metacube.training.models.JobTitle;

/**
 * This class is used to contact Database
 * 
 * @author Mohit Sharma
 *
 */
@Service
public class JobDao {
	private Connection connection;

	/**
	 * Adds Job
	 * 
	 * @param job
	 * @return
	 */
	public Status addJob(JobTitle job) {
		try {
			connection = ConnectionToDB.getConnection();
			String query = Queries.ADD_JOB;
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, job.getJobTitle());
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
	 * Returns All Jobs
	 * 
	 * @return
	 */
	public List<JobTitle> getAllJobs() {
		List<JobTitle> listOfJobs = new ArrayList<JobTitle>();
		try {
			connection = ConnectionToDB.getConnection();
			String query = Queries.GET_ALL_JOBS;
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			JobTitle job;
			while (resultSet.next()) {
				job = new JobTitle();
				job.setJobCode(resultSet.getInt("job_code"));
				job.setJobTitle(resultSet.getString("job_title"));
				listOfJobs.add(job);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return listOfJobs;
	}

	/**
	 * Returns Job using code
	 * 
	 * @param code
	 * @return
	 */
	public JobTitle getJobByCode(int code) {
		JobTitle job = new JobTitle();
		try {
			connection = ConnectionToDB.getConnection();
			String query = Queries.GET_JOB_BY_CODE;
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, code);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				job.setJobCode(resultSet.getInt("job_code"));
				job.setJobTitle(resultSet.getString("job_title"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return job;
	}

	/**
	 * Updates Job
	 * 
	 * @param job
	 * @return
	 */
	public Status updateJob(JobTitle job) {
		try {
			connection = ConnectionToDB.getConnection();
			String query = Queries.UPDATE_JOB;
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, job.getJobTitle());
			statement.setInt(2, job.getJobCode());
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
	 * Deletes Job
	 * 
	 * @param code
	 * @return
	 */
	public Status deleteJob(int code) {
		try {
			connection = ConnectionToDB.getConnection();
			String query = Queries.DELETE_JOB;
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, code);
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
