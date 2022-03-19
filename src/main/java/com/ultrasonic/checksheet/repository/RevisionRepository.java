package com.ultrasonic.checksheet.repository;

import com.ultrasonic.checksheet.domain.Revision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * Shiva Created on 05/03/22
 */
public interface RevisionRepository extends JpaRepository<Revision, Long> {

    Optional<Revision> findByRevisionCheckSheetId(Long id);
    Integer countAllByOriginalCheckSheetId(Long id);
    List<Revision> findAllByOriginalCheckSheetId(Long id);
}
