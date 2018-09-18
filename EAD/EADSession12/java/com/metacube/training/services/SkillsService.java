package com.metacube.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.Status.Status;
import com.metacube.training.models.Skills;
import com.metacube.training.repository.SkillRepository;

/**
 * This class contains Business Logic for Skills
 * 
 * @author Mohit Sharma
 *
 */
@Service
public class SkillsService {
	@Autowired
	private SkillRepository<Skills> skillRepository;

	/**
	 * Adds Skills
	 * 
	 * @param skill
	 * @return
	 */
	public Status addSkill(Skills skill) {
		skillRepository.save(skill);
		return Status.INSERTED;
	}

	/**
	 * Returns Skills By Id
	 * 
	 * @param id
	 * @return
	 */
	public Skills getSkillById(int id) {
		return skillRepository.findOne(id);
	}

	/**
	 * Returns All Skills
	 * 
	 * @return
	 */
	public List<Skills> getAllSkills() {
		return skillRepository.findAll();
	}

	/**
	 * Deletes Skills
	 * 
	 * @param id
	 * @return
	 */
	public Status deleteSkill(int id) {
		skillRepository.delete(id);
		return Status.DELETED;
	}

	/**
	 * Updates Skill
	 * 
	 * @param skill
	 * @return
	 */
	public Status updateSkill(Skills skill) {
		skillRepository.saveAndFlush(skill);
		return Status.UPDATED;
	}
}
