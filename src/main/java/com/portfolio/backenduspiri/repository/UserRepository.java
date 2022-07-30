package com.portfolio.backenduspiri.repository;

import com.portfolio.backenduspiri.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Person, Long> {
    
}
