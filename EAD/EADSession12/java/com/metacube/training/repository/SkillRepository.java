package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.metacube.training.models.Skills;

/**
 * Interface for Skills
 * 
 * @author Mohit Sharma
 *
 * @param <S>
 */
public interface SkillRepository<S> extends JpaRepository<Skills, Integer> {
}
