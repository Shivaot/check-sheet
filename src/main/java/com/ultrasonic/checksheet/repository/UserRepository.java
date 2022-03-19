package com.ultrasonic.checksheet.repository;

import com.ultrasonic.checksheet.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Shiva Created on 05/03/22
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
