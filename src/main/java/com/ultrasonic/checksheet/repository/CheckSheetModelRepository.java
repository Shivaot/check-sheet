package com.ultrasonic.checksheet.repository;

import com.ultrasonic.checksheet.domain.CheckSheetModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Shiva Created on 09/03/22
 */
public interface CheckSheetModelRepository extends JpaRepository<CheckSheetModel, Long> {

    CheckSheetModel findByModelName(String name);
}
