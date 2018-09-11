package com.metacube.training.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.metacube.training.Status.Status;
import com.metacube.training.dao.SkillsDao;
import com.metacube.training.models.Skills;

/**
 * This class contains Business Logic for Skills
 * 
 * @author Mohit Sharma
 *
 */
@Service
public class SkillsService {
	@Autowired
	private SkillsDao skillsDao;

	/**
	 * Adds Skills
	 * 
	 * @param skill
	 * @return
	 */
	public Status addSkill(Skills skill) {
		return skillsDao.addSkill(skill);
	}

	/**
	 * Returns Skills By Id
	 * 
	 * @param id
	 * @return
	 */
	public Skills getSkillById(int id) {
		return skillsDao.getSkillById(id);
	}

	/**
	 * Returns All Skills
	 * 
	 * @return
	 */
	public List<Skills> getAllSkills() {
		return skillsDao.getAllSkills();
	}

	/**
	 * Deletes Skills
	 * 
	 * @param id
	 * @return
	 */
	public Status deleteSkill(int id) {
		Skills skill = skillsDao.getSkillById(id);
		if (skill == null) {
			return Status.NOT_EXIST;
		} else {
			return skillsDao.deleteSkill(id);
		}
	}

	/**
	 * Updates Skill
	 * 
	 * @param skill
	 * @return
	 */
	public Status updateSkill(Skills skill) {
		List<Skills> listOfSkills = skillsDao.getAllSkills();
		for (Skills existingSkill : listOfSkills) {
			if (skill.getSkillId() == existingSkill.getSkillId()) {
				return skillsDao.updateSkill(skill);
			}
		}
		return Status.NOT_EXIST;
	}
}
