package com.ultrasonic.checksheet.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Shiva Created on 05/03/22
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Revision {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long originalCheckSheetId;
    private Long revisionCheckSheetId;
    private String revisionName;
}
