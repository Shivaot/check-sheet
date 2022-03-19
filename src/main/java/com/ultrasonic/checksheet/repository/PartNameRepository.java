package com.ultrasonic.checksheet.repository;

import com.ultrasonic.checksheet.domain.PartName;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Shiva Created on 09/03/22
 */
public interface PartNameRepository extends JpaRepository<PartName, Long> {

    PartName findByName(String name);
}
