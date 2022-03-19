package com.ultrasonic.checksheet.repository;

import com.ultrasonic.checksheet.domain.CheckSheet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Shiva Created on 05/03/22
 */
public interface CheckSheetRepository extends JpaRepository<CheckSheet, Long> {

    List<CheckSheet> findAllByIsCurrentRevisionOrderByIdDesc(boolean b);
}
