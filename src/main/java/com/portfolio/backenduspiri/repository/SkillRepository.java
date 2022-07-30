package com.portfolio.backenduspiri.repository;

import com.portfolio.backenduspiri.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
    
}
