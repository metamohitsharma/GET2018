package com.metacube.training.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.Status.Status;
import com.metacube.training.models.Skills;

/**
 * This class is used to contact Database
 * 
 * @author Mohit Sharma
 *
 */
@Repository
@Transactional
@SuppressWarnings("unchecked")
public class SkillsDao {

	@Autowired
	SessionFactory sessionFactory;

	private final String SQL_FIND_SKILL = "from Skill where skill_id = :id";
	private final String SQL_DELETE_SKILL = "delete from Skill where skill_id = :id";
	private final String SQL_UPDATE_SKILL = "update Skill set skill_name = :name where skill_id = :id";
	private final String SQL_GET_ALL = "from Skill";

	/**
	 * Adds Skill
	 * 
	 * @param skill
	 * @return
	 */
	public Status addSkill(Skills skill) {
		sessionFactory.getCurrentSession().save(skill);
		return Status.INSERTED;
	}

	/**
	 * Returns All Skills
	 * 
	 * @return
	 */
	public List<Skills> getAllSkills() {
		TypedQuery<Skills> query = sessionFactory.getCurrentSession()
				.createQuery(SQL_GET_ALL);
		return query.getResultList();
	}

	/**
	 * Returns Skill By Id
	 * 
	 * @param id
	 * @return
	 */
	public Skills getSkillById(int id) {
		TypedQuery<Skills> query = sessionFactory.getCurrentSession()
				.createQuery(SQL_FIND_SKILL);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	/**
	 * Updates Skill
	 * 
	 * @param skill
	 * @return
	 */
	public Status updateSkill(Skills skill) {
		TypedQuery<Skills> query = sessionFactory.getCurrentSession()
				.createQuery(SQL_UPDATE_SKILL);
		query.setParameter("name", skill.getSkillName());
		query.setParameter("id", skill.getSkillId());
		if (query.executeUpdate() > 0) {
			return Status.UPDATED;
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
		TypedQuery<Skills> query = sessionFactory.getCurrentSession()
				.createQuery(SQL_DELETE_SKILL);
		query.setParameter("id", id);
		if (query.executeUpdate() > 0) {
			return Status.DELETED;
		}
		return Status.NOT_DELETED;
	}
}
