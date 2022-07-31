package com.portfolio.backenduspiri.repository;

import com.portfolio.backenduspiri.model.Image;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    
    public List<Image> findByPersonId( Long id );
    
}
