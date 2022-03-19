package com.ultrasonic.checksheet.repository;

import com.ultrasonic.checksheet.domain.JointRange;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Shiva Created on 09/03/22
 */
public interface RangeRepository extends JpaRepository<JointRange, Long> {
}
