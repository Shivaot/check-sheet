package com.ultrasonic.checksheet.repository;

import com.ultrasonic.checksheet.domain.PartNumber;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Shiva Created on 09/03/22
 */
public interface PartNumberRepository extends JpaRepository<PartNumber, Long> {

    PartNumber findByPartNumber(String name);
}
