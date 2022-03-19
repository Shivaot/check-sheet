package com.ultrasonic.checksheet.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Shiva Created on 05/03/22
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckSheet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date dateCreated = new Date(System.currentTimeMillis());

    // Joint 1
    private BigDecimal J7RW;
    private BigDecimal J7RY;
    private BigDecimal J7RH;
    private BigDecimal J7RD;
    private BigDecimal J7RL;
    private BigDecimal J7RP;
    private String J7R_JUDGEMENT;

    private BigDecimal J12LW;
    private BigDecimal J12LY;
    private BigDecimal J12LH;
    private BigDecimal J12LD;
    private BigDecimal J12LL;
    private BigDecimal J12LP;
    private String J12L_JUDGEMENT;

    // Joint 2
    private BigDecimal J8RW;
    private BigDecimal J8RY;
    private BigDecimal J8RH;
    private BigDecimal J8RD;
    private BigDecimal J8RL;
    private BigDecimal J8RP;
    private String J8R_JUDGEMENT;

    private BigDecimal J13LW;
    private BigDecimal J13LY;
    private BigDecimal J13LH;
    private BigDecimal J13LD;
    private BigDecimal J13LL;
    private BigDecimal J13LP;
    private String J13L_JUDGEMENT;

    // Joint 3
    private BigDecimal J11RW;
    private BigDecimal J11RY;
    private BigDecimal J11RH;
    private BigDecimal J11RD;
    private BigDecimal J11RL;
    private BigDecimal J11RP;
    private String J11R_JUDGEMENT;

    private BigDecimal J16LW;
    private BigDecimal J16LY;
    private BigDecimal J16LH;
    private BigDecimal J16LD;
    private BigDecimal J16LL;
    private BigDecimal J16LP;
    private String J16L_JUDGEMENT;

    // Joint 4
    private BigDecimal J5W;
    private BigDecimal J5Y;
    private BigDecimal J5H;
    private BigDecimal J5D;
    private BigDecimal J5L;
    private BigDecimal J5P;
    private String J5_JUDGEMENT;

    // Joint 5
    private BigDecimal J9RW;
    private BigDecimal J9RY;
    private BigDecimal J9RH;
    private BigDecimal J9RD;
    private BigDecimal J9RL;
    private BigDecimal J9RP;
    private String J9R_JUDGEMENT;

    private BigDecimal J14LW;
    private BigDecimal J14LY;
    private BigDecimal J14LH;
    private BigDecimal J14LD;
    private BigDecimal J14LL;
    private BigDecimal J14LP;
    private String J14L_JUDGEMENT;

    // Joint 6
    private BigDecimal J6W;
    private BigDecimal J6Y;
    private BigDecimal J6H;
    private BigDecimal J6D;
    private BigDecimal J6L;
    private BigDecimal J6P;
    private String J6_JUDGEMENT;

    // Joint 7
    private BigDecimal J2W;
    private BigDecimal J2Y;
    private BigDecimal J2H;
    private BigDecimal J2D;
    private BigDecimal J2L;
    private BigDecimal J2P;
    private String J2_JUDGEMENT;

    // Joint 8
    private BigDecimal J10RW;
    private BigDecimal J10RY;
    private BigDecimal J10RH;
    private BigDecimal J10RD;
    private BigDecimal J10RL;
    private BigDecimal J10RP;
    private String J10R_JUDGEMENT;

    private BigDecimal J15LW;
    private BigDecimal J15LY;
    private BigDecimal J15LH;
    private BigDecimal J15LD;
    private BigDecimal J15LL;
    private BigDecimal J15LP;
    private String J15L_JUDGEMENT;

    // Joint 9
    private BigDecimal J3W;
    private BigDecimal J3Y;
    private BigDecimal J3H;
    private BigDecimal J3D;
    private BigDecimal J3L;
    private BigDecimal J3P;
    private String J3_JUDGEMENT;

    private String model;
    private String partName;
    private String partNumber;
    private String punchNumber;
    private String CHUB;
    private String FHUB;
    private String inspector;

    private Boolean isCurrentRevision;

}
