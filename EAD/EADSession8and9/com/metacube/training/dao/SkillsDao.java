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
import com.metacube.training.models.Skills;

/**
 * This class is used to contact Database
 * 
 * @author Mohit Sharma
 *
 */
@Service
public class SkillsDao {

	private Connection connection;

	/**
	 * Adds Skill
	 * 
	 * @param skill
	 * @return
	 */
	public Status addSkill(Skills skill) {
		try {
			connection = ConnectionToDB.getConnection();
			String query = Queries.ADD_SKILL;
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, skill.getSkillName());
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
	 * Returns All Skills
	 * 
	 * @return
	 */
	public List<Skills> getAllSkills() {
		List<Skills> listOfSkills = new ArrayList<Skills>();
		try {
			connection = ConnectionToDB.getConnection();
			String query = Queries.GET_ALL_SKILLS;
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			Skills skill;
			while (resultSet.next()) {
				skill = new Skills();
				skill.setSkillId(resultSet.getInt("skill_id"));
				skill.setSkillName(resultSet.getString("skill_name"));
				listOfSkills.add(skill);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return listOfSkills;
	}

	/**
	 * Returns Skill By Id
	 * 
	 * @param id
	 * @return
	 */
	public Skills getSkillById(int id) {
		Skills skill = new Skills();
		try {
			connection = ConnectionToDB.getConnection();
			String query = Queries.GET_SKILL_BY_ID;
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				skill.setSkillId(resultSet.getInt("skil_id"));
				skill.setSkillName(resultSet.getString("skill_name"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return skill;
	}

	/**
	 * Updates Skill
	 * 
	 * @param skill
	 * @return
	 */
	public Status updateSkill(Skills skill) {
		try {
			connection = ConnectionToDB.getConnection();
			String query = Queries.UPDATE_PROJECT;
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, skill.getSkillName());
			statement.setInt(2, skill.getSkillId());
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
	 * Deletes Skill
	 * 
	 * @param id
	 * @return
	 */
	public Status deleteSkill(int id) {
		try {
			connection = ConnectionToDB.getConnection();
			String query = Queries.DELETE_SKILL;
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
