package com.ultrasonic.checksheet.bootstrap;

import com.ultrasonic.checksheet.domain.JointRange;
import com.ultrasonic.checksheet.domain.User;
import com.ultrasonic.checksheet.repository.RangeRepository;
import com.ultrasonic.checksheet.repository.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


/**
 * Shiva Created on 05/03/22
 */
@Component
public class DataLoader implements ApplicationRunner {

    private final UserRepository userRepository;
    private final RangeRepository rangeRepository;

    public DataLoader(UserRepository userRepository, RangeRepository rangeRepository) {
        this.userRepository = userRepository;
        this.rangeRepository = rangeRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws NoSuchFieldException {

        Math.sin(Math.toDegrees(new BigDecimal("12.00").doubleValue()));

//        User user = userRepository.findByEmail("operator@mail.in");
//        Class email = user.getClass();
//        Field field = email.getDeclaredField("email");
//        field.setAccessible(true);
        if (userRepository.count() < 2) {
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            addUser(passwordEncoder, "operator@mail.in", "ROLE_OPERATOR");
            addUser(passwordEncoder, "admin@mail.in", "ROLE_ADMIN");
        }

        if (rangeRepository.count() < 1) {
            JointRange jointRange = new JointRange();
            rangeRepository.save(jointRange);
        }


    }

    private void addUser(PasswordEncoder passwordEncoder, String emails, String role) {
        User operator = new User();
        operator.setEmail(emails);
        operator.setEnabled(true);
        operator.setPassword(passwordEncoder.encode("pass"));
        operator.setRole(role);
        userRepository.save(operator);
    }
}
