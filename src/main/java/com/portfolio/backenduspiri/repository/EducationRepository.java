package com.portfolio.backenduspiri.repository;

import com.portfolio.backenduspiri.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {
    
}
