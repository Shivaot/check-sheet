package com.ultrasonic.checksheet.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

/**
 * Shiva Created on 09/03/22
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(unique = true)
    String partNumber;
    Date dateCreated;

    @PrePersist
    protected void onCreate() {
        dateCreated = new java.sql.Date(System.currentTimeMillis());
    }
}
